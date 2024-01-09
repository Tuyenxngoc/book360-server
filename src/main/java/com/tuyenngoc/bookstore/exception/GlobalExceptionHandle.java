package com.tuyenngoc.bookstore.exception;

import com.tuyenngoc.bookstore.base.RestData;
import com.tuyenngoc.bookstore.base.VsResponseUtil;
import com.tuyenngoc.bookstore.constant.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandle {

    private final MessageSource messageSource;

    /**
     * Xử lý ngoại lệ chung
     *
     * @param ex Ngoại lệ Exception
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 500 Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestData<?>> handlerInternalServerError(Exception ex) {
        log.error("Internal Server Error: {}", ex.getMessage(), ex);
        String message = messageSource.getMessage(ErrorMessage.ERR_EXCEPTION_GENERAL, null, LocaleContextHolder.getLocale());
        return VsResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * Xử lý ngoại lệ khi có lỗi xảy ra do vi phạm ràng buộc.
     *
     * @param ex Ngoại lệ ConstraintViolationException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 400 Bad Request
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> result = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach((error) -> {
            String fieldName = ((PathImpl) error.getPropertyPath()).getLeafNode().getName();
            String errorMessage = messageSource.getMessage(Objects.requireNonNull(error.getMessage()), null,
                    LocaleContextHolder.getLocale());
            result.put(fieldName, errorMessage);
        });
        return VsResponseUtil.error(HttpStatus.BAD_REQUEST, result);
    }

    /**
     * Xử lý ngoại lệ khi có lỗi xảy ra trong quá trình binding dữ liệu.
     *
     * @param ex Ngoại lệ BindException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 400 Bad Request
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleValidException(BindException ex) {
        Map<String, String> result = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = messageSource.getMessage(Objects.requireNonNull(error.getDefaultMessage()), null,
                    LocaleContextHolder.getLocale());
            result.put(fieldName, errorMessage);
        });
        return VsResponseUtil.error(HttpStatus.BAD_REQUEST, result);
    }

    /**
     * Xử lý ngoại lệ khi không tìm thấy tài nguyên.
     *
     * @param ex Ngoại lệ NotFoundException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 404 Not Found
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestData<?>> handlerNotFoundException(NotFoundException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        log.error(message, ex);
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi có yêu cầu không hợp lệ.
     *
     * @param ex Ngoại lệ InvalidException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 400 Bad Request
     */
    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handlerInvalidException(InvalidException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        log.error(message, ex);
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi có lỗi trong quá trình tải lên tệp tin.
     *
     * @param ex Ngoại lệ UploadFileException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 502 Bad Gateway
     */
    @ExceptionHandler(UploadFileException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<RestData<?>> handleUploadImageException(UploadFileException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        log.error(message, ex);
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi người dùng không có quyền truy cập.
     *
     * @param ex Ngoại lệ UnauthorizedException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 401 Unauthorized
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<RestData<?>> handleUnauthorizedException(UnauthorizedException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi người dùng không có quyền truy cập.
     *
     * @param ex Ngoại lệ ForbiddenException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 403 Forbidden
     */
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<RestData<?>> handleAccessDeniedException(ForbiddenException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        log.error(message, ex);
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi có lỗi Integrity Violation trong cơ sở dữ liệu.
     *
     * @param ex Ngoại lệ DataIntegrityViolationException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 409
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<RestData<?>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
        log.error(message, ex);
        return VsResponseUtil.error(ex.getStatus(), message);
    }

    /**
     * Xử lý ngoại lệ khi yêu cầu không có nội dung.
     *
     * @param ex Ngoại lệ HttpMessageNotReadableException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 400 Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("Required request body is missing: {}", ex.getMessage(), ex);
        String message = messageSource.getMessage(ErrorMessage.REQUIRED_REQUEST_BODY_MISSING, null, LocaleContextHolder.getLocale());
        return VsResponseUtil.error(HttpStatus.BAD_REQUEST, message);
    }

    /**
     * Xử lý ngoại lệ khi phương thức HTTP không được hỗ trợ.
     *
     * @param ex Ngoại lệ HttpRequestMethodNotSupportedException
     * @return ResponseEntity chứa thông tin lỗi và mã HTTP 405 Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<RestData<?>> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        log.error("HTTP method not supported: {}", ex.getMessage(), ex);
        String message = messageSource.getMessage(ErrorMessage.METHOD_NOT_SUPPORTED, null, LocaleContextHolder.getLocale());
        return VsResponseUtil.error(HttpStatus.METHOD_NOT_ALLOWED, message);
    }

}
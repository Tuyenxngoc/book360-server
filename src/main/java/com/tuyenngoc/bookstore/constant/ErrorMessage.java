package com.tuyenngoc.bookstore.constant;

public class ErrorMessage {

    public static final String ERR_EXCEPTION_GENERAL = "exception.general";
    public static final String ERR_UNAUTHORIZED = "exception.unauthorized";
    public static final String ERR_FORBIDDEN = "exception.forbidden";
    public static final String ERR_FORBIDDEN_UPDATE_DELETE = "exception.forbidden.update-delete";
    public static final String ERR_METHOD_NOT_SUPPORTED = "exception.method-not-supported";
    public static final String ERR_REQUEST_BODY = "exception.required-request-body-missing";
    public static final String ERR_REQUIRED_MISSING_PARAMETER = "exception.missing-servlet-request-parameter";
    public static final String ERR_METHOD_ARGUMENT_TYPE_MISMATCH = "exception.method-argument-type-mismatch";
    public static final String ERR_RESOURCE_NOT_FOUND = "exception.resource-not-found";
    public static final String ERR_MISSING_SERVLET_REQUEST_PART = "exception.request.part.missing";
    public static final String ERR_UNSUPPORTED_MEDIA_TYPE = "exception.unsupported.media.type";
    public static final String ERR_MULTIPART_EXCEPTION = "exception.multipart";
    public static final String ERR_ILLEGAL_ARGUMENT = "exception.illegal-arguments";

    public static final String INVALID_SOME_THING_FIELD = "invalid.general";
    public static final String INVALID_FORMAT_SOME_THING_FIELD = "invalid.general.format";
    public static final String INVALID_NUMBER_FORMAT = "invalid.general.number-format";
    public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "invalid.general.required";
    public static final String INVALID_ARRAY_IS_REQUIRED = "invalid.array.required";
    public static final String INVALID_ARRAY_NOT_EMPTY = "invalid.array.not.empty";
    public static final String INVALID_NOT_BLANK_FIELD = "invalid.general.not-blank";
    public static final String INVALID_NOT_NULL_FIELD = "invalid.general.not-null";
    public static final String INVALID_FORMAT_USERNAME = "invalid.username-format";
    public static final String INVALID_FORMAT_PASSWORD = "invalid.password-format";
    public static final String INVALID_REPEAT_PASSWORD = "invalid.password-repeat";
    public static final String INVALID_FORMAT_EMAIL = "invalid.email-format";
    public static final String INVALID_FORMAT_PHONE = "invalid.phone-format";
    public static final String INVALID_COORDINATES = "invalid.coordinates";
    public static final String INVALID_MINIMUM_ONE = "invalid.minimum-one";
    public static final String INVALID_MINIMUM_ZERO = "invalid.minimum-zero";
    public static final String INVALID_MAXIMUM_ONE_HUNDRED = "invalid.maximum-one-hundred";
    public static final String INVALID_TEXT_LENGTH = "invalid.text.length";
    public static final String INVALID_KEYWORD_LENGTH = "invalid.keyword.length";

    //Date
    public static final String INVALID_DATE = "invalid.date-format";
    public static final String INVALID_DATE_FEATURE = "invalid.date-future";
    public static final String INVALID_DATE_PAST = "invalid.date-past";
    public static final String INVALID_TIME = "invalid.time-format";
    public static final String INVALID_LOCAL_DATE_FORMAT = "invalid.local-date-format";
    public static final String INVALID_LOCAL_DATE_TIME_FORMAT = "invalid.local-date-time-format";
    //File
    public static final String INVALID_MAX_UPLOAD_SIZE_EXCEEDED = "invalid.max-upload-size-exceeded";
    public static final String INVALID_FILE_REQUIRED = "invalid.file.required";
    public static final String INVALID_FILE_SIZE = "invalid.file.size";
    public static final String INVALID_FILE_TYPE = "invalid.file.type";
    public static final String INVALID_URL_FORMAT = "invalid.url-format";

    public static class Auth {
        public static final String ERR_INCORRECT_USERNAME_PASSWORD = "exception.auth.incorrect.username-password";
        public static final String ERR_INCORRECT_PASSWORD = "exception.auth.incorrect.password";
        public static final String ERR_INCORRECT_EMAIL = "exception.auth.incorrect.email";
        public static final String ERR_DUPLICATE_USERNAME = "exception.auth.duplicate.username";
        public static final String ERR_DUPLICATE_EMAIL = "exception.auth.duplicate.email";
        public static final String ERR_DUPLICATE_USERNAME_EMAIL = "exception.auth.duplicate.username.email";
        public static final String ERR_ACCOUNT_NOT_ENABLED = "exception.auth.account.not.enabled";
        public static final String ERR_ACCOUNT_LOCKED = "exception.auth.account.locked";
        public static final String ERR_INVALID_REFRESH_TOKEN = "exception.auth.invalid.refresh.token";
        public static final String EXPIRED_REFRESH_TOKEN = "exception.auth.expired.refresh.token";
    }

    public static class Author {
        public static final String ERR_NOT_FOUND_ID = "exception.author.not.found.id";
        public static final String ERR_DUPLICATE_NAME = "exception.author.duplicate.name";
        public static final String ERR_CANNOT_DELETE = "exception.author.cannot-delete";
    }

    public static class Address {
        public static final String ERR_NOT_FOUND_ID = "exception.address.not.found.id";
        public static final String CANNOT_DELETE_DEFAULT_ADDRESS = "exception.address.cannot.delete.default";
        public static final String NO_NEED_TO_UPDATE = "exception.address.is-default";
        public static final String TOO_MANY_ADDRESSES = "exception.address.to-many";
    }

    public static class Role {
        public static final String ERR_NOT_FOUND_ID = "exception.role.not.found.id";
        public static final String ERR_NOT_FOUND_NAME = "exception.role.not.found.name";
    }

    public static class User {
        public static final String ERR_NOT_FOUND_USERNAME_OR_EMAIL = "exception.user.not.found.username-email";
        public static final String ERR_NOT_FOUND_USERNAME = "exception.user.not.found.username";
        public static final String ERR_NOT_FOUND_EMAIL = "exception.user.not.found.email";
        public static final String ERR_NOT_FOUND_ID = "exception.user.not.found.id";
        public static final String ERR_NOT_FOUND_ACCOUNT = "exception.user.not.found.account";
    }

    public static class Customer {
        public static final String ERR_NOT_FOUND_ID = "exception.customer.not.found.id";
        public static final String ERR_NOT_FOUND_NAME = "exception.customer.not.found.name";
    }

    public static class Product {
        public static final String ERR_NOT_FOUND_ID = "exception.product.not.found.id";
        public static final String ERR_INSUFFICIENT_STOCK = "exception.product.insufficient.stock";
    }

    public static class Category {
        public static final String ERR_NOT_FOUND_ID = "exception.category.not.found.id";
        public static final String ERR_DUPLICATE_NAME = "exception.category.duplicate.name";
        public static final String ERR_CANNOT_DELETE = "exception.category.cannot-delete";
    }

    public static class BookSet {
        public static final String ERR_NOT_FOUND_ID = "exception.book-set.not.found.id";
        public static final String ERR_DUPLICATE_NAME = "exception.book-set.duplicate.name";
        public static final String ERR_CANNOT_DELETE = "exception.book-set.cannot-delete";
    }

    public static class Cart {
        public static final String ERR_NOT_FOUND_ID = "exception.cart.not.found.id";
        public static final String ERR_NOT_FOUND_CUSTOMER_ID = "exception.cart.not.found.customer-id";
        public static final String ERR_NOT_FOUND_PRODUCT_IDS = "exception.cart.not.found.product-ids";
        public static final String ERR_NOT_FOUND_PRODUCT_ID = "exception.cart.not.found.product-id";
    }

    public static class Bill {
        public static final String ERR_NOT_FOUND_ID = "exception.bill.not.found.id";
        public static final String ERR_NOT_ALLOW_CANCEL = "exception.bill.not.allow.cancel";
    }

    public static class Banner {
        public static final String ERR_NOT_FOUND_ID = "exception.banner.not.found.id";
    }

    public static class ChatRoom {
        public static final String ERR_NOT_FOUND_ID = "exception.chat-room.not.found.id";
    }
}

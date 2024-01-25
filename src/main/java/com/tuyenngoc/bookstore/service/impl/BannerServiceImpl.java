package com.tuyenngoc.bookstore.service.impl;

import com.tuyenngoc.bookstore.constant.ErrorMessage;
import com.tuyenngoc.bookstore.constant.SortByDataConstant;
import com.tuyenngoc.bookstore.constant.SuccessMessage;
import com.tuyenngoc.bookstore.domain.dto.BannerDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationFullRequestDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PaginationResponseDto;
import com.tuyenngoc.bookstore.domain.dto.pagination.PagingMeta;
import com.tuyenngoc.bookstore.domain.dto.response.CommonResponseDto;
import com.tuyenngoc.bookstore.domain.entity.Banner;
import com.tuyenngoc.bookstore.domain.mapper.BannerMapper;
import com.tuyenngoc.bookstore.exception.NotFoundException;
import com.tuyenngoc.bookstore.repository.BannerRepository;
import com.tuyenngoc.bookstore.service.BannerService;
import com.tuyenngoc.bookstore.util.PaginationUtil;
import com.tuyenngoc.bookstore.util.UploadFileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    private final MessageSource messageSource;

    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> getAllBanners() {
        return bannerRepository.getBanners();
    }

    @Override
    public PaginationResponseDto<Banner> getAllBanners(PaginationFullRequestDto requestDto) {
        Pageable pageable = PaginationUtil.buildPageable(requestDto, SortByDataConstant.BANNER);

        Page<Banner> page = bannerRepository.findAll(pageable);
        PagingMeta pagingMeta = PaginationUtil.buildPagingMeta(requestDto, SortByDataConstant.BANNER, page);

        PaginationResponseDto<Banner> responseDto = new PaginationResponseDto<>();
        responseDto.setItems(page.getContent());
        responseDto.setMeta(pagingMeta);

        return responseDto;
    }

    @Override
    public Banner getBanner(int bannerId) {
        return bannerRepository.findById(bannerId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Banner.ERR_NOT_FOUND_ID, String.valueOf(bannerId)));
    }

    //Todo remove url
    @Override
    public Banner createBanner(BannerDto bannerDto) {
        Banner banner;
        if (bannerDto.getId() == null) {
            banner = bannerMapper.toBanner(bannerDto);
        } else {
            banner = bannerRepository.findById(bannerDto.getId())
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.Banner.ERR_NOT_FOUND_ID, String.valueOf(bannerDto.getId())));

            banner.setImage(bannerDto.getImage());
            banner.setUrl(bannerDto.getUrl());
            banner.setViewOrder(bannerDto.getViewOrder());
        }
        return bannerRepository.save(banner);
    }

    @Override
    public CommonResponseDto deleteBanner(int bannerId) {
        if (bannerRepository.existsById(bannerId)) {
            bannerRepository.deleteById(bannerId);
            String message = messageSource.getMessage(SuccessMessage.DELETE, null, LocaleContextHolder.getLocale());
            return new CommonResponseDto(message);
        } else {
            throw new NotFoundException(ErrorMessage.Banner.ERR_NOT_FOUND_ID, String.valueOf(bannerId));
        }
    }

}

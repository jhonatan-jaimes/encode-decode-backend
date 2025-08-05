package com.jejo.encode_decode.short_url.service;

import com.jejo.encode_decode.text.entity.TextEntity;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {

    String getUrlOrigin(String text);
    TextEntity createUrl(TextEntity text);

}

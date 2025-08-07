package com.jejo.encode_decode.short_url.service;

import com.jejo.encode_decode.text.entity.TextEntity;

public interface UrlService {

    String getUrlOrigin(String text);
    TextEntity createUrl(TextEntity text);

}

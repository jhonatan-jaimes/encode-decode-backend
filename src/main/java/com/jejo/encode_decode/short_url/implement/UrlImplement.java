package com.jejo.encode_decode.short_url.implement;

import com.jejo.encode_decode.short_url.entity.UrlEntity;
import com.jejo.encode_decode.short_url.repository.UrlRepository;
import com.jejo.encode_decode.short_url.service.UrlService;
import com.jejo.encode_decode.text.entity.TextEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlImplement implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlImplement(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public String getUrlOrigin(String text) {
        return urlRepository.findByUrlShort(text)
                .map(UrlEntity::getUrlOrigin)
                .orElseThrow(() -> new RuntimeException("URL no encontrada: " + text));
    }

    @Override
    public TextEntity createUrl(TextEntity text) {
        return null;
    }
}

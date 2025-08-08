package com.jejo.encode_decode.short_url.implement;

import com.jejo.encode_decode.short_url.entity.UrlEntity;
import com.jejo.encode_decode.short_url.repository.UrlRepository;
import com.jejo.encode_decode.short_url.service.UrlService;
import com.jejo.encode_decode.short_url.util.UrlUtilidad;
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

        if (text == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        } else if (text.getText().isEmpty()) {
            throw new IllegalArgumentException("El elemento no puede ser vació");
        }

        UrlEntity urlEntity = new UrlEntity();

        String urlOrigin = text.getText();
        String hashUrl = "";

        do{
            hashUrl = UrlUtilidad.hash();
        }while (urlRepository.existsByUrlShort(hashUrl));

        urlEntity.setUrlOrigin(urlOrigin);
        urlEntity.setUrlShort(hashUrl);
        urlRepository.save(urlEntity);
        String host = "http://localhost:8080/" + hashUrl;
        text.setText(host);

        return text;
    }
}

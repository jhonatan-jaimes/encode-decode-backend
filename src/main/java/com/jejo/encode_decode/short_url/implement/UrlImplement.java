package com.jejo.encode_decode.short_url.implement;

import com.jejo.encode_decode.short_url.dto.UrlDto;
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

    /*
    * Metodo que busca en la base de datos el link correspondiente al hash proporcionado al usuario,
    * si no se encuentra el hash se devuelve una exception con el error.
    * */
    @Override
    public String getUrlOrigin(String text) {
        return urlRepository.findByHashShort(text)
            .map(UrlEntity::getUrlOrigin)
            // Se devuelve un throw si no se encuentra el hash en la base de datos
            .orElseThrow(() -> new IllegalArgumentException("URL no encontrada: " + text));
    }

    /*
    * Creacion de hash y la url que el usuario solicita y su respectivo almacenaiento en la base de datos,
    * para su uso posterior en el link.
    * */
    @Override
    public TextEntity createUrl(UrlDto text) {

        if (text == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }

        if (text.text().trim().isEmpty() || text.link().trim().isEmpty()) {
            throw new IllegalArgumentException("El elemento no puede ser vacío");
        }

        if (!text.link().matches("^(https?://|www\\.).*$")) {
            throw new IllegalArgumentException("No es un link para acortar");
        }

        String urlOrigin = text.text();
        String hashShort = "";

        /*
        * Si el hash ya se encuentra en la base de datos el do while se repetira para que los
        * hash no se repitan
        * */
        do{
            hashShort = UrlUtilidad.hash();
        }while (urlRepository.existsByHashShort(hashShort));

        // Guarda los elementos en la entidad urls para almacenar en la base de datos
        UrlEntity urlEntity = new UrlEntity(null, hashShort, urlOrigin);
        
        urlRepository.save(urlEntity); // --> se guarda en la base de datos el hash y la url original
        String host = text.link() + hashShort; // --> link corto para la url

        return new TextEntity(host); // --> se retorna el short-url
    }
}

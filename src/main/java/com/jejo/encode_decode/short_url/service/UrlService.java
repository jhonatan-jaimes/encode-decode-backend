package com.jejo.encode_decode.short_url.service;

import com.jejo.encode_decode.text.entity.TextEntity;

public interface UrlService {

    // Contrato para obtener el link guardado en la base de datos.
    String getUrlOrigin(String text);

    // Metodo para crear el hash y el link que va al usuario, y guarda en la base de datos.
    TextEntity createUrl(TextEntity text);
}

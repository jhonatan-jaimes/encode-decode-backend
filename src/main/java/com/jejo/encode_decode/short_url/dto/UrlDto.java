package com.jejo.encode_decode.short_url.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlDto(

        // Aquí se pide el link que se quiere acortar, el link del dominio del usuario final.
        @NotBlank(message = "Debe enviar un link a acortar")
        String text,

        /*
        * Aquí va el link del usuario o cliente que consume la api,
        * eje01: "https://www.ed.com/" <-- ejemplo de cliente que consume nuestra api.
        * eje02: "https://www.gen.io/" <-- otro cliente totalmente diferente.
        * */
        @NotBlank(message = "url del dueño del servicio")
        String link) {
}

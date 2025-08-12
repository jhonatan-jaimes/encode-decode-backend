package com.jejo.encode_decode.short_url.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlDto(
        @NotBlank(message = "Debe enviar un link a acortar")
        String text,

        @NotBlank(message = "url del dueño del servicio")
        String link) {
}

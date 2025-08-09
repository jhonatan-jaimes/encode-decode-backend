package com.jejo.encode_decode.qr_text.dto;

import jakarta.validation.constraints.*;

public record QrTextDto(
        @NotBlank(message = "El texto no puede estar vacío")
        String text,

        @NotNull(message = "Se necesita que no sea nulo")
        @Positive(message = "No puede ser negativo la escala")
        @Max(value = 500, message = "Maximo 500 px")
        Integer size
) { }

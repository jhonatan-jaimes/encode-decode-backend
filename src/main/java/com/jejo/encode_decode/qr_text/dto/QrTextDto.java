package com.jejo.encode_decode.qr_text.dto;

import jakarta.validation.constraints.*;

/*
* Record que me va a funcionar como clase DTO para recibir los datos que vienen
* del front-end, y se aplican las validaciones.
* */
public record QrTextDto(
        @NotBlank(message = "El texto no puede estar vacío")
        String text,

        @NotNull(message = "Se necesita que no sea nulo")
        @Positive(message = "No puede ser negativo la escala")
        @Max(value = 500, message = "Maximo 500 px")
        @Min(value = 250, message = "Minimo 250 px")
        Integer size
) { }

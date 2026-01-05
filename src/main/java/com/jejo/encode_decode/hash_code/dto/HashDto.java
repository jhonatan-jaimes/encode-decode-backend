package com.jejo.encode_decode.hash_code.dto;

import jakarta.validation.constraints.*;

public record HashDto(
    @NotNull(message = "Se necesita que no sea nulo")
    @Positive(message = "No puede ser negativo la escala")
    @Max(value = 160, message = "Maximo 160 caracteres")
    @Min(value = 16, message = "Minimo 16 caracteres")
    Integer lenght
) {
}

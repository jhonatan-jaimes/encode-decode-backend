package com.jejo.encode_decode.hash_code.dto;

import jakarta.validation.constraints.*;

public record HashDto(
    @NotNull(message = "Se necesita que no sea nulo")
    @Positive(message = "No puede ser negativo la escala")
    @Max(value = 128, message = "Maximo 128 caracteres")
    @Min(value = 8, message = "Minimo 8 caracteres")
    Integer value
) { }

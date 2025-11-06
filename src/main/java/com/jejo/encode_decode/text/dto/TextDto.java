package com.jejo.encode_decode.text.dto;

import jakarta.validation.constraints.NotBlank;

public record TextDto (
        @NotBlank(message = "El texto no puede estar vacio")
        String text)
{ }

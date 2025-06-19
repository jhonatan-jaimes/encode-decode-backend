package com.jejo.encode_decode.entity;

public class EncodeEntity {
    String text;

    public EncodeEntity() {
    }

    public EncodeEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

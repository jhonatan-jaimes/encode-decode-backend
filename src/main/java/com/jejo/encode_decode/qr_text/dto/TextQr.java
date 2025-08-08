package com.jejo.encode_decode.qr_text.dto;

public class TextQr {

    String text;
    Integer width;
    Integer height;

    public TextQr() {
    }

    public TextQr(String text, Integer width, Integer height) {
        this.text = text;
        this.width = width;
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

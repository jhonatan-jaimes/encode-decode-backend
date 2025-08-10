package com.jejo.encode_decode.qr_text.entity;

/*
* Entidad que se devuelve al front-end, para que este pueda general la imagen desde el lado del
* cliente para asi facilitar la transmission de datos.
* */
public class QrEntity {
    String [][] qr;

    public QrEntity() {
    }

    public QrEntity(String[][] qr) {
        this.qr = qr;
    }

    public String[][] getQr() {
        return qr;
    }

    public void setQr(String[][] qr) {
        this.qr = qr;
    }
}

package com.jejo.encode_decode.qr_text.entity;


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

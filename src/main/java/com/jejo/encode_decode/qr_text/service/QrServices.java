package com.jejo.encode_decode.qr_text.service;

import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.entity.QrEntity;

public interface QrServices {
    /*
    * Un solo metodo de este servicio que devuelve un array [][] para que el front-end lo pueda
    * utilizar y crear la imagen.
    **/
    QrEntity qrEntity(QrTextDto qrTextDto);
}
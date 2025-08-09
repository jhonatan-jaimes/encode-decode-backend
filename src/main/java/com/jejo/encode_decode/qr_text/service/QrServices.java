package com.jejo.encode_decode.qr_text.service;

import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.entity.QrEntity;

public interface QrServices {
    QrEntity qrEntity(QrTextDto qrTextDto);
}

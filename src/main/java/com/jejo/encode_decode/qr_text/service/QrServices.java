package com.jejo.encode_decode.qr_text.service;

import com.jejo.encode_decode.qr_text.dto.TextQr;
import com.jejo.encode_decode.qr_text.entity.QrEntity;
import com.jejo.encode_decode.text.entity.TextEntity;

public interface QrServices {
    QrEntity qrEntity(TextQr textQr);
}

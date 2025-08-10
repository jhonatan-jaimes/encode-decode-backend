package com.jejo.encode_decode.qr_text.implement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.entity.QrEntity;
import com.jejo.encode_decode.qr_text.service.QrServices;

import org.springframework.stereotype.Service;

@Service
public class QrImplement implements QrServices {

    /*
    * Implemetacion de la capa servicio de la entidad QR, para el uso de la inyeccion de dependencias
    * del principio SOLID.
    * */
    @Override
    public QrEntity qrEntity(QrTextDto qrTextDto) {

        String content = qrTextDto.text();
        int width = qrTextDto.size();
        int height = qrTextDto.size();

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

            String[][] matrix = new String[height][width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    matrix[y][x] = bitMatrix.get(x, y) ? "⬛" : "⬜";
                }
            }

            return new QrEntity(matrix);

        } catch (WriterException e) {
            throw new RuntimeException("Error generando el QR", e);
        }
    }
}


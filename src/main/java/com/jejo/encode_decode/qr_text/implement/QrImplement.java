package com.jejo.encode_decode.qr_text.implement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.entity.QrEntity;
import com.jejo.encode_decode.qr_text.service.QrServices;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QrImplement implements QrServices {

    @Override
    public QrEntity qrEntity(QrTextDto qrTextDto) {
        String content = qrTextDto.text();
        int width = qrTextDto.size();
        int height = qrTextDto.size();

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

            // Convertir a imagen PNG y luego a base64
            BufferedImage image = toBufferedImage(bitMatrix);
            String base64Image = convertToBase64(image);

            return new QrEntity(base64Image);

        } catch (WriterException | IOException e) {
            throw new RuntimeException("Error generando el QR", e);
        }
    }

    private BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF); // Negro o Blanco
            }
        }
        return image;
    }

    private String convertToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);
        byte[] imageBytes = baos.toByteArray();
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
    }
}
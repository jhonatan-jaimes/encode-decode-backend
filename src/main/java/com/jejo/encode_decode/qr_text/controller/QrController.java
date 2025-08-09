package com.jejo.encode_decode.qr_text.controller;

import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.implement.QrImplement;
import com.jejo.encode_decode.qr_text.service.QrServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QrController {

    private final QrServices qrServices;

    @Autowired
    public QrController(QrImplement qrImplement) {
        this.qrServices = qrImplement;
    }

    @PostMapping("/get-qr")
    public ResponseEntity<?> getQr(@Valid @RequestBody QrTextDto dto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(qrServices.qrEntity(dto));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se puede resolver " + ex);
        }
    }
}

package com.thullyoo.qr_code_generator.controller;

import com.thullyoo.qr_code_generator.DTO.QrCodeFormatDTO;
import com.thullyoo.qr_code_generator.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping()
    public ResponseEntity<byte[]> gerarQrCode(@RequestParam String url){
        byte[] qrCode = qrCodeService.gerarQrCode(new QrCodeFormatDTO(url, 400, 400));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-type", "image/png");

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(qrCode);
    }

}

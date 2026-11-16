package com.rafijohndev.qrgenerator.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.rafijohndev.qrgenerator.dto.QrRequest;
import com.rafijohndev.qrgenerator.qrservice.QrService;

@RestController
public class QRController {

	private final QrService qrService;
	
	public QRController(QrService qrService) {
		this.qrService = qrService;
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Dev, QR Generator is running";
	}
	
	@PostMapping("/api/generateQR")
	public ResponseEntity<byte[]> generateQr(@RequestBody QrRequest request) throws WriterException, IOException{
//	public byte[] generateQR(@RequestBody QrRequest request) throws WriterException, IOException {
		
		byte[] qrImage = qrService.generateQr(request.input());
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_PNG)
				.body(qrImage);
	}
}

package com.rafijohndev.qrgenerator.qrservice;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QrService {

	public byte[] generateQr(String input) throws WriterException, IOException {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();

		Map<EncodeHintType, Object> hints = new HashMap<>();

		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		BitMatrix bitMatrix = qrCodeWriter.encode(input, BarcodeFormat.QR_CODE, 500, 500, hints);

		BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

		ClassPathResource logoResource = new ClassPathResource("logo.png");

		InputStream logoStream = logoResource.getInputStream();

		BufferedImage logo = ImageIO.read(logoStream);

		Graphics2D graphics = qrImage.createGraphics();

		int logoSize = 125;

		Image scaledLogo = logo.getScaledInstance(logoSize, logoSize, Image.SCALE_SMOOTH);

		int x = (qrImage.getWidth() - logoSize) / 2;
		int y = (qrImage.getHeight() - logoSize) / 2;

		graphics.drawImage(scaledLogo, x, y, null);
		graphics.dispose();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		ImageIO.write(qrImage, "PNG", byteArrayOutputStream);

		return byteArrayOutputStream.toByteArray();
	}
}

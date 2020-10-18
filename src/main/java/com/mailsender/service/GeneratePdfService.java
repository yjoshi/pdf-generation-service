package com.mailsender.service;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import com.mailsender.bean.UserData;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class GeneratePdfService {

	private static final String EXTENSION = ".pdf";

	public GeneratePdfService() {

	}

	public boolean generate(UserData data) {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(document,
					new FileOutputStream("pdf/" + data.getPdfName() + GeneratePdfService.EXTENSION));

			document.open();
			document.add(new Paragraph(data.getPdfData(), new Font(FontFamily.COURIER, 16)));
			return (true);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
			writer.close();
		}
		return false;
	}

}

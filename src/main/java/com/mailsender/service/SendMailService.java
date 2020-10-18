package com.mailsender.service;

import com.mailsender.bean.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailService {

	@Autowired
	private JavaMailSender emailSender;

	public SendMailService() {

	}
	public boolean sendMailWithAttachedPDF(UserData data) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(data.getEmailTitle());
		helper.setText("Hello,This is a PDF sent from Rabbit MQ Demo!");
		helper.setTo(data.getEmail());
		helper.addAttachment(data.getPdfName() + ".pdf", new File("pdf/" + data.getPdfName() + ".pdf"));
		emailSender.send(message);
		return (true);
	}
}

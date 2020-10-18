package com.mailsender.controller;

import com.mailsender.bean.UserData;
import com.mailsender.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PdfController {

	@Autowired
	Publisher publisher;

	@RequestMapping(value = "/generatePDF", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.OK)	
	public String generatePDF(@RequestBody UserData data) 
	{
		System.out.println("connection established");
		publisher.produceMsg(data);
		return "Successfully Message Sent to queue!";
	}
}
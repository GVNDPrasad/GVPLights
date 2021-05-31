package com.mvc.gvplights.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mvc.gvplights.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender sender;

	public boolean send(String to, String[] cc, String[] bcc, String subject, String desc, Resource file) {
		boolean sent = false;// Mail status
		try {
			// 1. create new MimeMessage
			MimeMessage message = sender.createMimeMessage();
			// 2. create new Helper class object
			MimeMessageHelper helper = new MimeMessageHelper(message, file != null);
			// 3. fill data to MimeMessage using Helper
			helper.setTo(to);
			helper.setSubject(subject);
			// helper.setText(text); // send as plain Text
			helper.setText(desc, true); // send HTML Output

			if (cc != null && cc.length > 0)
				helper.setCc(cc);
			if (bcc != null && bcc.length > 0)
				helper.setBcc(bcc);

			if (file != null)
				helper.addAttachment(file.getFilename(), file);
			// 4. send email
			sender.send(message);
			sent = true;
		} catch (Exception e) {
			sent = false;
			e.printStackTrace();
		}

		return sent;
	}

}

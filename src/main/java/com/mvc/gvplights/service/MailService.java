package com.mvc.gvplights.service;

import org.springframework.core.io.Resource;

public interface MailService {

	public boolean send(String to, String[] cc, String[] bcc, String subject, String text, Resource file);
}

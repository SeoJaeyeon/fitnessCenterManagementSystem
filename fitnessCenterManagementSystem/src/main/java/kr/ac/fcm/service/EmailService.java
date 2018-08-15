package kr.ac.fcm.service;

public interface EmailService {
	public boolean sendSimpleMessage(String to, String subject, String text);
}

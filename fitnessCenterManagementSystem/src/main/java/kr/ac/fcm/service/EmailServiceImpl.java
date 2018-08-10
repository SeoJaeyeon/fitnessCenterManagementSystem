package kr.ac.fcm.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class EmailServiceImpl {

/*    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
    public JavaMailSender emailSender=ctx.getBean("javaMailService",JavaMailSender.class);
*/
	
	JavaMailSender emailSender;
	
	public void setJavaMailSender(JavaMailSender javaMailSender){
		this.emailSender=javaMailSender;
	}
    public boolean sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try{
        	emailSender.send(message);
        	
        }catch(MailException es){//메일발송실패
        	return false;
        }
        return true;
    }
}
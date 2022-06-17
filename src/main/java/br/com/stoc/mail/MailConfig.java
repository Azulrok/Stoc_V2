package br.com.stoc.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(this.env.getProperty("mail.smtp.host"));
		mailSender.setPort(((Integer)this.env.getProperty("mail.smtp.port", Integer.class)).intValue());
		mailSender.setUsername(this.env.getProperty("mail.smtp.username"));
		mailSender.setPassword(this.env.getProperty("mail.smtp.password"));
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", Boolean.valueOf(true));
		props.put("mail.smtp.starttls.enable", Boolean.valueOf(true));
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.connectiontimeout", Integer.valueOf(10000));
		
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
}
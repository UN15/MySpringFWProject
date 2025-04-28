package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {

	@Bean
	public EmailNotificationService emailNotificationService() {
		EmailNotificationService ens = new EmailNotificationService("smtp.gmail.com", 587);
		return ens;
	}
	
	@Bean
	public SmsNotificationService smsNotificationService() {
		SmsNotificationService sns = new SmsNotificationService("SKT");
		return sns;
	}
	
	@Bean
	public NotificationManager notificationManager() {
		NotificationManager nm = new NotificationManager(emailNotificationService(), smsNotificationService());
		return nm;
	}
}

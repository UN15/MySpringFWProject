package mylab.notification.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Test
	void testNotificationManager() {
		assertNotNull(notificationManager);
		notificationManager.sendNotificationByEmail("이메일 서비스입니다.");
		notificationManager.sendNotificationBySms("sms 서비스입니다.");
		
		EmailNotificationService ens = (EmailNotificationService)notificationManager.getEmailService();
		assertEquals("smtp.gmail.com", ens.getSmtpServer());
		assertEquals(587, ens.getPort());
		
		SmsNotificationService sns = (SmsNotificationService)notificationManager.getSmsService();
		assertEquals("SKT", sns.getProvider());
	}
}

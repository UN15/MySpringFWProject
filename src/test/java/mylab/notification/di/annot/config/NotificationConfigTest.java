package mylab.notification.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
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
//		notificationManager.sendNotificationByEmail("이메일 서비스입니다.");
//		notificationManager.sendNotificationBySms("sms 서비스입니다.");
//		
//		EmailNotificationService ens = (EmailNotificationService)notificationManager.getEmailService();
//		assertEquals("smtp.gmail.com", ens.getSmtpServer());
//		assertEquals(587, ens.getPort());
//		
//		SmsNotificationService sns = (SmsNotificationService)notificationManager.getSmsService();
//		assertEquals("SKT", sns.getProvider());
		
		 // 이메일 서비스 검증
        NotificationService emailService = notificationManager.getEmailService();
        assertTrue(emailService instanceof EmailNotificationService);
        assertEquals("smtp.gmail.com", ((EmailNotificationService) emailService).getSmtpServer());
        assertEquals(587, ((EmailNotificationService) emailService).getPort());
        
        // SMS 서비스 검증
        NotificationService smsService = notificationManager.getSmsService();
        assertTrue(smsService instanceof SmsNotificationService);
        assertEquals("SKT", ((SmsNotificationService) smsService).getProvider());
        
        // 메서드 실행 확인
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
	}
}

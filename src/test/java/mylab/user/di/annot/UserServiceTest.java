package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	void testUserService() {
		assertNotNull(userService);
		
		//UserRepository 확인
		//userService.getUserRepository() => UserRepository
		assertNotNull(userService.getUserRepository());
		//userService.getUserRepository().getDBType() ==>String 타입의 값은 MySQL
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		
		assertNotNull(userService.getSecurityService());
		
//		assertEquals(true, userService.registerUser("U001", "김철수", "12345"));
		assertTrue(userService.registerUser("U001", "김철수", "12345"));
		assertFalse(userService.registerUser("U002", "홍길동", ""));

	}
	
}

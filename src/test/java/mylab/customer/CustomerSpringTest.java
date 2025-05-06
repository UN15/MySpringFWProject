package mylab.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CustomerSpringTest {
	protected static final Logger logger = LogManager.getLogger();
	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSessionFactory sessionFactory;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	CustomerMapper customerMapper;

	@Autowired
	CustomerService customerService;
	
	@Test
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			logger.debug("DB URL = " + metaData.getURL());
			logger.debug("DB Username = " + metaData.getUserName());
			logger.debug("DB Vender Name = " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void service() {
		Date date = new Date();
		customerService.insertCustomer(new CustomerVO(1, "aaa@naver.com", "홍길동", 20, date));
		customerService.insertCustomer(new CustomerVO(2, "bbb@naver.com", "김철수", 21, date));
		customerService.insertCustomer(new CustomerVO(3, "ccc@naver.com", "김영희", 22, date));

		CustomerVO customer = customerService.getCustomerInfo(1);
		logger.debug(customer);

		List<CustomerVO> customerList = customerService.getAllCustomerList();
		// .forEach(Consumer)에서 Consumer를 Anonymous Inner class(익명 내부 클래스) 형태로 선언하는 방식
		customerList.forEach(new Consumer<CustomerVO>() {
			@Override
			public void accept(CustomerVO customer) {
				logger.debug(customer);
			}
		});
	}

	
}

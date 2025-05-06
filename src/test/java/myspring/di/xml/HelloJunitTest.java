package myspring.di.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//Assertions에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;
public class HelloJunitTest {
	ApplicationContext context;

	@BeforeEach
	void container(){
		//1.Container 객체 생성
		 context = new GenericXmlApplicationContext("classpath:hello-di.xml");			
	}
	@Test
	void helloBean() {
		//2.Container 객체가 생성한 Hello Spring Bean을 요청하기
		Hello helloById = (Hello) context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		//Spring Bean의 주소 비교
		System.out.println(helloById == helloByType); //scope default는 singleton prototype으로 변경해주면 주소 달라짐
		assertSame(helloById, helloByType);
		
		//값 비교
		assertEquals("Hello 스프링", helloById.sayHello());
		
		helloById.print();
		//Container 객체가 생성한 StringPrinter 스프링빈을 요청하기
		//<property name ="printer" ref = "strPrinter" /> 이 설정을 테스트 한 것임
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}

	
}


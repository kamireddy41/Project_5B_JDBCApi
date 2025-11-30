package com.telusko.SpringJDBCApi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.SpringJDBCApi.dao.Implementer;
import com.telusko.SpringJDBCApi.dao.ImplementerDaoImpl;

@SpringBootApplication
public class SpringJdbcApiApplication 
{

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJdbcApiApplication.class, args);
		
		ImplementerDaoImpl dao = container.getBean(ImplementerDaoImpl.class);
		
//		List<Implementer> impl = dao.getImplementersInfo();
//		
//		for(Implementer imp:impl)
//		{
//			System.out.println(imp);
//		}
		
		dao.getImplementersInfo().forEach(i->System.out.println(i));
	}

}

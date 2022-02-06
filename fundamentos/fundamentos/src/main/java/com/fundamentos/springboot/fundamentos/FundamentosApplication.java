package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependencies;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependencies myBeanWithDependencies;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement")
	  ComponentDependency componentDependency,
	  MyBean myBean,
	  MyBeanWithDependencies myBeanWithDependencies,
	  MyBeanWithProperties myBeanWithProperties,
	  UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependencies = myBeanWithDependencies;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependencies.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "  " + userPojo.getPassword());
		System.out.println("edad: " + userPojo.getAge());
		try{
			int value = 10/0;
			LOGGER.info("Mi valor es : " + value);
		}catch(Exception e){
			LOGGER.error("Error matemático " + e.getMessage());
		}
	}
}

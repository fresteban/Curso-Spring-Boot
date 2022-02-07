package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependencies;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependencies myBeanWithDependencies;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement")
	  ComponentDependency componentDependency,
	  MyBean myBean,
	  MyBeanWithDependencies myBeanWithDependencies,
	  MyBeanWithProperties myBeanWithProperties,
	  UserRepository userRepository,
	  UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependencies = myBeanWithDependencies;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userRepository = userRepository;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//clasesAnteriores();
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase() {
		User user1 = new User("Esteban", "esteban@algo.com", LocalDate.of(2021, 02, 7));
		User user2 = new User("Korone", "korone@algo.com", LocalDate.of(2021, 02, 21));
		User user3 = new User("Amelia", "amelia@algo.com", LocalDate.of(2021, 03, 31));
		User user4 = new User("Subaru", "subaru@algo.com", LocalDate.of(2021, 04, 12));
		User user5 = new User("Coco", "coco@algo.com", LocalDate.of(2021, 02, 11));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
		list.stream().forEach(userRepository::save);
		//userRepository.saveAll(listUsers);
	}
	private void clasesAnteriores() {
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

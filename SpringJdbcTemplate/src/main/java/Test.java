import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeDao dao= (EmployeeDao)context.getBean("empdao");
		Employee e= new Employee();
		e.setId(201);
		e.setName("Natasha");
		e.setAge(20);
		e.setSalary(5000);;
				
		int status= dao.saveEmployee(e);
		System.out.println(status);
	}

}

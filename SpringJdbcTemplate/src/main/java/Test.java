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
		  e.setId(2003); 
		  e.setName("Neha"); 
		  e.setAge(20);
		  e.setSalary(50000);;
		 
				
		//Boolean status= dao.saveEmployeeByPreparedStatement(e);
		//Boolean status= dao.updateEmployeeByPreparedStatement(e);
		//Boolean status= dao.deleteEmployeeByPreparedStatement(e);
		//dao.getEmployeesResultSetExtractor().stream().forEach(e->System.out.println(e));
		//dao.getAllEmployeesByRowMapper().stream().forEach(e->System.out.println(e));
		dao.saveEmpUsingNamedParam(e);
		System.out.println();
	}

}

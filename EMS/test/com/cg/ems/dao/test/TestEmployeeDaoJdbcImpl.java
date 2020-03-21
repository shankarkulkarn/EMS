package com.cg.ems.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoJdbcImpl;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

class TestEmployeeDaoJdbcImpl {

	
	@Test
	public void testDeleteEmployeeIdNotExist() throws Exception 
	{
		EmployeeService  service = new EmployeeServiceImpl();
		
		Employee  emp = new Employee();
		emp.setEmployeeName("john");;
		emp.setSalary(9000);
		int id = service.addEmployee(emp);
		
		
		assertThrows(EmployeeException.class, ()-> service.deleteEmployeeById(id+1));
		
		
	}
	
	@Test
	public void testDeleteEmployeeIdExist() throws Exception 
	{
		EmployeeService  service = new EmployeeServiceImpl();
		Employee  emp = new Employee();
		emp.setEmployeeName("john");;
		emp.setSalary(9000);
		int id = service.addEmployee(emp);
		
		Employee  e = service.deleteEmployeeById(id);
		assertTrue( id ==  e.getEmployeeId());
		
		
	}
	
	@Test
	public void testAddEmployeeValidData() throws Exception 
	{
		EmployeeService  service = new EmployeeServiceImpl();
		
		Employee   employee = new Employee();
		
		employee.setEmployeeName("aasasa");
		employee.setSalary(9000);
		int id  = service.addEmployee(employee);
		Employee  emp = service.findEmployeeById(id);
		assertTrue( emp.getEmployeeId() == id);
		
	}
	@Test
	public void testAddEmployeeInvalidName()
	{
		EmployeeService  service = new EmployeeServiceImpl();
		
		Employee   employee = new Employee();
		
		employee.setEmployeeName("2121aasasa");
		
		assertThrows(EmployeeException.class,()->service.addEmployee(employee));
	}
	
	
	@Test
	public void testFindEmployeeByIdExist() throws Exception
	{
		
		EmployeeDao  dao = new EmployeeDaoJdbcImpl();
		Employee employee = dao.findEmployeeById(1056);
		assertNotNull(employee);
		
		//assertEquals(1056,employee.getEmployeeId());
		
	}
	
	@Test
	public void testFindEmployeeByIdNotExist()
	{
		
		EmployeeDao  dao = new EmployeeDaoJdbcImpl();
		assertThrows(EmployeeException.class, ()->dao.findEmployeeById(9000));
		
	}

}

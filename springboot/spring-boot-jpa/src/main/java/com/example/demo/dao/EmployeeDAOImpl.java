package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;




@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	
	private EntityManager entityManager;

	//@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
			
		Query query = entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee save(Employee employee) {		
		
		Employee dbEmployee = entityManager.merge(employee);
		
		employee.setEmployeeId(dbEmployee.getEmployeeId());
		return employee;
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmployee = entityManager.find(Employee.class, theId);

		// return employee
		return theEmployee;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.merge(employee);

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Employee where last_name=:lastName");
		query.setParameter("lastName", lastName);

		return query.getResultList();
	}
	
	
	

	
	
	
	
}
package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.entity.Employee;
import com.model.EmployeeMO;

@Repository("hibernateRepo")
@SuppressWarnings("unchecked")
public class EmployeeRepoImplForHibernate extends AbstractDAO implements
		EmployeeRepoForHibernate {

	// getSession().createCriteria(Employee.class).add(Restrictions.eq("id",
	// id)) ==>>select * from employee where id=5;

	// getSession().createCriteria(Employee.class).list() ===>>> select * from
	// employee

	// getSession().createCriteria(Employee.class).setProjection("id").add(Restrictions.eq("id",
	// id)) ===>>>select id from employee where id=5;

	// getSession().createCriteria(Employee.class)addOrder(Order.desc("id")).list()
	// ==>> select * from employee odre by id desc

	// query===>>fetch
	// creteria==>>fetch

	
	
	//creteria query
	@Override
	public Employee updateEmployeeForHibernate(EmployeeMO emp) {
		getSession().saveOrUpdate(emp);
		return getEmployee(emp.getId());
	}

	@Override
	public List<Employee> getEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria = criteria.addOrder(Order.desc("id"));
		List<Employee> employeeList = criteria.list();
		return employeeList;
	}

	@Override
	public Integer delete(Integer id) {
		getSession().delete(getEmployee(id));
		return null;
	}

	@Override
	public Employee save(Employee emp) {
		getSession().save(emp);
		return getEmployee(emp.getId());
	}

	@Override
	public Employee getEmployee(Integer id) {
		return (Employee) getSession().createCriteria(Employee.class)
				.add(Restrictions.eq("id", id)).list().get(0);

	}

	//hql query-- getAllEmployess,save--vijeta
	//sql query-- getAllEmployess,save--vijeta
	//(all anotation with proper explanation)
	//hql query-- getEmployee,update,delete--rizwan
	//sql query-- getEmployee,update,delete--rizwan
	//(all anotation with proper explanation)
	
	
}

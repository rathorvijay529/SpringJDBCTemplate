package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;
import com.model.Employee;
import com.properties.Queries;

@Repository
public class EmployeeRepoImplementation implements EmployeeRepo {
	private static final Logger logger = Logger
			.getLogger(EmployeeRepoImplementation.class);

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// wild card jdbcTemplate implementation
	public Employee getEmployee(final Integer id) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement {}");
		logger.info("Retriving  the Employee is processing method name::getEmployee");
		logger.info("Argument::" + id);
		return jdbctemplate.query(Queries.QUERYFORGETTINGEMPLOYEE,
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, id);
					}
				}, new RowMapper<Employee>() {
					public Employee mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						Employee employee = new Employee();
						employee.setId(resultSet.getInt(1));
						employee.setAge(resultSet.getInt(2));
						employee.setFirstName(resultSet.getString(3));
						employee.setLastName(resultSet.getString(4));
						employee.setAddress(resultSet.getString(5));
						employee.setBloodGroup(resultSet.getString(6));
						employee.setDepartmentName(resultSet.getString(7));
						employee.setEmployeeType(resultSet.getString(8));
						return employee;
					}

				}).get(0);
	}

	public List<Employee> getEmployees() {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement");
		logger.info("Retriving  the Employee is processing method name::getEmployees");
		logger.info("Argument::" + "");
		return jdbctemplate.query(Queries.QUERYFORALLEMPLOYEES,
				new RowMapper<Employee>() {
					public Employee mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						Employee employee = new Employee();
						employee.setId(resultSet.getInt(1));
						employee.setAge(resultSet.getInt(2));
						employee.setFirstName(resultSet.getString(3));
						employee.setLastName(resultSet.getString(4));
						employee.setAddress(resultSet.getString(5));
						employee.setBloodGroup(resultSet.getString(6));
						employee.setDepartmentName(resultSet.getString(7));
						employee.setEmployeeType(resultSet.getString(8));
						return employee;
					}

				});
	}

	public Integer delete(final Integer id) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement");
		logger.info("Deleting  the Employee is processing method name::delete");
		logger.info("Argument::" + id);
		return jdbctemplate.update(Queries.QUERYFORDELETEEMPLOYEE,
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, id);
					}

				});

	}

	public Integer save(final EmployeeEntity emp) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement");
		logger.info("Saving the Employee is processing method name::save");
		logger.info("Argument::" + emp);
		return jdbctemplate.update(Queries.INSERT_EMPLOYEES,
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement preparedstatement)
							throws SQLException {
						preparedstatement.setInt(1, emp.getId());
						preparedstatement.setInt(2, emp.getAge());
						preparedstatement.setString(3, emp.getFirstName());
						preparedstatement.setString(4, emp.getLastName());
						preparedstatement.setString(5, emp.getAddress());
						preparedstatement.setString(6, emp.getBloodGroup());
						preparedstatement.setString(7, emp.getDepartmentName());
						preparedstatement.setString(8, emp.getEmployeeType());
					}

				});

	}

	public Integer updateEmployee(final EmployeeEntity emp) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement");
		logger.info("Updating the Employee is processing method name::updateEmployee");
		logger.info("Argument::" + emp);
		return jdbctemplate.update(Queries.QUERYFORUPDATEEMPLOYEE,
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement preparedstatement)
							throws SQLException {
						preparedstatement.setInt(8, emp.getId());
						preparedstatement.setInt(2, emp.getAge());
						preparedstatement.setString(1, emp.getFirstName());
						preparedstatement.setString(3, emp.getLastName());
						preparedstatement.setString(4, emp.getAddress());
						preparedstatement.setString(5, emp.getBloodGroup());
						preparedstatement.setString(6, emp.getDepartmentName());
						preparedstatement.setString(7, emp.getEmployeeType());
					}

				});
	}

	// Named Template:
	public Employee getEmployeeWithNamedParaMeter(Integer id) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement {}");
		logger.info("Retriving  the Employee is processing method name::getEmployeeWithNamedParaMeter");
		logger.info("Argument::" + id);
		return namedParameterJdbcTemplate.query(
				Queries.QUERY_FOR_GETTING_EMPLOYEE_By_ID_WITH_NAMED_PARAMETER,
				new MapSqlParameterSource().addValue("id", id),
				new RowMapper<Employee>() {
					public Employee mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						Employee employee = new Employee();
						employee.setId(resultSet.getInt(1));
						employee.setAge(resultSet.getInt(2));
						employee.setFirstName(resultSet.getString(3));
						employee.setLastName(resultSet.getString(4));
						employee.setAddress(resultSet.getString(5));
						employee.setBloodGroup(resultSet.getString(6));
						employee.setDepartmentName(resultSet.getString(7));
						employee.setEmployeeType(resultSet.getString(8));
						return employee;
					}

				}).get(0);

	}

	// Named Template: Save Employee using Named Parameter
	public Integer saveEmployeeUsingNamedParaMeter(final EmployeeEntity emp) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement {}");
		logger.info("Saving  the Employee is processing method name::saveEmployeeUsingNamedParaMeter");
		logger.info("Argument::" + emp);
		return namedParameterJdbcTemplate.update(
				Queries.INSERT_EMPLOYEES_WIH_NAMED_PARAMETER,
				new MapSqlParameterSource().addValue("id", emp.getId())
						.addValue("age", emp.getAge())
						.addValue("firstName", emp.getFirstName())
						.addValue("lastName", emp.getLastName())
						.addValue("bloodGroup", emp.getBloodGroup())
						.addValue("departmentName", emp.getDepartmentName())
						.addValue("employeeType", emp.getEmployeeType()));

	}

	// Named Template: Delete Employee using Named Parameter
	public Integer deleteUsingNamedParameterQuery(final Integer id) {
		logger.info("Repository Layer Invoked::EmployeeRepoImplement");
		logger.info("Deleting  the Employee is processing method name::deleteUsingNamedParameterQuery");
		logger.info("Argument::" + id);
		return namedParameterJdbcTemplate.update(
				Queries.QUERY_FOR_DELETE_EMPLOYEE_WITH_NAMED_PARAMETER,
				new MapSqlParameterSource().addValue("id", id));
	}

}

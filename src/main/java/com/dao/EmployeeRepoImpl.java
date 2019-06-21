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
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;
import com.properties.Properties;

@Repository
public class EmployeeRepoImpl implements Employeerepo {

	Logger logger = Logger.getLogger(EmployeeRepoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * @Override public Integer save(EmployeeEntity employeeEntity) {
	 * logger.info(
	 * "Insertion is hppning in DAO layer and Method::save is invoked"); return
	 * jdbcTemplate.update(Properties.queryForInsertEmployee, new
	 * PreparedStatementSetter() {
	 * 
	 * @Override public void setValues(PreparedStatement PreparedStatement)
	 * throws SQLException { PreparedStatement.setInt(1,
	 * employeeEntity.getEmployeeId()); PreparedStatement.setString(2,
	 * employeeEntity.getFname()); PreparedStatement.setString(3,
	 * employeeEntity.getLname()); PreparedStatement.setInt(4,
	 * employeeEntity.getAge()); PreparedStatement.setString(5,
	 * employeeEntity.getBranchName()); } });
	 * 
	 * }
	 */

	@Override
	public Integer save(EmployeeEntity employeeEntity) {
		logger.info("Insertion is hppning in DAO layer and Method::save is invoked");
		return jdbcTemplate.update(Properties.queryForInsertEmployee, PreparedStatement -> {
			PreparedStatement.setInt(1, employeeEntity.getEmployeeId());
			PreparedStatement.setString(2, employeeEntity.getFname());
			PreparedStatement.setString(3, employeeEntity.getLname());
			PreparedStatement.setInt(4, employeeEntity.getAge());
			PreparedStatement.setString(5, employeeEntity.getBranchName());

		});

	}

	@Override
	public List<EmployeeEntity> getListOfEmployee() {
		logger.info("Insertion is hppning in DAO layer and Method::save is invoked");
		return jdbcTemplate.query(Properties.queryForGettingAllEmployee, new RowMapper<EmployeeEntity>() {
			@Override
			public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeEntity employeeEntity = new EmployeeEntity();
				employeeEntity.setEmployeeId(rs.getInt(1));
				employeeEntity.setFname(rs.getString(2));
				employeeEntity.setLname(rs.getString(3));
				return employeeEntity;
			}
		});
	}

	@Override
	public EmployeeEntity getEmployee(Integer empId) {
		logger.info("getting information in DAO layer and Method::getEmployee is invoked");
		return jdbcTemplate.query(Properties.queryForGettingEmployee, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, empId);
			}

		}, new RowMapper<EmployeeEntity>() {
			@Override
			public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeEntity employeeEntity = new EmployeeEntity();
				employeeEntity.setEmployeeId(rs.getInt(1));
				employeeEntity.setFname(rs.getString(2));
				employeeEntity.setLname(rs.getString(3));
				return employeeEntity;
			}
		}).get(0);
	}

	/*
	 * @Override public Boolean deleteEmployee(Integer empId) { logger.info(
	 * "Deleting information in DAO layer and Method::deleteEmployee is invoked and parameter is "
	 * + empId); Map<String, Object> parameters = new HashMap<String, Object>();
	 * parameters.put("id", empId);
	 * jdbcTemplate.execute(Properties.queryForDeleteEmployee, new
	 * PreparedStatementCallback<Boolean>() {
	 * 
	 * @Override public Boolean doInPreparedStatement(PreparedStatement ps)
	 * throws SQLException, DataAccessException { ps.setInt(1, empId); return
	 * ps.execute(); } }); return true;
	 * 
	 * }
	 */

	@Override
	public Boolean deleteEmployee(Integer empId) {
		logger.info(
				"Deleting information in DAO layer and Method::deleteEmployee is invoked and parameter is " + empId);
		/*
		 * Map<String, Object> parameters = new HashMap<String, Object>();
		 * parameters.put("id", empId);
		 */
		jdbcTemplate.update(Properties.queryForDeleteEmployee, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, empId);

			}
		});
		return true;

	}

	@Override
	public EmployeeEntity updateEmployee(Integer empId) {

		return null;
	}

}

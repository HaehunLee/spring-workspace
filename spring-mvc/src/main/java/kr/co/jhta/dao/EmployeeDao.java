package kr.co.jhta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.vo.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SqlMapClientTemplate template;
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByDeptId(Integer id) {
		return template.queryForList("getEmployeesByDeptId", id);
	}
	
	public Employee getEmployeeById(Integer id) {
		return (Employee)template.queryForObject("getEmployeeById", id);
	}
	
	public void insertEmployee(Employee emp) {
		template.insert("insertEmployee", emp);
	}
}

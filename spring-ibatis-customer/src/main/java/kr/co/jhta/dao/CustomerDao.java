package kr.co.jhta.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import kr.co.jhta.vo.Customer;

public class CustomerDao {

	private SqlMapClientTemplate template;
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		return (List<Customer>) template.queryForList("getAllCustomers");
	}
	
	public Customer getCustomerByNo(String custNo) {
		return (Customer)template.queryForObject("getCustomerByNo", custNo);
	}
	
	public void insertCustomer(Customer cust) {
		template.insert("insertCustomer", cust);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerBySearch(Map<String, Object> map){
		return (List<Customer>) template.queryForList("getCustomerBySearch", map);
	}
	
	public void updateCustomer(Customer customer) {
		template.update("updateCustomer", customer);
	}
	
	public void deleteCustomer(int custNo) {
		template.delete("deleteCustomer", custNo);
	}
}

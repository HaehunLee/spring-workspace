package kr.co.jhta.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.dao.DepartmentDao;
import kr.co.jhta.dao.EmployeeDao;
import kr.co.jhta.vo.Department;
import kr.co.jhta.vo.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao empDao = new EmployeeDao(); 
	
	@Autowired
	DepartmentDao deptDao = new DepartmentDao();

	@RequestMapping(value = "/main.do")
	public String main() {
		
		// 최근에 가입된 사원정보 조회
		// 조회된 정보를 모델에 담아서 view페이지에 전달
		
		return "emp/main";
	}
	
	@RequestMapping("/detail.do")
	public String detail(String id, int pno, Model model) {
		System.out.println("id : " + id + ", pno : " + pno);
		
		// 쿼리스트링 값과 model을 동시에 사용할 때
		// EmployeeDao dao = new EmployeeDao();
		// Employee emp = dao.getEmployeeById(id);
		// model.addAttribute("employee", emp);
		
		HashMap<String, Object> emp = new HashMap<String, Object>();
		emp.put("id", id);
		emp.put("name", "홍길동");
		emp.put("dept", "영업1팀");
		
		model.addAttribute("employee", emp);
		
		return "emp/detail";
	}
	
	
	
	
	
	@RequestMapping(value = "/depts.do")
	public String depts(Model model) {
		List<Department> depts = deptDao.getAllDepartments();
		model.addAttribute("depts", depts);
		
		return "emp/depts";
	}
	
	@RequestMapping(value = "/employees.do")
	public String employees(int deptId, Model model) {
		List<Employee> emps = empDao.getEmployeesByDeptId(deptId);
		System.out.println(emps);
		model.addAttribute("emps", emps);
		
		return "emp/employees";
	}
	
	@RequestMapping(value = "/employee.do")
	public String employee() {
		return "emp/employee";
	}
	
	@RequestMapping(value = "/form.do")
	public String registerform() {
		return "emp/form";
	}
	
	@RequestMapping(value = "/add.do")
	public String register(Employee emp) {
		System.out.println(emp);
		
		return "redirect:main.do";
	}
}

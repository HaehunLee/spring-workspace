package kr.co.jhta.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.dao.CustomerDao;
import kr.co.jhta.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "classpath:/META-INF/spring/context.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);

		CustomerDao custDao = ctx.getBean(CustomerDao.class);
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n");
			System.out.println("------------------------------------------------------");
			System.out.println("1.전체조회 2.검색 3.등록 4.수정 5.삭제 0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("메뉴선택> ");
			int menu = sc.nextInt();
			
			if (menu == 1) {
				List<Customer> customers = custDao.getAllCustomers();
				System.out.println("번호    이름	 전화번호");
				
				for(Customer c : customers) {
					System.out.println(c.getNo()+"       "+c.getName()+"     "+c.getTel());
				};
			} else if (menu == 2) {
				System.out.println("1. 번호로 검색        2. 이름으로 검색        3. 닉네임으로 검색");
				int search = sc.nextInt();
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if ( search == 1) {
					System.out.print("검색 : ");
					int keyword = sc.nextInt();
					
					map.put("option", "no");
					map.put("value", keyword);
				} else if ( search == 2) {
					System.out.println("검색 : ");
					String keyword = sc.next();
					
					map.put("option", "name");
					map.put("value", keyword);
				} else if ( search ==3) {
					System.out.println("검색 : ");
					String keyword = sc.next();
					
					map.put("option", "nickName");
					map.put("value", keyword);
				}
				
				List<Customer> customers = custDao.getCustomerBySearch(map);
				System.out.println("번호  이름   닉네임  전화번호          이메일                거주지   포인트   가입일");
				for(Customer c : customers) {
					System.out.println(c.getNo()+"    "+
									   c.getName()+"  "+
									   c.getNickName()+"  "+
									   c.getTel()+"     "+
									   c.getEmail()+"   "+
									   c.getCity()+"   "+
									   c.getPoint()+"   "+
									   c.getCreateDate());
				}
				
			} else if (menu == 3) {
				System.out.println("======신규 고객 가입======");
				System.out.print("이름 입력> ");
				String name = sc.next();
				System.out.print("닉네임 입력> ");
				String nickName = sc.next();
				System.out.println("전화번호 입력> ");
				String tel = sc.next();
				System.out.println("이메일 입력> ");
				String email = sc.next();
				System.out.println("거주지 입력> ");
				String city = sc.next();
				
				Customer cust = new Customer();
				cust.setName(name);
				cust.setNickName(nickName);
				cust.setTel(tel);
				cust.setEmail(email);
				cust.setCity(city);
				
				custDao.insertCustomer(cust);
				System.out.println("등록이 완료되었습니다!");
				
			} else if (menu == 4) {
				System.out.print("변경할 고객 번호 입력> ");
				int no = sc.nextInt();
				System.out.print("변경할 고객 닉네임 입력> ");
				String nickName = sc.next();
				System.out.print("변경할 고객 전화번호 입력> ");
				String tel = sc.next();
				System.out.print("변경할 고객 이메일 입력> ");
				String email = sc.next();
				System.out.print("변경할 고객 거주지 입력> ");
				String city = sc.next();
				System.out.print("변경할 고객 포인트 입력> ");
				int point = sc.nextInt();
				
				Customer cust = new Customer();
				cust.setNo(no);
				cust.setNickName(nickName);
				cust.setTel(tel);
				cust.setEmail(email);
				cust.setCity(city);
				cust.setPoint(point);
				
				custDao.updateCustomer(cust);
				System.out.println("성공적으로 수정되었습니다!");
				
			} else if (menu == 5) {
				System.out.print("삭제하실 고객번호 입력> ");
				int no = sc.nextInt();
				
				custDao.deleteCustomer(no);
				System.out.println("성공적으로 삭제되었습니다!");
			} else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		
	}
}

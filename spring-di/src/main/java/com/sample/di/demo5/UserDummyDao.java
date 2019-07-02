package com.sample.di.demo5;

public class UserDummyDao implements UserDao{

	public void insertUser(String name, String id, String password) {
		System.out.println("이름 : " +name);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + password);
	}
}

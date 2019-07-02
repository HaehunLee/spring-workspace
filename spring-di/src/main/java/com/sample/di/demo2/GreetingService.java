package com.sample.di.demo2;

public class GreetingService {
	// 1. 조립할 것 변수 준비
	private KoreanGreeting ko;
	private EnglishGreeting eng;
	
	// 2. 조립할 setter메소드
	public void setKo(KoreanGreeting ko) {
		this.ko = ko;
	}

	public void setEng(EnglishGreeting eng) {
		this.eng = eng;
	}
	
	public String hello(String name) {
		String message = ko.message(name);
		
		return message;
	}
	
	public String bye() {
		String message = eng.goodbye();
		
		return message;
	}
}

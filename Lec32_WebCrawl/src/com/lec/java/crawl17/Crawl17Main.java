package com.lec.java.crawl17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Selenium 라이브러리 다운로드 (Java 버젼으로!)
 * 	https://www.seleniumhq.org/download/
 * 
 *  BuildPath 추가
 *  
 * 브라우저 드라이버 다운로드 
 *  http://chromedriver.chromium.org/downloads
 *  
 *  
 */
public class Crawl17Main {

	//WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/JavaApp1/download/chromedriver.exe";
	
	public static void main(String[] args) {
		System.out.println("Selenium 사용");
		
		
		Crawl17Main app = new Crawl17Main();
		app.init(); //제어되는 브라우저 가동!
		//driver 를 통해서 브라우저 제어
		//app.naverLogin();
		
		//app.likeFaceBook();
		app.naverRelated("파이썬");
		
		
		System.out.println("\n프로그램 종료");
		
		
		
	}

	public void init() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//Driversetup
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);

	}
	public void naverLogin() {
		String url = "https://nid.naver.com/nidlogin.login";
		driver.get(url);//url주소이동
		
		//아이디입력
		element = driver.findElement(By.id("id"));
		element.sendKeys("bhd4445");//키보드타이핑
		
		
		//패스워드 입력
		element = driver.findElement(By.id("pw"));
		element.sendKeys("yoonjoo97@@");
		
		//로그인 버튼 클릭
		element = driver.findElement(By.className("btn_global"));
		element.click();
	}
	//Facebook 좋아요 클릭
	public void likeFaceBook() {
		String url = "http://facebook.com";
		driver.get(url);
		
		driver.findElement(By.id("email")).sendKeys("01089152865");
		driver.findElement(By.id("pass")).sendKeys("yoonjoo97@@");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		url = "https://www.facebook.com/profile.php?id=100013650552869";
		driver.get(url); //게시물로 이동
		
		
	}
	public void naverRelated(String keyword) {
		driver.get("https://www.naver.com");
		driver.findElement(By.id("query")).sendKeys(keyword);
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> list = driver.findElements(By.cssSelector("ul._related_keyword_ul a"));
		System.out.println(list.size());
		for(WebElement e : list) {
			System.out.println(e.findElement(By.tagName("a")).getText().trim());
		}
			
	
	}
	
}

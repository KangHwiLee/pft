package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium {
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
	public static final String WEB_DRIVER_PATH = "src/main/resources/static/lib/chromedriver.exe";
	
	
	
	public static void main(String[] args) throws IOException {

		selenium selenium = new selenium();
		selenium.naver_login();
		}
	
	public selenium() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");            // 전체화면으로 실행
        //options.addArguments("--disable-popup-blocking");    // 팝업 무시
        //options.addArguments("--disable-default-apps");     // 기본앱 사용안함
		
        
        // 빈 탭 생성
        //driver.executeScript("window.open('about:blank','_blank');");
        
        // 탭 목록 가져오기
        //List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        
        //driver.switchTo().window(tabs.get(0));
		
		options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver( options );
        url = "https://kr.tradingview.com/";
        
	}
	
	public void naver_login() {
		 ////*[@id="content"]/div[2]/div[1]/a/span[2]
		driver.get(url);
        element =  driver.findElement(By.cssSelector("body > div.tv-main > div.tv-header.tv-header__top.js-site-header-container.tv-header--sticky.tv-header--promo.tv-header--animated > div.tv-header__inner > div.tv-header__area.tv-header__area--user > button.tv-header__user-menu-button.tv-header__user-menu-button--anonymous.js-header-user-menu-button"));
		
		element.click();
		element = driver.findElement(By.cssSelector(".menu-R4eO0Qp9 menuWrap-biWYdsXC > .scrollWrap-biWYdsXC momentumBased-biWYdsXC > .menuBox-biWYdsXC > button:nth-child(1)"));
		element.click();
		 /* 
		 * element = driver.findElement(By.cssSelector("#id_line > input"));
		 */
        		/*
		element = driver.findElement(By.cssSelector("#id_line > input"));
		element.sendKeys("wert2658");
		element = driver.findElement(By.cssSelector("#pw_line > input"));
		element.sendKeys("EHFHWJDQL2658!");
		element = driver.findElement(By.cssSelector(".btn_login"));
		element.click();
		*/
	}
	
}

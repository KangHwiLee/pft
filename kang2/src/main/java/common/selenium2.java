package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium2 {
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
	public static final String WEB_DRIVER_PATH = "src/main/resources/static/lib/chromedriver.exe";
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {

		selenium2 selenium = new selenium2();
		selenium.find_area();
		}
	
	public selenium2() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");            // 전체화면으로 실행
        //options.addArguments("--disable-popup-blocking");    // 팝업 무시
        //options.addArguments("--disable-default-apps");     // 기본앱 사용안함
		options.addArguments("headless");
        
        // 빈 탭 생성
        //driver.executeScript("window.open('about:blank','_blank');");
        
        // 탭 목록 가져오기
        //List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        
        //driver.switchTo().window(tabs.get(0));
		
		//options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver( options );
        url = "http://data.krx.co.kr/contents/MDC/MAIN/main/index.cmd";
        
	}
	
	public void find_area() throws InterruptedException {
		 ////*[@id="content"]/div[2]/div[1]/a/span[2]
		driver.get(url);
        element =  driver.findElement(By.cssSelector("#jsMain5IndexList > li:nth-child(2)"));
        element.click();
        Thread.sleep(2000);
        List<Double> list = new ArrayList<>();
        System.out.println("??");
        element = driver.findElement(By.cssSelector("#jsGrid_MDCSTAT005_0 > tbody > tr:nth-child(7)"));
        System.out.println("좀 되라 : " + element.getText());
        for(int i=1; i<11; i++) {
        	System.out.println("i : " + i);
        	String num = Integer.toString(i);
        	element = driver.findElement(By.cssSelector("#jsGrid_MDCSTAT005_0 > tbody > tr:nth-child("+num+") > td:nth-child(2)"));
        	double add = Double.parseDouble(element.getText().replaceAll(",", ""));
        	System.out.println("================================================ add : " + add);
        	list.add(add);
        }
        for(int i=0; i<list.size(); i++) {
        	System.out.println(list.get(i));
        }
        
		 /* 
		  * 
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

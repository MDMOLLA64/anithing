package seleniumpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProperties {
	static WebDriver dr ;

	public static void main(String[] args) throws IOException {
		Properties prop =new Properties();
		FileInputStream ip = new FileInputStream("/Users/mdmolla/eclipse-workspace/PageObjectModel/"+"src/main/java/seleniumpractice/config.properties");
	    prop.load(ip);
	    System.out.println(prop.getProperty("Browser"));
	   String browsername= prop.getProperty("Browser");
if(browsername.equals("Chrome")) {

	System.setProperty("webdriver.chrome.driver", "/Users/mdmolla/Downloads/chromedriver");
	
	 dr=new ChromeDriver();
	
}
else if(browsername.equals("FF")) {
	//System.setProperty("webdriver.chrome.driver", "/Users/mdmolla/Downloads/chromedriver");
	
	 dr=new FirefoxDriver();
}
else {
	System.out.println("no browser is there");
}
dr.get(prop.getProperty("url"));
dr.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
dr.findElement(By.name("pass")).sendKeys(prop.getProperty("password"));
dr.findElement(By.id("u_0_2")).click();
	}

}

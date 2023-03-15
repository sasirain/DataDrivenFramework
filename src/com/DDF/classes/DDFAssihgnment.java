package com.DDF.classes;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class DDFAssihgnment {

	public static void main(String[] args) {
		try {
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\Workspace\\DataDrivenFramework\\src\\com\\DDF\\utils\\inputAssignmentExample");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		String principal_amount = p.getProperty("principal_amount");
		String interest = p.getProperty("interest");
		String desired_time = p.getProperty("desired_time");
		String dropdown1value = p.getProperty("dropdown1value");
		String dropdown2value = p.getProperty("url");
		String dropdown3value = p.getProperty("url");
		
		driver.get(url);
		driver.findElement(By.linkText("General Math")).click();
		Thread.sleep(1000);
		
		WebElement dropdown1 = driver.findElement(By.id("topicItem"));
		dropdwonapproach(dropdown1,dropdown1value);
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("principal")).sendKeys(principal_amount);
		Thread.sleep(1000);
		driver.findElement(By.name("interest")).sendKeys(interest);
		Thread.sleep(1000);
		
		WebElement dropdown2 = driver.findElement(By.name("interest_units"));
		dropdwonapproach(dropdown2,dropdown2value);
		
		
		Thread.sleep(1000);
		driver.findElement(By.name("desired_time")).sendKeys(desired_time);
		Thread.sleep(1000);
		
		WebElement dropdown3 = driver.findElement(By.name("desired_time_units"));
		dropdwonapproach(dropdown3,dropdown3value);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		driver.close();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void dropdwonapproach(WebElement ele,String value) {
		
		Select sel = new Select(ele);
		List<WebElement> list = sel.getOptions();
		
		for(WebElement option:list) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
			
		}
		
	}

}

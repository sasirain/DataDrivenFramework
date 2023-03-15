package com.DDF.classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NonDataDrivenFrameworkExample {

	public static void main(String[] args) {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.webmath.com/");
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(3000);
			
			Select select = new Select(driver.findElement(By.name("topicItem")));
			select.selectByVisibleText("Interest, Simple");
			Thread.sleep(3000);
			driver.findElement(By.name("principal")).sendKeys("10000");
			Thread.sleep(3000);
			driver.findElement(By.name("interest")).sendKeys("7.5");
			Thread.sleep(3000);
			driver.findElement(By.name("desired_time")).sendKeys("5");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

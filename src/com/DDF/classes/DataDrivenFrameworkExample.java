package com.DDF.classes;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenFrameworkExample {

	public static void main(String[] args) {
		
				try {
					ChromeDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
					FileInputStream fis = new FileInputStream("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\Workspace\\DataDrivenFramework\\src\\com\\DDF\\utils\\input.properties");
					Properties p = new Properties();
					p.load(fis);
					
					String url = p.getProperty("url");
					String principal_amount = p.getProperty("principal_amount");
					String rate_of_interest = p.getProperty("rate_of_interest");
					String desired_time = p.getProperty("desired_time");
					
					
					driver.get(url);
					driver.findElement(By.linkText("General Math")).click();
					Thread.sleep(3000);
					
					Select select = new Select(driver.findElement(By.name("topicItem")));
					select.selectByVisibleText("Interest, Simple");
					Thread.sleep(3000);
					driver.findElement(By.name("principal")).sendKeys(principal_amount);
					Thread.sleep(3000);
					driver.findElement(By.name("interest")).sendKeys(rate_of_interest);
					Thread.sleep(3000);
					driver.findElement(By.name("desired_time")).sendKeys(desired_time);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					Thread.sleep(3000);
					driver.close();
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}

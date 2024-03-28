package com.test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://dkdineshkumar1596.bubbleapps.io/version-test?debug_mode=true");
		driver.manage().window().maximize();
//	    driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Boston");
//	    driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("London");
//		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
//		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
//		System.out.println("number of rows in table:"+rows); //5
//	
//	//6 - capture prices then store in array
//		
//		String pricesArr[]=new String[rows];   //0-4
//		
//		for(int r=1;r<=rows;r++)
//		{
//			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
//			
//			pricesArr[r-1]=price; //adding price into array
//		}
//		
//	//7- Sort prices then find lower price value
//		
//		for(String arrvalue:pricesArr)
//		{
//			System.out.println(arrvalue);
//		}
//		
//		Arrays.sort(pricesArr); // this will able to sort strings. so no need to convert to number
//		String lowestPrice=pricesArr[0];
//		System.out.println("Lower price:"+lowestPrice);
//		
//	//8- Find record in table having lower price
//		
//		for(int r=1;r<=rows;r++)
//		{
//			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
//			
//			if(price.equals(lowestPrice))
//			{
//				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
//				break;
//			}
//
//		}
//		//9 - Fill the details then click on Purchase Filight button
//		
//				driver.findElement(By.id("inputName")).sendKeys("John");
//				driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
//				driver.findElement(By.id("city")).sendKeys("Columbus");
//				driver.findElement(By.id("state")).sendKeys("OH");
//				driver.findElement(By.id("zipCode")).sendKeys("43240");
//				driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
//				driver.findElement(By.id("creditCardYear")).clear();
//				driver.findElement(By.id("creditCardYear")).sendKeys("2022");
//				driver.findElement(By.id("nameOnCard")).sendKeys("John Canedy");
//				driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
//			
//			//10 - validation
//				String msg=driver.findElement(By.xpath("//h1")).getText();
//				
//				if(msg.contains("Thank you for your purchase"))
//				{
//					System.out.println("Success !! Passed");
//				}
//				else
//				{
//					System.out.println("Failed");	 
//				}
//			
//				driver.quit();

	}

}

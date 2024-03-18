package com.jquery.datepicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		WebElement box = driver.findElement(By.id("datepicker"));
		box.click();

		WebElement month = driver.findElement(By.xpath("//a[@data-handler='next']"));
		month.click();

		WebElement date = driver.findElement(By.xpath("//a[@data-date='22']"));
		date.click();
		String selecteddate = box.getAttribute("value");

		System.out.println("Selected date is: " + selecteddate);

		driver.quit();
	}

}

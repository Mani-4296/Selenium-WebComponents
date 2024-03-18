package com.guvi.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpAndLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guvi.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		WebElement signup = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']"));
		signup.click();

		WebElement fname = driver.findElement(By.id("name"));
		fname.sendKeys("Mani");

		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("goinniloleupi-5708@yopmail.com");

		WebElement pwrd = driver.findElement(By.cssSelector("input[class='form-control password-err']"));
		pwrd.sendKeys("Password@1");

		WebElement phn = driver.findElement(By.xpath("//input[@class='form-control countrycode-left']"));
		phn.sendKeys("8899127812");

		WebElement signin = driver.findElement(By.linkText("Sign Up"));
		signin.click();

		WebElement profile = driver.findElement(By.id("profileDrpDwn"));
		profile.click();
		Select dropdown = new Select(profile);
		dropdown.selectByIndex(3);

		WebElement degree = driver.findElement(By.id("degreeDrpDwn"));
		degree.click();
		Select dropdown2 = new Select(degree);
		dropdown2.selectByVisibleText("Other");

		WebElement year = driver.findElement(By.xpath("//input[@placeholder='Enter year']"));
		year.sendKeys("2017");

		WebElement subbtn = driver.findElement(By.id("details-btn"));
		subbtn.click();

		System.out.println("All fileds are filled");
		System.out.println("Clicked on sign up button");

		System.out.println("Title of the page is: " + driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement message = wait.until((ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[1]/h1"))));

		String text = message.getText();
		String exp = "Almost Done! Check Your Inbox!";
		System.out.println(text);

		if (text.equalsIgnoreCase(exp)) {
			System.out.println("Sign up is success: Check email for next steps");
		} else {
			System.out.println("Sign up failed");
		}

		Thread.sleep(240000); // To verify email and activate the account
		driver.get("https://www.guvi.in/");
		WebElement lgn = driver.findElement(By.xpath("//*[@id=\"accountGroup\"]/ul/li[1]/a"));
		lgn.click();

		WebElement lgnemail = driver.findElement(By.id("email"));
		lgnemail.sendKeys("goinniloleupi-5708@yopmail.com");

		WebElement lgnpwrd = driver.findElement(By.id("password"));
		lgnpwrd.sendKeys("Password@1");

		WebElement lgnbtn = driver.findElement(By.id("login-btn"));
		lgnbtn.click();

		String pgtitle = driver.getTitle();
		System.out.println("Current page title is: " + pgtitle);

		if (pgtitle.equalsIgnoreCase("GUVI | Login")) {
			System.out.println("Login is success");
		} else {
			System.err.println("Login Failed");
		}

	}

}

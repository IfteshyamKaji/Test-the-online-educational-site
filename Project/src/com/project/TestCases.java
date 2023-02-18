package com.project;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
	// TC 001
	//Its a BUG ----  SignUp = if we take Blank Name then we Successfully Open Quiz
		@Test
	    public void Verify_Signupwith_BlankNameFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
			driver.findElement(By.id("name")).sendKeys("");
			driver.findElement(By.id("emailid")).sendKeys("Khushbuka663@gmail.com");
			driver.findElement(By.id("mobile")).sendKeys("3341116645");
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.id("agree")).click();       
			driver.findElement(By.id("emailbtn")).click();
			String expResult = "Please enter valid Name";
			String actResult = driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB) Quiz']")).getText();
	       //driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	
	//SignUp = Blank Email
	@Test
    public void Verify_Signupwith_BlankEmailFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("Khushbu");
		driver.findElement(By.id("emailid")).sendKeys("");
		driver.findElement(By.id("mobile")).sendKeys("2323334111");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		String expResult = "Please enter valid email";
		String actResult = driver.findElement(By.id("emailerr")).getText();
        //driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//Signup = BlankMobileNo
	@Test
    public void Verify_Signupwith_BlankMobileNoFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("Khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khushbukaji663@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		String expResult = "Please enter a valid number!";
		String actResult = driver.findElement(By.id("mobileerr")).getText();
        //driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//SignUp = More Than 10Number in MobileNo
	@Test
    public void Verify_Signupwith_InvalidMobileNoFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("Khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khushbukaji663@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("1234567890765422");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		String expResult = "Please enter a valid number!";
		String actResult = driver.findElement(By.id("mobileerr")).getText();
        //driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//SignUp = Repeat Registered Email 
	@Test
     public void Verify_SignupWith_AlreadyRegEmailFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khushbukaji@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("7039662618");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		System.out.println(driver.getTitle());
 		String expResult = "Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]";
		String actResult = driver.findElement(By.xpath("//*[text()='Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]']")).getText();
		//driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//Signup = Repeat Registered Mobile Number 
	@Test
    public void Verify_Signup_AlreadyRegMobileNoFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khushbukajiiii@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("7038662618");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		System.out.println(driver.getTitle());
		String expResult = "Mobile number already exists, please login with this mobile number";
		String actResult = driver.findElement(By.xpath("//*[text()='Mobile number already exists, please login with this mobile number']")).getText();
		//driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//Its a BUG = SignupDone with Special Character in mobile  No.
	@Test
    public void Verify_Signup_SpecialCharInMobNO() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khush@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("703866&^@#");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		String expResult = "Please Enter Valid Mobile Number";
		String actResult = driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB) Quiz']']")).getText();
		//driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	//Its a BUG = SignupDone with more than 40 Character in Name Textbox.
		@Test
	    public void Verify_Signup_MorethanFourtyCharName() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countb tn")).click();
			driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
			driver.findElement(By.id("name")).sendKeys("khushbu&^%#*&%cfvjuwdg6421czh7ut9hd52y790nhjcasu85gf");
			driver.findElement(By.id("emailid")).sendKeys("khush@gmail.com");
			driver.findElement(By.id("mobile")).sendKeys("7038662618");
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.id("agree")).click();       
			driver.findElement(By.id("emailbtn")).click();
			String expResult = "Please enter valid name";
			String actResult = driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB) Quiz']']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	//Signup = Signup Done
	@Test   
    public void VerifySignUpFunc() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("khushbu");
		driver.findElement(By.id("emailid")).sendKeys("khushbukaji@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("7038662618");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("agree")).click();       
		driver.findElement(By.id("emailbtn")).click();
		System.out.println(driver.getTitle());
		String expResult = "Practice Online Quiz | Take a Online Test - JavaByKiran";
		String actResult = driver.getTitle();
		//driver.close();
		Assert.assertEquals(actResult, expResult);
	}
	// Login= Invalid Mobile Number
	@Test
    public void Verify_LoginWith_InvalidMobNo() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7544331985");
		driver.findElement(By.id("loginbtn")).click();
		String expResult = "You have not registered with us. Please click signup tab to get registered";
		String actResult = driver.findElement(By.xpath("//*[text()='You have not registered with us. Please click signup tab to get registered']")).getText();
		//driver.close();
		Assert.assertEquals(actResult, expResult);
	  }
	//Its a Bug= login with blank no. then we get Please enter valid mobile number, If you have not registered, please click signup tab to get registered.
	// Login= Blank Mobile Number
		@Test
	    public void Verify_LoginWith_BlankMobNo() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("");
			driver.findElement(By.id("loginbtn")).click();
			String expResult = "Required";
			String actResult = driver.findElement(By.xpath("//*[text()='Please enter valid mobile number, If you have not registered, please click signup tab to get registered.']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		  }
	
	
	
	
	// Login= Valid Mobile Number
		@Test
	    public void Verify_LoginWith_ValidMobNo() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			System.out.println(driver.getTitle());
			String expResult = "Manual Testing(ISTQB) Quiz";
			String actResult = driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB) Quiz']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
		
	// Login= My Account
		@Test
		 public void Verify_LoginWith_MyAccountFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
       		driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
					
			String expResult = "Dashboard";
			String actResult = driver.findElement(By.xpath("//*[text()='Dashboard']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
    // Login= able to see PerformanceReport
		@Test
		 public void Verify_PerformanceReportFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		  	driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();				
			String expResult = "Performance Report";
			String actResult = driver.findElement(By.xpath("//*[text()='Performance Report']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
		//Passs
		// Dashboard= Test Attempted
		@Test
			 public void Verify_DashboardWith_TestAttempted() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
		    driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("View Details")).click();
			String expResult = "Test Attempted";
			String actResult = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/h4")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
		
		
		
		
		
   // Dashboard= Contribute with blank name 
		@Test
	  public void Verify_ContributeFunc_WithBlankName() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("Contribute")).click();
			driver.findElement(By.name("first_name")).sendKeys("");
			driver.findElement(By.name("email")).sendKeys("khushbukaji663@gmail.com");
			driver.findElement(By.name("phone_number")).sendKeys("7038662618");
			driver.findElement(By.name("submit")).click();
			String expResult = "required";
			String actResult = driver.findElement(By.xpath("//*[text()='required']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	// Dashboard= Contribute with blank Email
		@Test
	  public void Verify_ContributeFunc_WithBlankEmail() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("Contribute")).click();
			driver.findElement(By.name("first_name")).sendKeys("Khushbu");
			driver.findElement(By.name("email")).sendKeys("");
			driver.findElement(By.name("phone_number")).sendKeys("7038662618");
			driver.findElement(By.name("submit")).click();
			String expResult = "required";
			String actResult = driver.findElement(By.xpath("//*[text()='required']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	// Dashboard= Contribute with blank MobileNo
		@Test
		 public void Verify_ContributeFunc_WithBlankMobileNO() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("Contribute")).click();
			driver.findElement(By.name("first_name")).sendKeys("Khushbu");
			driver.findElement(By.name("email")).sendKeys("khushbukaji663@gmail.com");
			driver.findElement(By.name("phone_number")).sendKeys("");
			driver.findElement(By.name("submit")).click();
			String expResult = "required";
			String actResult = driver.findElement(By.xpath("//*[text()='required']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	// Dashboard= Contribute Succesfully
		@Test
		 public void Verify_ContributeFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("Contribute")).click();
			driver.findElement(By.name("first_name")).sendKeys("Khushbu");
			driver.findElement(By.name("email")).sendKeys("khushbukaji663@gmail.com");
			driver.findElement(By.name("phone_number")).sendKeys("7038662618");
			driver.findElement(By.name("submit")).click();
			String expResult = "Mail Sent. Thank you Khushbu, we will contact you shortly.";
			String actResult = driver.findElement(By.id("mail_success")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
		
	// Dashboard= Moderator Succesfully
		@Test
		 public void Verify_ModeratorFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.partialLinkText("Contribute")).click();
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.id("show-moderator")).click();
			
			String expResult = "You will get question for review";
			String actResult = driver.findElement(By.xpath("//*[text()='You will get question for review']")).getText();
			//driver.close();
			Assert.assertEquals(actResult, expResult);
		}
	
	//BUG = Blank Name rakhne k bad bhi update hota
	// Update Functionality with blank name
		@Test 
		public void VerifyUpdateFunction_WithBlankName() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbuukaji663@gmail.com");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("7038662618");
			driver.findElement(By.id("updatebtn")).click();

			String ExpMsg = "Please Enter Name";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);
		}
		
		//BUG = Blank Email rakhne k bad Enter mail nh aata Exists likh k aata
		// Update Functionality with blank Email
			@Test 
			public void VerifyUpdateFunction_WithBlankEmail() {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.qa.jbktest.com/online-exam#Testing");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
				driver.findElement(By.id("countbtn")).click();
				driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
				driver.findElement(By.id("loginbtn")).click();
				driver.findElement(By.partialLinkText("Account")).click();
				driver.findElement(By.partialLinkText("View Profile")).click();
				driver.findElement(By.id("name")).clear();
				driver.findElement(By.id("name")).sendKeys("Khushbu");
				driver.findElement(By.id("emailid")).clear();
				driver.findElement(By.id("emailid")).sendKeys("");
				driver.findElement(By.id("mobile")).clear();
				driver.findElement(By.id("mobile")).sendKeys("7038662618");
				driver.findElement(By.id("updatebtn")).click();

				String ExpMsg = "Please Enter Email";
				String ActMsg = driver.findElement(By.xpath("//*[text()='Email Address already exists']")).getText();
			//	driver.close();
				Assert.assertEquals(ActMsg, ExpMsg);
			}
	//BUG = Blank Mobileno rakhne k bad Enter mobile no nh aata Exists aata h
	// Update Functionality with blank Mobile no
		@Test 
		public void VerifyUpdateFunction_WithBlankMobileNO() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("Khushbu");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbukaji663@gmail.com");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("");
			driver.findElement(By.id("updatebtn")).click();

			String ExpMsg = "Please Enter Mobile No.";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Mobile number already exists']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);
		}
	//IF  we change the name then we get error of Email Address already exists
		// Update Functionality With Change Name
		@Test 
		public void VerifyUpdateFunction_WithUpdatedName() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("Ifteshyam");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbukaji663@gmail.com");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("7038662618");
			driver.findElement(By.id("updatebtn")).click();

			String ExpMsg = "Profile successfully updated";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Email Address already exists']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);
		}
		
	// Update Functionality With Change Email
		@Test 
		public void VerifyUpdateFunction_WithUpdatedEmail() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("Khushbu");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbukaji663@gmail.co");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("7038662618");
			driver.findElement(By.id("updatebtn")).click();

			String ExpMsg = "Profile successfully updated";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);
			}
	// Update Functionality With Change Mobile No
		@Test 
		public void VerifyUpdateFunction_WithUpdatedMobileNo() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("Khushbu");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbukaji6@gmail.com");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("7038662618");
			driver.findElement(By.id("updatebtn")).click();

			String ExpMsg = "Profile successfully updated";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);
		}
	// its a BUG If we add Special Charter in Mobile No. Textbox then We get Successfully UpDated Msg
		// Update Functionality With Special Charcter in mobile no
		@Test 
		public void VerifyUpdateFunction_WithSpecialCharInMobileNo() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.partialLinkText("Account")).click();
			driver.findElement(By.partialLinkText("View Profile")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("Khushbu");
			driver.findElement(By.id("emailid")).clear();
			driver.findElement(By.id("emailid")).sendKeys("khushbukaji6@gmail.com");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("70%$662618");
			driver.findElement(By.id("updatebtn")).click();

		String ExpMsg = "Please Enter Valid Mobile Number";
		String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
		//driver.close();
		Assert.assertEquals(ActMsg, ExpMsg);
   }	
		// its a BUG If we take 11digit  in Mobile No. Textbox then We get Successfully UpDated Msg
		// Update Functionality With 11 Digit in mobile no
		@Test 
		public void VerifyUpdateFunction_WithInvalidMobileNo() {
					System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
					WebDriver driver = new ChromeDriver();
					driver.get("https://www.qa.jbktest.com/online-exam#Testing");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
					driver.findElement(By.id("countbtn")).click();
					driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
					driver.findElement(By.id("loginbtn")).click();
					driver.findElement(By.partialLinkText("Account")).click();
					driver.findElement(By.partialLinkText("View Profile")).click();
					driver.findElement(By.id("name")).clear();
					driver.findElement(By.id("name")).sendKeys("Khushbu");
					driver.findElement(By.id("emailid")).clear();
					driver.findElement(By.id("emailid")).sendKeys("khushbukaji6gmail.com");
					driver.findElement(By.id("mobile")).clear();
					driver.findElement(By.id("mobile")).sendKeys("703866261818");
					driver.findElement(By.id("updatebtn")).click();

				String ExpMsg = "Please Enter 10 Digit Mobile Number";
				String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
				//driver.close();
				Assert.assertEquals(ActMsg, ExpMsg);
		   }		
	
	
	
	
	// Update Functionality
	@Test 
	public void VerifyUpdateFunctionality() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.partialLinkText("View Profile")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("khushbu");
		driver.findElement(By.id("emailid")).clear();
		driver.findElement(By.id("emailid")).sendKeys("khushbukaji60gmail.com");
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys("7038662618");
		driver.findElement(By.id("updatebtn")).click();

		String ExpMsg = "Profile successfully updated";
		String ActMsg = driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
		//driver.close();
		Assert.assertEquals(ActMsg, ExpMsg);
	}
	// Logout Func
		@Test 
		public void Verify_LogutFunc() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.qa.jbktest.com/online-exam#Testing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
			driver.findElement(By.id("countbtn")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7038662618");
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[2]")).click();
			String ExpMsg = "Don't forget to sign up for our java tips & tricks!";
			String ActMsg = driver.findElement(By.xpath("//*[text()='Don't forget to sign up for our java tips & tricks!']")).getText();
			//driver.close();
			Assert.assertEquals(ActMsg, ExpMsg);		
	
}
}
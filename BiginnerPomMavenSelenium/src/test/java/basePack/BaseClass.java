package basePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.xml.fastinfoset.sax.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static WebDriver driver;
	protected static Properties prop;
		
		protected static ExtentHtmlReporter exthtmlreport;
		protected static ExtentTest test;
		protected static ExtentReports report;
		
		@BeforeTest
		public void setup() throws IOException {
			/*
			 * prop=new Properties(); //FileInputStream fis=new
			 * FileInputStream(System.getProperty("user.dir")+
			 * "\\src\\test\\resources\\Config\\Config.properties"); //prop.load(fis);
			 * String browserName=prop.getProperty("browser");
			 * 
			 * if(browserName.equalsIgnoreCase("Chrome")) {
			 *  } else {
			 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }
			 */
			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			
			//WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			
			//WebDriverManager.edgedriver().setup();
			//driver=new EdgeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			exthtmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\ExtentHtmlReport.html");
			exthtmlreport.config().setDocumentTitle("Automation Report");
			exthtmlreport.config().setReportName("Fuctional Testing Report");
			exthtmlreport.config().setTheme(Theme.STANDARD);
			
			report = new ExtentReports();
			report.attachReporter(exthtmlreport);
			report.setSystemInfo("Hostname","LocalHost");
			report.setSystemInfo("OS", "Windows10");
			report.setSystemInfo("Tester name", "Md. Bhuya");
			report.setSystemInfo("Browser name", "Chrome");
			
			
			
			
			
			
		}
		
		@AfterMethod
		public void extentStatus(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, "Test Case Failed Is : "+result.getName());
				test.log(Status.FAIL, "Test Case Failed Is : "+result.getThrowable());
				String screenShotPath=getScreenShot(result.getName());
				test.addScreenCaptureFromPath(screenShotPath);
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, "Test Case Skiped Is : "+result.getName());
				
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test Case Paased Is : "+result.getName());
				
			}
		}
		
		public  static String getScreenShot(String screenshotName) throws IOException {
			String dateName=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotName+"--"+dateName+ ".png";
			FileUtils.copyFile(f, new File(destination));
			return destination;
			
		}
		@AfterTest
		public void teardown() {
			report.flush();
			driver.quit();
		}
		


}

package com.excelr.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHRMBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() {
		loadConfigFile();
		// read the browser value
		// apply if else based on the value

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	public void loadConfigFile() {
		prop = new Properties();
		FileInputStream fis;
		String propPath = "./src/main/java/com/excelr/config/config.properties";
		try {
			fis = new FileInputStream(propPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Property File Not Found");
		} catch (IOException e) {
			System.out.println("Unable to read property file");
		}
	}
	
	public void captureScreenshot(String tcName) {
		String filePath = "./Screenshot/" + tcName + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tearDown() {
		driver.quit();
	}
}

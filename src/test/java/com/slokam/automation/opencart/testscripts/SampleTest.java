package com.slokam.automation.opencart.testscripts;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SampleTest {
	
	@Test
	public void sampleMohan() {
		Assert.assertEquals("test", "test");
	}
	
	//@Test
	public void testChromeMohan() {
		WebDriver driver = new ChromeDriver();
		//it will open the goggle page
		driver.get("http://google.in"); 
		//we expect the title “Google “ should be present 
		String Expectedtitle = "Google";
		//it will fetch the actual title 
		String Actualtitle = driver.getTitle();
		System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
		//it will compare actual title and expected title
		Assert.assertEquals(Actualtitle, Expectedtitle);
		//print out the result
		System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
	}

	//@Test
	public void testChrome() {
		System.out.println("Starting the testcase - testChrome " + System.currentTimeMillis());
		System.out.println("I am testChrome");

		Capabilities cap = DesiredCapabilities.chrome();
		URL url = null;
		try {
			//url = new URL("http://localhost:4444/wd/hub");
			url = new URL("http://localhost:8082");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		
		driver.get("http://localhost:8082");
		driver.quit();
		System.out.println("End of my testcase - testChrome " + System.currentTimeMillis());
	}

	//@Test
	public void testFirefox() {
		System.out.println("Starting the testcase - testFirefox " + System.currentTimeMillis());
		System.out.println("I am testFirefox");
		Capabilities cap = DesiredCapabilities.firefox();
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://localhost/opencart/");
		driver.quit();
		System.out.println("End of my testcase - testFirefox " + System.currentTimeMillis());
	}

	//@Test
	public void testChrome1() {
		System.out.println("Starting the testcase - testChrome " + System.currentTimeMillis());
		System.out.println("I am testChrome1");
		Capabilities cap = DesiredCapabilities.chrome();
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://localhost/opencart/");
		driver.quit();
		System.out.println("End of my testcase - testChrome1 " + System.currentTimeMillis());
	}

	//@Test
	public void testFirefox1() {
		System.out.println("Starting the testcase - testFirefox " + System.currentTimeMillis());
		System.out.println("I am testFirefox1");
		Capabilities cap = DesiredCapabilities.firefox();
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://localhost/opencart/");
		driver.quit();
		System.out.println("End of my testcase - testFirefox1 " + System.currentTimeMillis());
	}

	//@Test
	public void testChrome2() {
		System.out.println("Starting the testcase - testChrome " + System.currentTimeMillis());
		System.out.println("I am testChrome2");
		Capabilities cap = DesiredCapabilities.chrome();
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://localhost/opencart/");
		driver.quit();
		System.out.println("End of my testcase - testChrome2 " + System.currentTimeMillis());
	}

	//@Test
	public void testFirefox2() {
		System.out.println("Starting the testcase - testFirefox " + System.currentTimeMillis());
		System.out.println("I am testFirefox2");
		Capabilities cap = DesiredCapabilities.firefox();
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://localhost/opencart/");
		driver.quit();
		System.out.println("End of my testcase - testFirefox2 " + System.currentTimeMillis());
	}
}

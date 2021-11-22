package com.example.punto5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class Punto5ApplicationTests {

	private String baseUrl;

	private FirefoxDriver browser;

	private WebDriverWait wait;

	@BeforeEach
	void init(){
		this.baseUrl = "http://localhost:4200";
		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		//options.addArguments("--headless");
		options.merge(DesiredCapabilities.firefox());

		this.browser = new FirefoxDriver(options);
		this.wait = new WebDriverWait(browser, 15);
	}


	@Test
	void TestAddOneElement() {
		browser.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstSelect")));
		WebElement firstSelectW = browser.findElementById("firstSelect");
		Select firstSelect = new Select(firstSelectW);
		firstSelect.selectByIndex(1);
		WebElement addBtn = browser.findElementById("addBtn");
		addBtn.click();
		WebElement secondSelectW = browser.findElementById("SecondSelect");
		Select secondSelect = new Select(secondSelectW);
		assertTrue(secondSelect.getOptions().size() == 1 && secondSelect.getOptions().get(0).getText().equals("Pollo"));
	}

	@Test
	void TestRemoveOneElement() {
		browser.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstSelect")));
		WebElement firstSelectW = browser.findElementById("firstSelect");
		Select firstSelect = new Select(firstSelectW);
		firstSelect.selectByIndex(1);
		WebElement addBtn = browser.findElementById("addBtn");
		addBtn.click();
		WebElement secondSelectW = browser.findElementById("SecondSelect");
		Select secondSelect = new Select(secondSelectW);
		secondSelect.selectByIndex(0);
		WebElement removeBtn = browser.findElementById("removeBtn");
		removeBtn.click();
		assertTrue(secondSelect.getOptions().size() == 0);
	}

	@Test
	void TestAddMoreThanOneElement() {
		browser.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstSelect")));
		WebElement firstSelectW = browser.findElementById("firstSelect");
		Select firstSelect = new Select(firstSelectW);
		firstSelect.selectByIndex(1);
		firstSelect.selectByIndex(0);
		List<String> stockList = new ArrayList<>();
		stockList.add("Pan");
		stockList.add("Pollo");

		WebElement addBtn = browser.findElementById("addBtn");
		addBtn.click();
		WebElement secondSelectW = browser.findElementById("SecondSelect");
		Select secondSelect = new Select(secondSelectW);
		
		int counter = 0;
		for (WebElement optElement : secondSelect.getOptions()) {
			if(stockList.contains(optElement.getText())){
				counter++;
			}
		}
		assertTrue(secondSelect.getOptions().size() == 2 && counter == 2);
	}

	@Test
	void TestRemoveMoreThanOneElement() {
		browser.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstSelect")));
		WebElement firstSelectW = browser.findElementById("firstSelect");
		Select firstSelect = new Select(firstSelectW);
		firstSelect.selectByIndex(1);
		firstSelect.selectByIndex(0);
		List<String> stockList = new ArrayList<>();
		stockList.add("Pan");
		stockList.add("Pollo");
		stockList.add("Carne");
		stockList.add("Tomate");
		stockList.add("Lechuga");

		WebElement addBtn = browser.findElementById("addBtn");
		addBtn.click();
		WebElement secondSelectW = browser.findElementById("SecondSelect");
		Select secondSelect = new Select(secondSelectW);
		secondSelect.selectByIndex(1);
		secondSelect.selectByIndex(0);
		WebElement removeBtn = browser.findElementById("removeBtn");
		removeBtn.click();
		int counter = 0;
		for (WebElement optElement : firstSelect.getOptions()) {
			if(stockList.contains(optElement.getText())){
				counter++;
			}
		}
		assertTrue(firstSelect.getOptions().size() == 5 && counter == 5 && secondSelect.getOptions().size() == 0);
	}

	@Test
	void TestAddAllThanOneElement() {
		browser.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstSelect")));
		WebElement firstSelectW = browser.findElementById("firstSelect");
		Select firstSelect = new Select(firstSelectW);
		firstSelect.selectByIndex(1);
		firstSelect.selectByIndex(0);
		firstSelect.selectByIndex(2);
		firstSelect.selectByIndex(3);
		firstSelect.selectByIndex(4);

		List<String> stockList = new ArrayList<>();
		stockList.add("Pan");
		stockList.add("Pollo");
		stockList.add("Carne");
		stockList.add("Tomate");
		stockList.add("Lechuga");

		WebElement addBtn = browser.findElementById("addBtn");
		addBtn.click();
		WebElement secondSelectW = browser.findElementById("SecondSelect");
		Select secondSelect = new Select(secondSelectW);
		
		int counter = 0;
		for (WebElement optElement : secondSelect.getOptions()) {
			if(stockList.contains(optElement.getText())){
				counter++;
			}
		}
		assertTrue(secondSelect.getOptions().size() == 5 && counter == 5);
	}

}

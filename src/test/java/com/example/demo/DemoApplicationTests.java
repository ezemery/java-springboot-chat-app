package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private ChatPage chatPage;
	private LoginPage loginPage;
	private SignupPage signupPage;


	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@BeforeEach
	public void beforeEach() {
		chatPage = new ChatPage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignupPage(driver);
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@Test
	void testSignupPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:" + port + "/signup");
		signupPage.registerUser("Ezechukwu","Emmanuel","eze09","ezemery");
		WebElement loginText = wait.until(ExpectedConditions.elementToBeClickable(signupPage.getLoginMessage()));
		assertEquals("login", loginText.getText());
	}

	@Test
	void testLoginAndSubmitMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:" + port + "/login");
		loginPage.loginUser("eze09","ezemery");
		Boolean chatPageButton = wait.until(ExpectedConditions.attributeToBeNotEmpty(chatPage.submitButton,"type"));
		assertEquals(true, chatPageButton);

		chatPage.inputChatMessage("Hello","Shout");
		chatPage.inputChatMessage("Hi","Say");
		List<WebElement> messageList = wait.until(ExpectedConditions.visibilityOfAllElements(chatPage.getMessageList()));
		assertEquals(2, messageList.size());

	}

}

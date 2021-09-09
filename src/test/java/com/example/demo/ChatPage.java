package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChatPage {

    @FindBy(id = "messageText")
    WebElement messageText;

    @FindBy(id = "messageType")
    WebElement messageType;

    @FindBy(id = "submit-button")
    WebElement submitButton;

    @FindBy(className = "messageList")
    List<WebElement> messageList;


    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMessageText(String value){
        messageText.sendKeys(value);
    }

    public List<WebElement> getMessageList(){
        return  messageList;
    }

    public void submitForm() {
        submitButton.submit();
    }

    public void setSelectText(String value){
        Select type = new Select(messageType);
        type.selectByVisibleText(value);
    }

    public void inputChatMessage(String message, String type){
        setMessageText(String.valueOf(message));
        setSelectText(String.valueOf(type));
        submitForm();
    }
}

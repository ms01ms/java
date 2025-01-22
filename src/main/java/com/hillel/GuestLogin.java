package com.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GuestLogin {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
            WebElement guestLoginButton = driver.findElement(By.xpath("//button[contains(text(), 'Guest log in')]"));
            guestLoginButton.click();
            Thread.sleep(2000);
            List<WebElement> borderMenuItems = driver.findElements(By.cssSelector("a.btn.btn-white.btn-sidebar.sidebar_btn.-active, a.btn.btn-white.btn-sidebar.sidebar_btn[href='/panel/expenses'], a.btn.btn-white.btn-sidebar.sidebar_btn[href='/panel/instructions']"));

            for (WebElement item : borderMenuItems) {
                System.out.println(item.getText());
            }
        } catch (Exception e) {
            System.out.println("The test failed with an error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}


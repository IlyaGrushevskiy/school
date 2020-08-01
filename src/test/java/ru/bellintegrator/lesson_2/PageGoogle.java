package ru.bellintegrator.lesson_2;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;

public class PageGoogle {
    private WebDriver chromeDriver;

    WebElement fieldSearch;
    WebElement buttonSearch;

    List<WebElement> searchResultList;

    public List<WebElement> getSearchResult() {
        return chromeDriver.findElements(By.xpath("//div[@id='res']//div[@class='g']"));
    }

    public PageGoogle(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        fieldSearch = chromeDriver.findElement(By.xpath("//input[@title='Поиск']"));
        buttonSearch = chromeDriver.findElement(By.xpath("//div[@class='hsuHs']/span"));
    }

    public void find(String findText){
        fieldSearch.click();
        fieldSearch.sendKeys(findText);
        fieldSearch.sendKeys(Keys.ENTER);
    }
}

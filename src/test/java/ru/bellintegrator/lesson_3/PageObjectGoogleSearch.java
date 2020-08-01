package ru.bellintegrator.lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectGoogleSearch {

    private String selectorSearchItems = "//div[@class='g']";
    private String selectorResultURL = ".//div[@class='r']/a[@href]";
    private String selectorResultNamePage = ".//div[@class='r']/a[@href]";
    private String selectorResultDiscription = ".//div[@class='s']";

    private WebDriver webDriver;

    private List<WebElement> searchItems = new ArrayList<>();
    private List<Map<String, Object>> collectResult = new ArrayList<>();

    public PageObjectGoogleSearch(WebDriver webDriver, String searchText) {
        this.webDriver = webDriver;
        this.webDriver.get("https://www.google.com/search?q="+searchText);
        searchItems = webDriver.findElements(By.xpath(selectorSearchItems));
    }

    public PageObjectGoogleSearch(WebDriver webDriver) {
        this.webDriver = webDriver;
        searchItems = webDriver.findElements(By.xpath(selectorSearchItems));
    }

    public List<Map<String, Object>> getCollectResult() {

        for (WebElement result: searchItems) {
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorResultURL)).getAttribute("href"),
                    "NAME_PAGE", result.findElement(By.xpath(selectorResultNamePage)).getText(),
                    "DISCRIPTION", result.findElement(By.xpath(selectorResultDiscription)).getText()
            ));
        }

        return collectResult;
    }
}

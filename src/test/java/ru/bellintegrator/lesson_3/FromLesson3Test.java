package ru.bellintegrator.lesson_3;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.bellintegrator.utils.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class FromLesson3Test extends WebDriverSettings {

    private String searchText = "открытие";
    private String searchTextResult = "Банк «Открытие» — вклады";

    @Test
    @Description (value = "Тест сайта Банка Открытие")
    public void test_3_1() {
        PageObjectGoogleSearch pageObjectGoogleSearch = new PageObjectGoogleSearch(chromeDriver, searchText);
        List<Map<String,Object>> searchResult = pageObjectGoogleSearch.getCollectResult();
        //searchResult.stream().forEach(x-> System.out.printf(x.get("NAME_PAGE").toString() + "\n"));
        FromLesson3Steps.checkContainsName(searchResult, searchTextResult, chromeDriver);
    }
}

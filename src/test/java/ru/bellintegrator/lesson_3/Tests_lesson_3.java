package ru.bellintegrator.lesson_3;

import org.junit.jupiter.api.Test;
import ru.bellintegrator.settings.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class Tests_lesson_3 extends WebDriverSettings {

    private String searchText = "открытие";

    @Test
    public void test_3_1() {
        PageObjectGoogleSearch pageObjectGoogleSearch = new PageObjectGoogleSearch(chromeDriver, searchText);
        List<Map<String,Object>> searchResult = pageObjectGoogleSearch.getCollectResult();
        searchResult.stream().forEach(x-> System.out.printf(x.get("NAME_PAGE").toString() + "\n"));
    }
}

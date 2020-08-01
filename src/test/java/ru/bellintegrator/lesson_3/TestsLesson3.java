package ru.bellintegrator.lesson_3;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bellintegrator.lesson_2.PageGoogle;
import ru.bellintegrator.utils.WebDriverSettings;

public class TestsLesson3 extends WebDriverSettings {

    String pageURL = "https://www.google.com/";
    String pageTitle = "Google";
    String searchText = "Гладиолус";
    String searchLink = "wikipedia.org";
    int minSearchResultCount = 3;

    @Test
    @Description(value = "Проверка количества найденных значений")
    public void googleFindResCount(){
        StepsLesson3.openGooglePage(chromeDriver, pageURL, pageTitle);
        StepsLesson3.getSearchResultSize(chromeDriver, searchText, minSearchResultCount);
    }

    @Test
    @Description(value = "Проверка налиячия сайта {searchLink} в результатах поиска")
    public void googleFindLinkWiki(){
        StepsLesson3.openGooglePage(chromeDriver,pageURL, pageTitle);
        StepsLesson3.getSearchResultSiteName(chromeDriver, searchText, searchLink);
    }
}

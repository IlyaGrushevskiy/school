package ru.bellintegrator.lesson_3;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.bellintegrator.lesson_2.PageGoogle;
import ru.bellintegrator.utils.CustomUtils;

public class StepsLesson3 {

    @Step ("Открыть страницу сайта Google")
    public static void openGooglePage (WebDriver driver, String pageURL, String pageTitle) {
        driver.get(pageURL);
        String title = driver.getTitle();
        if (title.contains(pageTitle)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false,"Тайтл не корректен");
        }
    }

    @Step ("Проверить количество найденных результатов")
    public static void getSearchResultSize (WebDriver driver, String searchText, int minSearchResultCount) {
        PageGoogle pageGoogle = new PageGoogle(driver);
        pageGoogle.find(searchText);
        if (pageGoogle.getSearchResult().size() > minSearchResultCount) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false);
        }
    }

    @Step ("Проверить наличие сайта в результатах поиска")
    public static void getSearchResultSiteName(WebDriver driver, String searchText, String searchLink) {
        PageGoogle pageGoogle = new PageGoogle(driver);
        pageGoogle.find(searchText);
        if (pageGoogle.getSearchResult().stream().anyMatch(x->x.getText().contains(searchLink))) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false);
        }
    }
}

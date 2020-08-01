package ru.bellintegrator.lesson_3;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.bellintegrator.utils.CustomUtils;

import java.util.List;
import java.util.Map;

public class FromLesson3Steps {

    @Step ("Шаг 1: Проверка наличия имени - {name}")
    public static void checkContainsName(List<Map<String,Object>> searchResult, String searchText, WebDriver driver) {
        if (searchResult.stream().anyMatch(x->x.get("NAME_PAGE").toString().contains(searchText))) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false, "Название не найдено");
        }
    }
}

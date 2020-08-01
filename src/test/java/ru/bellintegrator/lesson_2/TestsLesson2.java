package ru.bellintegrator.lesson_2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bellintegrator.utils.WebDriverSettings;

public class TestsLesson2 extends WebDriverSettings {

    String pageURL = "https://www.google.com/";
    String pageTitle = "Google";
    String searchText = "Гладиолус";
    String searchLink = "wikipedia.org";
    int minSearchResultCount = 3;

    @Test
    @Description(value = "Проверка количества найденных значений")
    public void googleFindResCount(){
        chromeDriver.get(pageURL);
        String title = chromeDriver.getTitle();
        Assertions.assertTrue(title.contains(pageTitle),"Тайтл не корректен");
        PageGoogle pageGoogle = new PageGoogle(chromeDriver);
        pageGoogle.find(searchText);
        Assertions.assertTrue((pageGoogle.getSearchResult().size() > minSearchResultCount),
                "Количество найденных результатов меньше " + minSearchResultCount);
    }


    @Test
    @Description(value = "Проверка налиячия сайта {searchLink} в результатах поиска")
    public void googleFindLinkWiki(){
        chromeDriver.get(pageURL);
        String title = chromeDriver.getTitle();
        Assertions.assertTrue(title.contains(pageTitle),"Тайтл не корректен");
        PageGoogle pageGoogle = new PageGoogle(chromeDriver);
        pageGoogle.find(searchText);
        Assertions.assertTrue(
                pageGoogle.getSearchResult().stream().anyMatch(x->x.getText().contains(searchLink))
                , "Заданный сайт \"" + searchLink + "\" не найден"
        );
    }
}

package ru.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends WebDriverSettings {

    String pageSearch = "https://www.google.com/";
    String pageTitle = "Google";
    String searchText = "Гладиолус";
    String searchLink = "wikipedia.org";
    int minSearchResultCount = 3;

    @Test
    public void googleFindResCount(){
        chromeDriver.get(pageSearch);
        String title = chromeDriver.getTitle();
        Assertions.assertTrue(title.contains(pageTitle),"Тайтл не корректен");
        PageGoogle pageGoogle = new PageGoogle(chromeDriver);
        pageGoogle.find(searchText);
        Assertions.assertTrue((pageGoogle.getSearchResult().size() > minSearchResultCount),
                "Количество найденных результатов меньше " + minSearchResultCount);
    }


    @Test
    public void googleFindLinkWiki(){
        chromeDriver.get(pageSearch);
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

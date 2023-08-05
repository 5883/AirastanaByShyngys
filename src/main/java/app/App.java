package app;

import app.pages.SearchPage;

public class App {

    public SearchPage searchPage;

    public App() {
        searchPage = PageBuilder.buildSearchPage();
    }
}

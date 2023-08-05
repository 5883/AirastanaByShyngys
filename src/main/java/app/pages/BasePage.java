package app.pages;
import app.AppConfig;
import com.codeborne.selenide.Selenide;
import helpers.Trim;
import java.util.Random;

import static app.AppConfig.baseUrl;

public abstract class BasePage {

    protected String pageUrl;
    protected Random random;

    public BasePage() {
        this.pageUrl = "/";
        this.random = new Random();
    }

    public void open() {
        String url = Trim.rtrim(baseUrl, "/");
        Selenide.open(url);
    }
}

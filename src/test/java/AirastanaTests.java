import org.testng.annotations.Test;

public class AirastanaTests extends A_BaseTest {

    @Test
    public void searchFlights() {
        app.searchPage.open();
        app.searchPage.clickToAcceptButton();
        app.searchPage.selectFromCity();
        app.searchPage.selectToCity();
        app.searchPage.selectFromToDates();
        app.searchPage.clickToSearchButton();
    }
}

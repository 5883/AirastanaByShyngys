package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage extends BasePage {

    protected SelenideElement acceptButton;
    protected SelenideElement fromField;
    protected SelenideElement searchInput;
    protected SelenideElement fromFieldText;
    protected SelenideElement toField;
    protected SelenideElement searchFields;
    protected SelenideElement toFieldText;
    protected SelenideElement dateFrom;
    protected SelenideElement firstCalendar;
    protected SelenideElement validDates;
    protected Integer randomDate = this.random.nextInt(11 - 9 + 1) + 9;
    protected  SelenideElement searchButton;
    public SearchPage() {
        super();
        this.acceptButton = $("#accept-cookies");
        this.fromField = $(By.xpath("//div//button[@data-id='MainBookingOriginsDropdown']"));
        this.searchInput = $(By.xpath("//div[@class='bs-searchbox']/input"));
        this.fromFieldText = $(By.xpath("//div//button[@data-id='MainBookingOriginsDropdown']/span"));
        this.toField = $(By.xpath("//div//button[@data-id='MainBookingDestinationsDropdown']"));
        this.toFieldText = $(By.xpath("//div//button[@data-id='MainBookingDestinationsDropdown']/span"));
        this.searchFields = $$(By.xpath("//div[@class='bs-searchbox']/input")).get(1);
        this.dateFrom = $("#date1");
        this.firstCalendar = $(By.xpath("//table[@class='month1']"));
        this.validDates = $$(By.xpath("//td/div")).get(randomDate);
        this.searchButton = $(By.xpath("//button[@id='main-booking-search-desktop-btn']"));

    }

    public void clickToAcceptButton() {
        if (this.acceptButton.exists()) {
            this.acceptButton.shouldBe(Condition.visible).click();
        }
    }

    public void selectFromCity() {
        this.fromField.click();
        if (this.searchInput.isEnabled()) {
            this.searchInput.shouldBe(Condition.visible).click();
            this.searchInput.setValue("Актау").sendKeys(Keys.RETURN);
            this.fromFieldText.shouldHave(Condition.text("Актау (SCO)"));
        } else {
            System.out.println("Поле для поиска города отправки недоступен");
        }
    }

    public void selectToCity() {
        this.toField.click();
        if (this.searchFields.isEnabled()) {
            this.searchFields.shouldBe(Condition.visible).click();
            this.searchFields.setValue("Алматы").sendKeys(Keys.RETURN);
            this.toFieldText.shouldHave(Condition.text("Алматы (ALA)"));
        }
    }

    public void selectFromToDates() {
        this.dateFrom.click();
        this.firstCalendar.shouldBe(Condition.visible);
        if (this.validDates.exists()) {
            this.validDates.shouldBe(Condition.visible).doubleClick();
        }
    }

    public void clickToSearchButton(){
        try{
            this.searchButton.shouldBe(Condition.enabled).doubleClick();
        } catch (Error error){
            System.out.println("Ошибка нажатие на кнопку 'Поиск'" + error.getMessage());
        }
    };
}

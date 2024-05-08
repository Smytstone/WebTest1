package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebFormTest {

    @Test
    public void shouldGetSuccessOrder() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Александр");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldNotGetSuccessOrderByNameTestCase1() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Alex");
        form.$("[data-test-id=phone] input").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldNotGetSuccessOrderByNameTestCase2() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("");
        form.$("[data-test-id=phone] input").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldNotGetSuccessOrderByPhoneTestCase1() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Александр");
        form.$("[data-test-id=phone] input").setValue("89990000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldNotGetSuccessOrderByPhoneTestCase2() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Александр");
        form.$("[data-test-id=phone] input").setValue("");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldNotGetSuccessOrderByFlag() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Александр");
        form.$("[data-test-id=phone] input").setValue("+79990000000");
//        form.$("[data-test-id=agreement]").click();
        form.$(".button__text").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

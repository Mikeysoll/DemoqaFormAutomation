package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    public ModalComponent checkResult(String key, String value) {
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }

    public ModalComponent closeModal() {
        $("#closeLargeModal").click();
        return this;
    }
}

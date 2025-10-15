package data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;
public class TestData {

    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    public  String  firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    userEmail = fakerEn.internet().emailAddress(),
                    gender = faker.options().option("Male", "Female", "Other"),
                    userNumber = faker.number().digits(10);

                    Date age = faker.date().birthday(18, 70);
    public  String  day = new SimpleDateFormat("dd", Locale.US).format(age),
                    month = new SimpleDateFormat("MMMM", Locale.US).format(age),
                    year = new SimpleDateFormat("yyyy", Locale.US).format(age),

                    subject = faker.options().option("Maths","Accounting","Arts","Social Studies","Physics","Chemistry",
                            "Computer Science","Commerce","Economics","Civics","English","Hindi","Biology","History"),
                    hobby = faker.options().option("Sports", "Reading", "Music"),
                    currentAddress = faker.address().fullAddress(),
                    state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
                    city = getCityByState(state);

   private  String getCityByState(String state){

        return switch (state) {
            case "NCR" ->           faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" ->       faker.options().option("Karnal", "Panipat");
            case "Rajasthan" ->     faker.options().option("Jaipur", "Jaiselmer");
        default -> "";
        };

    }

}

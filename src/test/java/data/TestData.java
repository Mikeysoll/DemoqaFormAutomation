package data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public  String  firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    userEmail = faker.internet().emailAddress(),
                    gender = faker.options().option("Male", "Female", "Other"),
                    userNumber = faker.number().digits(10),

                    day = String.format("%02d", faker.number().numberBetween(1, 28)),
                    month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
                    year = String.valueOf(faker.number().numberBetween(1900, 2100)),

                    subject = faker.options().option("Maths", "Physics", "Chemistry", "Commerce", "Economics", "Computer Science ", "Arts"),
                    hobby = faker.options().option("Sports", "Reading", "Music"),
                    currentAddress = faker.address().fullAddress(),
                    state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
                    city = getCityByState(state);

   private  String getCityByState(String state){

        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "";
        };

    }

}

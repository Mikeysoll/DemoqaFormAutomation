package tests;

import data.TestData;
import org.junit.jupiter.api.Test;

public class PFFakerDataTests extends TestBase{

    @Test
    void fillFormTest() {

        TestData data = new TestData();

        formPage.openPage()
                        .setFirstName(data.firstName)
                        .setLastName(data.lastName)
                        .setEmail(data.userEmail)
                        .setGender(data.gender)
                        .setUserNumber(data.userNumber)
                        .setDateOfBirth(data.day, data.month, data.year)
                        .setSubjects(data.subject)
                        .setHobbies(data.hobby)
                        .setPicture("img/pic.jpg")
                        .setAddress(data.currentAddress)
                        .setState(data.state)
                        .setCity(data.city)
                        .submitForm()

                        .checkResult("Student Name", data.firstName + " " + data.lastName)
                        .checkResult("Student Email", data.userEmail)
                        .checkResult("Gender", data.gender)
                        .checkResult("Mobile", data.userNumber)
                        .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                        .checkResult("Subjects", data.subject)
                        .checkResult("Hobbies", data.hobby)
                        .checkResult("Picture", "pic.jpg")
                        .checkResult("Address", data.currentAddress)
                        .checkResult("State and City", data.state + " " + data.city)
                        .closeModal();

    }

    @Test
    void fillWithMinimalDataTest(){

        TestData data = new TestData();

        formPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .submitForm()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .closeModal();

    }

    @Test
    void negativeTest(){
        formPage.openPage()
                .submitForm()
                .checkValidation();

    }
}

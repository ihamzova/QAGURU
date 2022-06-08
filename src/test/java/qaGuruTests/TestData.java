package qaGuruTests;

import RandomUtils.RandomUtils;
import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {

    Faker fakerRu = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    String firstName = fakerRu.address().firstName();
    String lastName = fakerRu.name().lastName();
    String email = fakerEn.internet().emailAddress();
    String gender = RandomUtils.getRandomGender();
    String phone = String.valueOf(fakerRu.number().randomNumber(10, true));
    String subject = RandomUtils.getRandomSubject();
    String hobby = RandomUtils.getRandomHobbies();
    String address = fakerRu.address().fullAddress();
    String state = RandomUtils.getRandomState();
    String city = RandomUtils.getRandomCity(state);
    String dayofBirth = RandomUtils.getRandomDate();

}

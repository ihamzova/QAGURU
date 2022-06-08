package RandomUtils;

import com.github.javafaker.Faker;
import io.netty.util.internal.ThreadLocalRandom;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.devtools.v101.media.model.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;


public class RandomUtils {

    private static String emailDomain = "@qa.guru";

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomMessage(int min, int max) {
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(11111111111111111L, 99999999999999999L) + "";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomGender() {
        Random generatorGender = new Random();
        String[] genderArray = {"Male", "Female", "Other"};
        int randomIndexGender = generatorGender.nextInt(genderArray.length);

        return genderArray[randomIndexGender];
    }

    public static String getRandomNumber() {
        Random rnd = new Random();
        return String.format("%d%d%d%03d%04d", rnd.nextInt(8), rnd.nextInt(8), rnd.nextInt(8),
                rnd.nextInt(656), rnd.nextInt(10000));
    }

    public static String getRandomDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        Faker faker = new Faker();
        String randomDateBirthday = sdf.format(faker.date().birthday());


        return randomDateBirthday;
    }

    public static String getRandomSubject() {
        Random generatorSubject = new Random();
        String[] subjectArray = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        int randomIndexSubject = generatorSubject.nextInt(subjectArray.length);

        return subjectArray[randomIndexSubject];
    }

    public static String getRandomHobbies() {
        Random generatorGender = new Random();
        String[] hobbiesArray = {"Sports", "Reading", "Music"};
        int randomIndexHobbies = generatorGender.nextInt(hobbiesArray.length);

        return hobbiesArray[randomIndexHobbies];
    }

    public static String getRandomState() {
        Random generatorState = new Random();
        String[] stateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomIndexState = generatorState.nextInt(stateArray.length);

        return stateArray[randomIndexState];
    }

    public static String getRandomCity(String state) {
        Random generatorState = new Random();
        String resultCity = getRandomState();
        int randomIndexCity;
        if (state == "NCR") {
            String[] cityArrayNCR = {"Delhi", "Gurgaon", "Noida"};
            randomIndexCity = generatorState.nextInt(cityArrayNCR.length);
            return cityArrayNCR[randomIndexCity];
        } else if (state == "Uttar Pradesh") {
            String[] cityArrayUttar = {"Agra", "Lucknow", "Merrut"};
            randomIndexCity = generatorState.nextInt(cityArrayUttar.length);
            return cityArrayUttar[randomIndexCity];
        } else if (state == "Haryana") {
            String[] cityArrayHaryana = {"Karnal", "Panipat"};
            randomIndexCity = generatorState.nextInt(cityArrayHaryana.length);
            return cityArrayHaryana[randomIndexCity];
        } else {
            String[] cityArrayRajasthan = {"Jaipur", "Jaiselmer"};
            randomIndexCity = generatorState.nextInt(cityArrayRajasthan.length);
            return cityArrayRajasthan[randomIndexCity];
        }
    }
}

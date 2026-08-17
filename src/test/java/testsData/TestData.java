package testsData;

import com.github.javafaker.Faker;

public class TestData {

    private final Faker fakerEng = new Faker();

    public String USER_FIRST_NAME = fakerEng.name().name();
    public String USER_LAST_NAME = fakerEng.name().lastName();
    public String FULL_USER_NAME = USER_FIRST_NAME + " " + USER_LAST_NAME;
    public String EMAIL = fakerEng.internet().emailAddress();
    public String PHONE_NUMBER = fakerEng.phoneNumber().subscriberNumber(10);
    public String DAY_OF_BIRTH = String.valueOf(fakerEng.number().numberBetween(1, 28));
    public String MONTH_OF_BIRTH = fakerEng.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public String YEAR_OF_BIRTH = String.valueOf(fakerEng.number().numberBetween(1990, 2000));
    public String GENDER = "Male";
    public String SUBJECTS = fakerEng.options().option(
            "Maths", "Chemistry", "English"
    );
    public String HOBBY = fakerEng.options().option("Sports", "Reading", "Music");
    public String CURRENT_ADDRESS = fakerEng.address().fullAddress();
    public final String USER_STATE = getRandomState();
    public final String USER_CITY = getRandomCity(USER_STATE);


    public String getRandomState() {
        return fakerEng.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> fakerEng.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> fakerEng.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> fakerEng.options().option("Karnal", "Panipat");
            case "Rajasthan" -> fakerEng.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Unknown state: " + state);
        };
    }
    public String FILE_PATH = "Dubai.jpg";


    public String INVALID_PHONE_NUMBER = fakerEng.phoneNumber().subscriberNumber(8);
    public String SECOND_FULL_USER_NAME = fakerEng.name().fullName();
    public String SECOND_EMAIL = fakerEng.internet().emailAddress();
    public String INVALID_SECOND_EMAIL = RandomUtils.getRandomEmailWithoutDomain();
    public String SECOND_CURRENT_ADDRESS = fakerEng.address().fullAddress();

/*
    public static final String USER_FIRST_NAME = "Timur";
    public static final String USER_LAST_NAME = "T";
    public static final String FULL_USER_NAME = USER_FIRST_NAME + " " + USER_LAST_NAME;
    public static final String EMAIL = "avito9196@yandex.ru";
    public static final String PHONE_NUMBER = "9657895436";
    public static final String DAY_OF_BIRTH = "01";
    public static final String MONTH_OF_BIRTH = "November";
    public static final String YEAR_OF_BIRTH = "1994";
    public static final String GENDER = "Male";
    public static final String SUBJECTS = "Computer Science";
    public static final String HOBBY = "Sports";
    public static final String CURRENT_ADDRESS = "1 Kremlevskaya Embankment, Moscow, Russian Federation";
    public static final String USER_STATE = "Rajasthan";
    public static final String USER_CITY = "Jaipur";
    public static final String FILE_PATH = "Dubai.jpg";


    public static final String INVALID_PHONE_NUMBER = "965789543";
    public static final String SECOND_FULL_USER_NAME = "Eva Nikonova";
    public static final String SECOND_EMAIL = "evanikonova@gmail.com";
    public static final String INVALID_SECOND_EMAIL = "evanikonovagmail.com";
    public static final String SECOND_CURRENT_ADDRESS = "2 Palace Square, Saint Petersburg, Russian Federation";
*/
}

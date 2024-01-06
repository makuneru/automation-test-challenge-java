package utils;

import java.util.Random;

public class CommonUtils {

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 15;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 30;

    private static final String[] FIRST_NAMES = {"Oliver", "Charlotte", "William", "Ava", "Jack"};
    private static final String[] LAST_NAMES = {"Smith", "Jones", "Williams", "Brown", "Wilson"};
    private static final String[] STREETS = {"King St", "George St", "Bourke St", "Queen St", "Collins St"};
    private static final String[] CITIES = {"Sydney", "Melbourne", "Brisbane", "Perth", "Adelaide"};
    private static final String[] STATES = {"NSW", "VIC", "QLD", "WA", "SA"};
    private static final String[] ZIP_CODES = {"2000", "3000", "4000", "6000", "5000"};
    private static final String[] AREA_CODES = {"02", "03", "07", "08", "08"};
    private static final String[] SSN_PARTS = {"123", "456", "789"};

    private static final Random random = new Random();

    public String getRandomFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + random.nextInt(1000);
    }

    public String getRandomAddress() {
        return STREETS[random.nextInt(STREETS.length)];
    }
    
    public String getRandomLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    public String getRandomCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }

    public String getRandomState() {
        return STATES[random.nextInt(STATES.length)];
    }

    public String getRandomZipCode() {
        return ZIP_CODES[random.nextInt(ZIP_CODES.length)];
    }

    public String getRandomPhoneNumber() {
        String areaCode = AREA_CODES[random.nextInt(AREA_CODES.length)];
        int randomNumber = 1000000 + random.nextInt(9000000);
        return areaCode + Integer.toString(randomNumber).substring(1);
    }

    public String getRandomSSN() {
        return SSN_PARTS[random.nextInt(SSN_PARTS.length)] + "-"
                + SSN_PARTS[random.nextInt(SSN_PARTS.length)] + "-"
                + SSN_PARTS[random.nextInt(SSN_PARTS.length)];
    }
}

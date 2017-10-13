package com.usmanhussain.paprika.utils.common;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public RandomGenerator() {
    }

    /**
     * This will return a random Integer. The length is specified when the
     * method is called.
     */
    public static String randomInteger(Integer numberAmount) {
        return RandomStringUtils.randomNumeric(numberAmount);
    }

    /**
     * This will return a random String. The length is specified when the
     * method is called.
     */
    public String randomString(Integer characterAmount) {
        return RandomStringUtils.random(characterAmount, true, false);
    }

    /**
     * This will return random Alphanumeric characters. The length is
     * specified when the method is called.
     */
    public static String randomAlphanumeric(Integer alphaNumericAmount) {
        return RandomStringUtils.randomAlphanumeric(alphaNumericAmount);
    }

    /**
     * This will return random Alphanumeric characters. The length is
     * specified when the method is called.
     */
    public static String randomAlphabetic(Integer charactersCount) {
        return RandomStringUtils.randomAlphabetic(charactersCount);
    }

    /**
     * This will return random Email Address to '@example.com'. The length is
     * specified when the method is called.
     */
    public static String randomEmailAddress(Integer emailAddress) {
        String email = randomAlphanumeric(emailAddress) + "@example.com";
        return email.toLowerCase();
    }

    /**
     * This will return a random Gender from the selected list.
     */
    public static String randomGender() {
        List<String> gender = new LinkedList<String>();
        gender.add("M");
        gender.add("F");
        gender.add("U");

        Random rand = new Random();
        int choice = rand.nextInt(gender.size());
        String randomGenderString = gender.get(choice);

        return randomGenderString;
    }

    public static String randomGenderFullText() {
        List<String> gender = new LinkedList<String>();
        gender.add("Male");
        gender.add("Female");
        Random rand = new Random();
        int choice = rand.nextInt(gender.size());
        return gender.get(choice);
    }

    public static String randomPlusOrMinus() {
        List<String> item = new LinkedList<String>();
        item.add("-");
        item.add("+");

        Random rand = new Random();
        int choice = rand.nextInt(item.size());
        String randomPlusOrMinusString = item.get(choice);

        return randomPlusOrMinusString;
    }

    public static String internationalisationRandomGen(Integer wordLength) {
        List<String> e = new LinkedList<String>();
        e.add("\u0621");
        e.add("\u0622");
        e.add("\u0623");
        e.add("\u0624");
        e.add("\u0625");
        e.add("\u0626");
        e.add("\u0627");
        e.add("\u0628");
        e.add("\u0629");
        e.add("\u062A");
        e.add("\u062B");
        e.add("\u062C");
        e.add("\u062D");
        e.add("\u062E");
        e.add("\u062F");
        e.add("\u0630");
        e.add("\u0631");
        e.add("\u0632");
        e.add("\u0633");
        e.add("\u0634");
        e.add("\u0635");
        e.add("\u0636");
        e.add("\u0637");
        e.add("\u0638");
        e.add("\u0639");
        e.add("\u063A");

        Integer count = 1;
        StringBuilder word = new StringBuilder();
        while (count < wordLength) {
            Random rand1 = new Random();
            int choice1 = rand1.nextInt(e.size());
            String newChar = e.get(choice1);
            word.append(newChar);
            count++;
        }
        return word.toString();
    }

    private static final long ONE_YEAR_AS_MILLISECONDS = 365L * 24L * 60L * 60L * 1000L;
    private static final long TWENTY_FIVE_YEARS_AS_MILLISECONDS = 25 * ONE_YEAR_AS_MILLISECONDS;
    private static final long FIFTY_YEARS_AS_MILLISECONDS = 50 * ONE_YEAR_AS_MILLISECONDS;

    public static String randomDOB(String dateFormat) {
        long someTimeBetween25And50YearsInMilliSeconds = TWENTY_FIVE_YEARS_AS_MILLISECONDS
                + (long) (Math.random() * ((FIFTY_YEARS_AS_MILLISECONDS - TWENTY_FIVE_YEARS_AS_MILLISECONDS) + 1));

        Date d = new Date(System.currentTimeMillis() - someTimeBetween25And50YearsInMilliSeconds);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(d);
    }

    public static String stringPlusCurrentDate(String prefix) {
        Date d = new Date(System.currentTimeMillis());
        return prefix + " " + d.toString();
    }

}
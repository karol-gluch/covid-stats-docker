package pl.karolgluch.covid_stats.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

    public static String getDateWithPattern(LocalDateTime date) {
        String dateFormat = "";
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        if(day < 10 && month > 9) {
            dateFormat = "MM/d/yy";
        }
        if(day > 9 && month > 9) {
            dateFormat = "MM/dd/yy";
        }
        if(day > 9 && month < 10) {
            dateFormat = "M/dd/yy";
        }
        if(day < 10 && month < 10) {
            dateFormat = "M/d/yy";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return date.format(formatter);
    }

    public static String getTodayDate() {
        LocalDateTime dateToday = LocalDateTime.now().minusDays(1);
        return DateHelper.getDateWithPattern(dateToday);
    }

    public static String getYesterdayDate() {
        LocalDateTime dateYesterday = LocalDateTime.now().minusDays(2);
        return DateHelper.getDateWithPattern(dateYesterday);
    }

    public static String getDateToResult() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return LocalDateTime.now().minusDays(1).format(dateTimeFormatter);
    }
}

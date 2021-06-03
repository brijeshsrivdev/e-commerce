package com.ecommerce.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The type Date converter util.
 */
public class DateConverterUtil {
    /**
     * Epoch to local date time local date time.
     *
     * @param localDateTimeinputDate the local date timeinput date
     * @return the local date time
     */
    public static LocalDateTime epochToLocalDateTime(String localDateTimeinputDate){
        Instant instant = Instant.ofEpochMilli(new Long(localDateTimeinputDate));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedIST = localDateTime.atZone(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedUTC = zonedIST.withZoneSameInstant(ZoneId.of("UTC"));
        return zonedUTC.toLocalDateTime();

    }

    /**
     * String to local date time convert local date time.
     *
     * @param localDateTimeinputDate the local date timeinput date
     * @return the local date time
     */
    public static LocalDateTime stringToLocalDateTimeConvert(String localDateTimeinputDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeinputDate, formatter);
        ZonedDateTime zonedIST = localDateTime.atZone(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedUTC = zonedIST.withZoneSameInstant(ZoneId.of("UTC"));
        return zonedUTC.toLocalDateTime();

    }

    /**
     * To local date time convert local date time.
     *
     * @param inputDate the input date
     * @return the local date time
     */
    public static LocalDateTime toLocalDateTimeConvert(Date inputDate){
        ZonedDateTime  zonedIST= inputDate.toInstant().atZone(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedUTC = zonedIST.withZoneSameInstant(ZoneId.of("UTC"));

        LocalDateTime localDateTime = zonedUTC.toLocalDateTime();
        return localDateTime;
    }

    /**
     * To local date time convert local date time.
     *
     * @param inputDate the input date
     * @return the local date time
     */
    public static LocalDateTime toLocalDateTimeConvert(LocalDateTime inputDate){
        ZonedDateTime zonedIST = inputDate.atZone(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedUTC = zonedIST.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime localDateTime = zonedUTC.toLocalDateTime();
        return localDateTime;
    }


}

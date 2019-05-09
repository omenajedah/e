package com.ekakartika.eka.datawargart04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static Date parceDate(String src, String pattern) throws ParseException {
        SimpleDateFormat SDF = new SimpleDateFormat(pattern, Locale.getDefault());
        return SDF.parse(src);

    }

    public static String formatDate(Date src, String pattern) {
        SimpleDateFormat SDF = new SimpleDateFormat(pattern, Locale.getDefault());
        return SDF.format(src);
    }
}

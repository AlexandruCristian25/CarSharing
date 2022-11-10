package com.example.carsharing.database;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DateConverter {

        private static final String FORMAT_DATE = "dd/MM/yyyy";
        private static final SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE, Locale.US);

        @TypeConverter
        public static Date fromString(String value) {
            try {
                return formatter.parse(value);
            } catch (ParseException e) {
                return null;
            }
        }

        @TypeConverter
        public static String fromDate(Date value) {
            if (value == null) {
                return null;
            }
            return formatter.format(value);
        }
    }

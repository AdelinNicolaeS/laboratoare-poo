package main;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";
    public static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    public static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);
    public static int getClientId(){
        return 42;
    }
}

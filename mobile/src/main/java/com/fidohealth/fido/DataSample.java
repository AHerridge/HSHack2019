package com.fidohealth.fido;

public class DataSample {
    public final double ambient_volume, ambient_temp, ambient_humd, activity_level, heart_rate, user_mood;

    public DataSample(double ambient_volume, double ambient_temp, double ambient_humd, double activity_level, double heart_rate, double user_mood) {
        this.ambient_volume = ambient_volume;
        this.ambient_temp = ambient_temp;
        this.ambient_humd = ambient_humd;
        this.activity_level = activity_level;
        this.heart_rate = heart_rate;
        this.user_mood = user_mood;
    }

    public double[] asArray() {
        return new double[]{ambient_volume, ambient_temp, ambient_humd, activity_level, heart_rate, 1};
    }

    public double getUserMood() {
        return user_mood;
    }
}

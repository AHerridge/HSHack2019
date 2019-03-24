package com.fidohealth.fido;

import java.util.ArrayList;

public class User {
    public final String name;
    public final String email;
    public final String passwordHash;
    public final String condition;
    public final ArrayList<DataSample> data;
    public final MultipleLinearRegression linearRegression;

    public User(String name, String email, String passwordHash, String condition) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.condition = condition;
        this.data = new ArrayList<>();

        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));
        data.add(new DataSample(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random()*2-1));

        this.linearRegression = new MultipleLinearRegression(getX(), getY());
    }

    public int getEmotion(double volume, double temp, double humidity, double activity, double heartRate) {
        double predicted_mood = linearRegression.beta(0) * volume + linearRegression.beta(1) * temp +
                linearRegression.beta(2) * humidity + linearRegression.beta(3) * activity +
                linearRegression.beta(4) * heartRate;

        if (predicted_mood > 0.5)
            return R.drawable.veryhappy;
        else if (predicted_mood > 0)
            return R.drawable.happy;
        else if (predicted_mood > -0.5)
            return R.drawable.neutral;
        else
            return R.drawable.sad;
    }

    private double[][] getX() {
        double[][] array = new double[data.size()][6];
        for (int i = 0; i < data.size(); i++)
            array[i] = data.get(i).asArray();

        return array;
    }

    private double[] getY() {
        double[] array = new double[data.size()];
        for (int i = 0; i < data.size(); i++)
            array[i] = data.get(i).getUserMood();

        return array;
    }
}

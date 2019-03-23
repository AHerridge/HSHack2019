package com.fidohealth.fido;
import org.apache.commons.math3.stat.inference.TTest;
public class TwoSampleTTest extends TTest{
    double [][] odd, normal;
    public boolean test(double[][] odd, double [][] normal, double alpha) {
        double oddMean = 0;
        double oddVar = 0;
        double normalMean = 0;
        double normalVar = 0;
        for (int i = 0; i < odd.length; i++) {
            double tempMean = 0;
            double tempVar = 0;
            for (int j = 0; j < odd[i].length; j++) {
                tempMean += odd[i][j];
            }
            tempMean /= odd[i].length;
            oddMean += tempMean;
            for (int j = 0; j < odd[i].length; j++) {
                tempVar += (odd[i][j] - tempMean) * (odd[i][j] - tempMean) / (odd[i].length - 1);
            }
            oddVar += tempVar;
        }
        oddMean /= odd.length;
        for (int i = 0; i < normal.length; i++) {
            double tempMean = 0;
            double tempVar = 0;
            for (int j = 0; j < normal[i].length; j++) {
                tempMean += normal[i][j];
            }
            tempMean /= normal[i].length;
            normalMean += tempMean;
            for (int j = 0; j < normal[i].length; j++) {
                tempVar += (normal[i][j] - tempMean) * (normal[i][j] - tempMean) / (normal[i].length - 1);
            }
            normalVar += tempVar;
        }
        normalMean /= normal.length;

        return (alpha >= tTest(oddMean, normalMean, oddVar, normalVar, (double)odd.length, (double)normal.length));
    }
}

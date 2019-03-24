package com.fidohealth.fido;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Weather extends AsyncTask<String, String, String> {

    protected String doInBackground(String... params) {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            double lat = 40.126071;
            double lon = -83.13917;
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=6714b8e795151884a1c3abd399fb8400");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //txtJson.setText(result);
    }

    public static double[] weather(String json) throws Exception
    {
        double[] arr = null;
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject main = obj.getJSONObject("main");
            JSONObject wind = obj.getJSONObject("wind");
            JSONObject clouds = obj.getJSONObject("clouds");
            arr = new double[]{main.getDouble("temp"),
                    main.getDouble("pressure"),
                    main.getDouble("humidity"),
                    wind.getDouble("speed"),
                    wind.getDouble("deg"),
                    clouds.getDouble("all")};
        }
        catch (JSONException e)
        {

        }
        return arr;
    }
}
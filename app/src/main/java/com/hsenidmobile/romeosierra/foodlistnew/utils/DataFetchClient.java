package com.hsenidmobile.romeosierra.foodlistnew.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.hsenidmobile.romeosierra.foodlistnew.model.Food;


/**
 * Created by kanchana on 4/28/17.
 */

public class DataFetchClient {
    private URL url;
    private HttpURLConnection con;
    private Gson gson;

    public Object fetchData(String url) {
        Food food = null;
        try{
            this.url = new URL(url);
            gson = new Gson();
            this.con = (HttpURLConnection) this.url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            BufferedReader buf = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
            food = gson.fromJson(buf, Food.class);
        }
        catch (IOException e){
            Log.e("ERROR", e.getMessage());
            return "Error! " + e.getMessage();
        }
        catch (Exception e){
            Log.e("ERROR", e.getMessage());
            return "Error! " + e.getMessage();
        }
        return food;
    }
}

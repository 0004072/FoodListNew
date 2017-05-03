package com.hsenidmobile.romeosierra.foodlistnew;

import com.google.gson.Gson;
import com.hsenidmobile.romeosierra.foodlistnew.model.*;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private URL url;
    private HttpURLConnection con;
    private Gson gson;
    private BufferedReader buf;
    @Before
    public void init(){
        gson = new Gson();
        try {
            this.url = new URL("http://demo7836701.mockable.io/food/popular");
            this.con = (HttpURLConnection)url.openConnection();
            this.con.setRequestMethod("GET");
            con.connect();
            buf = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFetchData() throws Exception {
        Food food = gson.fromJson(buf, Food.class);
        System.out.println(food.toString());
    }
}
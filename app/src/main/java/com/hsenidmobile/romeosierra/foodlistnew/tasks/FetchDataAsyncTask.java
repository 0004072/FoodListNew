package com.hsenidmobile.romeosierra.foodlistnew.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.foodlistnew.FoodListAdapter;
import com.hsenidmobile.romeosierra.foodlistnew.model.Food;
import com.hsenidmobile.romeosierra.foodlistnew.model.FoodItem;
import com.hsenidmobile.romeosierra.foodlistnew.utils.DataFetchClient;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kanchana on 5/2/17.
 */

public class FetchDataAsyncTask extends AsyncTask<Object, Object, ArrayList<FoodItem>> {
    private ProgressDialog progressDialog;
    private Context context;
    private ListView listView;

    public FetchDataAsyncTask(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected ArrayList<FoodItem> doInBackground(Object ... params) {
        ArrayList<FoodItem> response = new ArrayList<>();
        DataFetchClient req = new DataFetchClient();
        Object obj = req.fetchData("http://demo7836701.mockable.io/food/popular");
        if(obj instanceof Food) {
            Food food = (Food)obj;
            response = food.getFood();
        }
        return response;
    }

    @Override
    protected void onPreExecute(){
        progressDialog = ProgressDialog.show(context, "Wait!", "Data fetching in progress...");
    }

    @Override
    protected void onPostExecute(ArrayList<FoodItem> result){
        String message = "Failed to fetch data. Unknown Error!";
        if(result.size() > 0)
            message = String.format(Locale.US, "Successfully fetched %d items!", result.size());
        progressDialog.dismiss();
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();

        FoodListAdapter fla = new FoodListAdapter(context, result);
        listView.setAdapter(fla);
    }
}
package com.hsenidmobile.romeosierra.foodlistnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.hsenidmobile.romeosierra.foodlistnew.tasks.FetchDataAsyncTask;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchDataAsyncTask afd = new FetchDataAsyncTask(MainActivity.this, (ListView)findViewById(R.id.foodList));
        afd.execute();

        /*foodListView = (ListView)findViewById(R.id.simpleListView);
        try {
            ArrayList<FoodItem> food = new ArrayList<>();
            food.add(new FoodItem("Pizza 3", "$2.5","Best food in the city", "https://cdn.pixabay.com/photo/2015/04/08/13/14/food-712667_960_720.jpg"));
            food.add(new FoodItem("Pizza 4", "$2.5", "Best food in the city", "https://cdn.pixabay.com/photo/2017/02/27/02/59/italy-2102016_960_720.jpg"));
            *//*food = new Food(new FoodItem[]{
                    new FoodItem("Pizza 3", "$2.5","Best food in the city", "https://cdn.pixabay.com/photo/2015/04/08/13/14/food-712667_960_720.jpg"),
                    new FoodItem("Pizza 4", "$2.5", "Best food in the city", "https://cdn.pixabay.com/photo/2017/02/27/02/59/italy-2102016_960_720.jpg")
            });*//*
            FoodListAdapter myAdapter=new FoodListAdapter(this, R.layout.list_view_item, food);
            //AnimalListAdapter myAdapter = new AnimalListAdapter(this, R.layout.list_view_item, animalList);
            foodListView.setAdapter(myAdapter);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }*/
    }
}

package net.hovait.barared.controllers;

import android.app.Activity;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.TextView;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.kevinsawicki.http.HttpRequest.HttpRequestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import net.hovait.barared.models.Product;
import net.hovait.barared.models.ProductList;
import net.hovait.barared.printtest02.MainActivity;
import net.hovait.barared.printtest02.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hovait4 on 11/11/2015.
 */
public class RestClient extends AsyncTask<String, Long, String> {

    public static final String TAG = "hovait.debug";

    protected String doInBackground(String... urls) {
        try {
            return HttpRequest.get(urls[0]).accept("application/json").body();
        } catch (HttpRequestException exception) {
            return null;
        }
    }

    protected void onPostExecute(String response) {
        /*Log.i(TAG, response);
        TextView mainText = (TextView) MainActivity.mainActivity.findViewById(R.id.mainText);
        //mainText.setText(prettyfyJSON(response));
        mainText.setText(response);*/
        ProductList products = getProducts(response);
        TextView mainText = (TextView) MainActivity.mainActivity.findViewById(R.id.mainText);

        if (!products.getProducts().isEmpty()) {
            mainText.setText(products.getProducts().get(0).getProdSKU());
        }
    }

    private String prettyfyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        return gson.toJson(element);
    }

    private ProductList getProducts(String json) {
        Gson gson = new Gson();

        return gson.fromJson(json, ProductList.class);
    }
}

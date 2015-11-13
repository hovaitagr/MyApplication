package net.hovait.barared.printtest02;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.hovait.barared.controllers.RestClient;
//import com.starmicronics.stario.*;

public class MainActivity extends AppCompatActivity {

    private TextView mainText;
    public static Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;

        mainText = (TextView) findViewById(R.id.mainText);
        mainText.setText("Loading REST...");

        String url = "http://192.168.55.200:8181/api/products";
        new RestClient().execute(url);
    }

}
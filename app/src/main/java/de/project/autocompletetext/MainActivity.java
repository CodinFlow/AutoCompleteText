package de.project.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<CountryItem> countryList;
    RequestQueue mRequestQueue;
    JsonObjectRequest request;
    AutoCompleteTextView editText;
    String Json_URL = "https://drive.google.com/uc?export=download&id=1VPuA4NzOsiasOQnhtbh9mz9b5a5xUbmD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryList = new ArrayList<>();
        editText = findViewById(R.id.actv);
        fillCountryList();


    }

    public void fillCountryList() {
        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        request = new JsonObjectRequest(Request.Method.GET, Json_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: successfully");
                try {
                    JSONArray autoCompleteArray = response.getJSONArray("auto_complete");
                    for (int i = 0; i < autoCompleteArray.length(); i++) {
                        JSONObject info = autoCompleteArray.getJSONObject(i);
                        String countryName = info.getString("country_name");
                        String flagUrl = info.getString("flag_url");

                        countryList.add(new CountryItem(countryName, flagUrl));
                        Log.d(TAG, "Json Data: " + countryName);

                        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(MainActivity.this, countryList);
                        editText.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: Error!!!");
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
}
package de.project.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);
    }

    private void fillCountryList() {
        countryList = new ArrayList<>();

        // TODO: 10/03/2022 URL FROM JSON
      /*  for (int i = 0; i < jsonArray2.length(); i++) {
            JSONObject chart = jsonArray2.getJSONObject(i);

            String coverUrl2 = chart.getString("album_cover_url");
            String artistName2 = chart.getString("artist_name");

            mList2.add(new Item(coverUrl2, artistName2));
        }*/
        countryList.add(new CountryItem("Afghanistan", "https://cdn.webshopapp.com/shops/94414/files/52406302/flag-of-morocco.jpg"));
        countryList.add(new CountryItem("Albania", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Flag_of_Albania.svg/1200px-Flag_of_Albania.svg.png"));
        countryList.add(new CountryItem("Algeria","https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/1200px-Flag_of_Algeria.svg.png"));
        countryList.add(new CountryItem("Andorra", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Flag_of_Andorra.svg/1280px-Flag_of_Andorra.svg.png"));
    }
}
package com.stickyheaderlistview.maroof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Maroof Ahmed Siddique on 1/23/2017.
 */

public class MainActivity extends AppCompatActivity {

    private StickyListHeadersListView mStickyListHeadersListView;
    private CountryAdapter adapter;
    List<Country> countries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStickyListHeadersListView = (StickyListHeadersListView) findViewById(R.id.header_listview);

        String[] isoCountries = Locale.getISOCountries();
        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            String name = locale.getDisplayCountry();
            String code = locale.getCountry();
            String language = locale.getDisplayLanguage();

            Country bean = new Country();
            bean.setCountryName(name);
            bean.setCountrycode(code);
            bean.setCountryLanguage(language);
            countries.add(bean);
        }

        if (countries != null && countries.size() > 0) {
            adapter = new CountryAdapter(this, countries);
            mStickyListHeadersListView.setAdapter(adapter);
        }
    }
}

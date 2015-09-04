package com.example.e.projeto;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();

        final ListView listview = (ListView) findViewById(R.id.listView);

        String x = "" + intent.getStringExtra(Activ.EXTRA_MESSAGE);

        if (x.equals("Aluno de SI")) {

            String lista[] = {"Sao Paulo", "Rio de Janeiro"};
            final ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < lista.length; i++) {
                list.add(lista[i]);
            }


            final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
            listview.setAdapter(adapter);
            listview.deferNotifyDataSetChanged();



        }
        else {

            String lista[] = {"Fiat Uno", "Nissan Silvia"};
            final ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < lista.length; i++) {
                list.add(lista[i]);
            }

            final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
            listview.setAdapter(adapter);
            listview.deferNotifyDataSetChanged();



        }
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }


        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

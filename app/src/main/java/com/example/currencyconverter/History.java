package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        TextView textView = findViewById(R.id.tv_history);
        Toolbar toolbar = findViewById(R.id.sub_toolbar);
        setSupportActionBar(toolbar);
        ArrayList<String> histories = (ArrayList<String>) getIntent().getSerializableExtra("key");
        textView.setText("");
        if (!histories.isEmpty())
        {
            for (int i = histories.size()-1; i>=0; i--)
            {
                textView.append(histories.get(i)+"\n");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.it_close:
            {
                finish();
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

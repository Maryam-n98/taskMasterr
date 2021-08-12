package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.allMenu) {
            Intent allint = new Intent(this, AllTasks.class);
            startActivity(allint);
            return true;
        }

        if (id == R.id.addMenu) {
            Intent add1Intent = new Intent(this, AddTask.class);
            startActivity(add1Intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        Intent addIntent = new Intent(this, AddTask.class);
        startActivity(addIntent);
    }

    public void all(View view) {
        Intent allIntent = new Intent(this, AllTasks.class);
        startActivity(allIntent);
    }

    public void firstButton(View view) {
        Intent tasks = new Intent(this,TasksDetailActivity.class);
        tasks.putExtra("title", "Task1");
        startActivity(tasks);

    }

    public void secButt(View view) {
        Intent tasks = new Intent(this,TasksDetailActivity.class);
        tasks.putExtra("title", "Task2");
        startActivity(tasks);
    }

    public void therButt(View view) {
        Intent tasks = new Intent(this,TasksDetailActivity.class);
        tasks.putExtra("title", "Task3");
        startActivity(tasks);
    }

    public void settingsButton(View view) {
        Intent setting = new Intent(MainActivity.this, Settings.class);
        MainActivity.this.startActivity(setting);
    }
    @Override
    public void onResume() {

        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView address = findViewById(R.id.textView);
        address.setText(preferences.getString("userName", "User") + "'s Task");
    }
}
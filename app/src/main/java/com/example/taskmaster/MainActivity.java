package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
}
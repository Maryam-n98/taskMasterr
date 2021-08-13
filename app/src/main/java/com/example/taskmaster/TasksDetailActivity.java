package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TasksDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_detail);
        Intent intent = getIntent();
        ((TextView) findViewById(R.id.textViewTitle)).setText(intent.getExtras().getString("title"));

        String title = intent.getExtras().getString(ListTask.TASK_TITLE);
        TextView titleTextView = findViewById(R.id.textViewTitle);
        titleTextView.setText(title);
        String body = intent.getExtras().getString(ListTask.TASK_BODY);
        TextView bodyTextView = findViewById(R.id.textViewBody);
        bodyTextView.setText(body);
        String state = intent.getExtras().getString(ListTask.TASK_STATE);
        TextView nameTextView = findViewById(R.id.textViewState);
        nameTextView.setText(state);
    }
}
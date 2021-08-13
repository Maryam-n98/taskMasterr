package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListTask extends AppCompatActivity {
    public static final String TASK_TITLE = "task_title";
    public static final String TASK_BODY = "task_body";
    public static final String TASK_STATE = "task_state";
    private List<Tasks> tasksList;
    private TaskAdapter adapter;

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);
        RecyclerView TaskRecyclerView = findViewById(R.id.list2);


        Tasks task1 = new Tasks("Task 1", "try to complete it", "in progress");
        Tasks task2 = new Tasks("Task 2", "Do it", "assigned");
        Tasks task3 = new Tasks("Task 3", "Done !", "completed");
        Tasks task4 = new Tasks("Task 4", "You should start it", "new");
        Tasks task5 = new Tasks("Task 5", "Try to complete it", "in progress");


        tasksList = new ArrayList<>();
        tasksList.add(task1);
        tasksList.add(task2);
        tasksList.add(task3);
        tasksList.add(task4);
        tasksList.add(task5);

        adapter = new TaskAdapter(tasksList, new TaskAdapter.OnTaskItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Intent goToDetailsIntent = new Intent(getApplicationContext(), TasksDetailActivity.class);
                goToDetailsIntent.putExtra(TASK_TITLE, tasksList.get(position).getTitle());
                goToDetailsIntent.putExtra(TASK_BODY, tasksList.get(position).getBody());
                goToDetailsIntent.putExtra(TASK_STATE, tasksList.get(position).getState());
                startActivity(goToDetailsIntent);

            }


        });
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        TaskRecyclerView.setLayoutManager(linearLayoutManager);
        TaskRecyclerView.setAdapter(adapter);
    }

}
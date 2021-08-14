package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TASK_TITLE = "task_title";
    public static final String TASK_BODY = "task_body";
    public static final String TASK_STATE = "task_state";
    private List<Tasks> tasksList;
    private TaskAdapter adapter;
    private TaskDao taskDao;
    private TaskDatabase db;
    public List<Tasks> getTasksList() {
        return tasksList;
    }



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
            Intent allint = new Intent(this, ListTask.class);
            startActivity(allint);
            return true;
        }

        if (id == R.id.addMenu) {
            Intent add1Intent = new Intent(this, AddTask.class);
            startActivity(add1Intent);
            return true;
        }  if (id == R.id.setting) {
            Intent settingIntent = new Intent(this, Settings.class);
            startActivity(settingIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class, AddTask.TASK_ITEM).allowMainThreadQueries().build();
        taskDao = db.taskDao();
        tasksList = taskDao.findAll();

        RecyclerView TaskRecyclerView = findViewById(R.id.list3);
//
//        Tasks task1 = new Tasks("Task 1", "try to complete it", "in progress");
//        Tasks task2 = new Tasks("Task 2", "Do it", "assigned");
//        Tasks task3 = new Tasks("Task 3", "Done !", "completed");
//        Tasks task4 = new Tasks("Task 4", "You should start it", "new");
//        Tasks task5 = new Tasks("Task 5", "Try to complete it", "in progress");
//
//
//        tasksList = new ArrayList<>();
//        tasksList.add(task1);
//        tasksList.add(task2);
//        tasksList.add(task3);
//        tasksList.add(task4);
//        tasksList.add(task5);


        adapter = new TaskAdapter(tasksList, new TaskAdapter.OnTaskItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Intent goToDetailsIntent = new Intent(getApplicationContext(), TasksDetailActivity.class);
                goToDetailsIntent.putExtra(TASK_TITLE, tasksList.get(position).getTitle());
                goToDetailsIntent.putExtra(TASK_BODY, tasksList.get(position).getBody());
                goToDetailsIntent.putExtra(TASK_STATE, tasksList.get(position).getState());
                startActivity(goToDetailsIntent);

            }

            @Override
            public void onDeleteItem(int position) {
                taskDao.delete(tasksList.get(position));
                tasksList.remove(position);
                notifyDatasetChanged();
                Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
            }


        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        TaskRecyclerView.setLayoutManager(linearLayoutManager);
        TaskRecyclerView.setAdapter(adapter);


    }
    private void notifyDatasetChanged() {
        adapter.notifyDataSetChanged();
    }
    public void add(View view) {
        Intent addIntent = new Intent(this, AddTask.class);
        startActivity(addIntent);
    }

    public void all(View view) {
        Intent allIntent = new Intent(this, ListTask.class);
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
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adapter.ToDoAdapter;
import com.example.myapplication.Utils.DatabaseHandler;
import com.example.myapplication.doit.AddNewTask;
import com.example.myapplication.doit.DialogCloseListene;
import com.example.myapplication.doit.RecyclerltemTouchHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 public class MainActivity extends AppCompatActivity implements DialogCloseListene {
     private RecyclerView tasksRecyclerView;
     private ToDoAdapter taskAdapter;
     private List<ToDoMoudel> taskList = new ArrayList<>();
     private DatabaseHandler db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        db = new DatabaseHandler(this);
        db.openDatabase();
        taskList = new ArrayList<>();
        taskList = db.getAllTasks();
        Button fab = findViewById(R.id.fab1);
        Button fab1 = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this,intent.class);
                startActivity(i1);
            }
        });

        tasksRecyclerView = findViewById(R.id.recview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(db, this );
        tasksRecyclerView.setAdapter(taskAdapter);

        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerltemTouchHelper(taskAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }

        });

    }


     @Override
    public void handleDialogClose(DialogInterface dialog) {
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);
        taskAdapter.notifyDataSetChanged();
    }



 }









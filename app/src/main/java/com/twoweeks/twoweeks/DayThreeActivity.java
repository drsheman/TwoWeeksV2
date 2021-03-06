package com.twoweeks.twoweeks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.twoweeks.twoweeks.MainActivity.addCompletedTask;
import static com.twoweeks.twoweeks.MainActivity.getCompletedTasks;
import static com.twoweeks.twoweeks.MainActivity.setTierLevel;

public class DayThreeActivity extends AppCompatActivity {

    TextView mWelcomeText;
    Button mCompleteTask;
    ArrayList<Integer> mCompletedTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_three);

        mCompleteTask = (Button) findViewById(R.id.day_three_button_complete);
        mCompleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCompletedTask(R.id.task_three);
                Log.i("test", "CompletedTasks: " + getCompletedTasks().toString());
                mCompletedTasks = getCompletedTasks();
                if (mCompletedTasks.contains(R.id.task_two) && mCompletedTasks.contains(R.id.task_three)) {
                    setTierLevel(3);
                }
                Intent completeTask = new Intent(DayThreeActivity.this, MainActivity.class);
                startActivity(completeTask);
            }
        });
    }
}

package com.example.falcons.scarfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    /**
     * Buttons for each function on the home screen
     */
    Button create, view, compare, modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Link buttons b/t code and xml
        create = (Button) findViewById(R.id.create_schedule);
        view = (Button) findViewById(R.id.view_schedule);
        compare = (Button) findViewById(R.id.compare_schedule);
        modify = (Button) findViewById(R.id.modify_schedule);

        //When the "Create Schedule" Button is pressed, change to the create
        //schedule screen
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createSchedule = new Intent(home.this, create_schedule.class);
                home.this.startActivity(createSchedule);
            }
        });

        //When the "Modify Button" is pressed, change to the modify
        //schedule screen
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modifySchedule = new Intent(home.this, modify_schedule.class);
                home.this.startActivity(modifySchedule);
            }
        });

        /*
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createSched = new Intent(home.this, create_schedule.class);
                home.this.startActivity(createSched);
            }
        });
        */
    }
}


package com.example.falcons.scarfs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;


/**
 * @author: Nick Forleo
 * Handles the GUI for "Create Schedule"
 * 4/27/2017 CSC305
 */
public class create_schedule extends AppCompatActivity{
    /**
     * Table Layout to be used to add views programmatically
     */
    private TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);

        //Find current layout so that Objects can be added to it later
        tl = (TableLayout) findViewById(R.id.table_layout);

        //Button Manager for adding a class
        Button add_a_class;
        add_a_class = (Button) findViewById(R.id.bn_addClass);
        add_a_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewClass();
            }
        });

        //Button Manager for Saving schedule
        Button save_schedule = (Button) findViewById(R.id.bn_Save);
        save_schedule.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void  onClick(View v) {

            }
        });
    }

    /**
     * Helper function to find layout
     * @return tl (TableLayout)
     */
    private TableLayout getLayout() {
        return tl;
    }

    /**
     * Creates all the fields for AClass
     */
    private void addNewClass() {
        newClassName();
        newClassTime();
        addDOTW();
    }

    /**
     * Creates new EditText for AClass info
     */
    private void newClassName() {
        EditText et = new EditText(this);
        TableRow tr = new TableRow(this);
        et.setMinLines(1);
        et.setMaxLines(1);
        et.setHint("Class Name");
        tr.addView(et);
        getLayout().addView(tr);
    }

    /**
     * Creates Time Fields for AClass info
     */
    private void newClassTime() {
        TableRow tr = new TableRow(this);
        for (int i = 0; i < 2; i++) {
            EditText et = new EditText(this);
            if (i == 0) {
                et.setHint("Start Time");
            } else {
                et.setHint("End Time");
            }
            tr.addView(et);
        }
        getLayout().addView(tr);
    }

    /**
     * Creates CheckBoxes for each day of the week for AClass
     */
    //Days of the Week
    private void addDOTW(){
        TableRow tr = new TableRow(this);
        for (int i = 0; i < 5; i++) {
            CheckBox cb = new CheckBox(this);
            if (i == 0) {
                cb.setText("Mon");
            } else  if (i == 1) {
                cb.setText("Tue");
            } else if (i == 2) {
                cb.setText("Wed");
            } else if (i == 3) {
                cb.setText("Thu");
            } else {
                cb.setText("Fri");
            }
            tr.addView(cb);
        }
        getLayout().addView(tr);
    }
}

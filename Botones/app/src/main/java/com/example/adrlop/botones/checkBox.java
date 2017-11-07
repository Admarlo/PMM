package com.example.adrlop.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class checkBox extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        initialUISetup();
    }


    public void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);



        txtHobby = (TextView) findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());

        btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });
    }

    class MyCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            if(isChecked)
            {
                if(buttonView==chkBoxCycling)
                {
                    showTextNotification("Cycling");
                }
                if(buttonView==chkBoxTeaching)
                {
                    showTextNotification("Teaching");
                }
                if(buttonView==chkBoxBlogging)
                {
                    showTextNotification("BlackBlogging");
                }
            }
        }
    }// clase interna

    public void getHobbyClick(View v) {
        String strMessage = "";
        if (chkBoxCycling.isChecked()) {
            strMessage += "Cycling ";
        }
        if (chkBoxTeaching.isChecked()) {
            strMessage += "Teaching ";
        }
        if (chkBoxBlogging.isChecked()) {
            strMessage += "Blogging ";
        }
        showTextNotification(strMessage);
    }

    public void showTextNotification(String msgToDisplay) {
        txtHobby.setText(msgToDisplay);
//Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }

}

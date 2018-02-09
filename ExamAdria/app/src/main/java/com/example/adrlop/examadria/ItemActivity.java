package com.example.adrlop.examadria;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity {

    TextView mItem = null;
    TextView mPlace = null;
    TextView mDescription = null;
    TextView mImportance = null;
    Integer mRowId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        mRowId = (savedInstanceState == null) ? null :(Integer) savedInstanceState.getSerializable(DataBaseHelper.SL_ID);
        if (mRowId == null) {

            mRowId = extras != null ? extras.getInt(DataBaseHelper.SL_ID): null;
        }
        if (extras != null && extras.getInt("action")== MainActivity.SHOW_ITEM) {

            setContentView(R.layout.frame_registro);
        }

        else{
            setContentView(R.layout.activity_item);
            Button saveBtn = (Button) findViewById(R.id.add);
            saveBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    setResult(RESULT_OK);
                    saveData();
                    finish();
                }
            });
        }

        mItem = (TextView) findViewById(R.id.item);
        mPlace = (TextView) findViewById(R.id.place);
        mDescription  = (TextView) findViewById(R.id.description);
        mImportance  = (TextView) findViewById(R.id.importance);

        TableRow tr = (TableRow) findViewById(R.id.idRow);
        if (mRowId!=null){

            tr.setVisibility(View.VISIBLE);
            populateFieldsFromDB();

        }
        else{

            tr.setVisibility(View.GONE);

        }
    }

    private void showMessage(int message) {

        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private void populateFieldsFromDB() {

        try {

            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(mRowId.intValue());
            if (c.moveToFirst()) {

                mItem.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                mPlace.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                mDescription.setText(c.getString(2));
                mImportance.setText(Integer.toString(c.getInt(3)));
                TextView id = (TextView) findViewById(R.id.identificator);
                id.setText(Integer.toString(c.getInt(4)));

            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void saveData() {

        String itemText = mItem.getText().toString();
        String placeText = mPlace.getText().toString();
        String descriptionText = mDescription.getText().toString();
        String importanceText = mImportance.getText().toString();

        try {
            MainActivity.mDbHelper.open();
            if (mRowId == null){

                MainActivity.mDbHelper.insertItem(itemText, placeText, descriptionText,
                        Integer.parseInt(importanceText));

            }
            else{

                TextView tv = (TextView)findViewById(R.id.identificator);
                String ident = tv.getText().toString();
                MainActivity.mDbHelper.updateItem(Integer.parseInt(ident),itemText, placeText, descriptionText, Integer.parseInt(importanceText));

            }

            MainActivity.mDbHelper.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

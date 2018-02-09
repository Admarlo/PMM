package com.example.adrlop.examadria;

import android.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by adrlop on 9/02/18.
 */

public  class SimpleFragment extends Fragment {
    private static final java.lang.String ARG_PARAM = "";
    int mNum;
    TextView mItem = null;
    TextView mPlace = null;
    TextView mDescription = null;
    TextView mImportance = null;
    TextView id = null;
    int mParam1_num;

    Integer mRowId = null;
    static SimpleFragment newInstance(int param1) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, param1);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParam1_num = getArguments().getInt(ARG_PARAM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        View tv  = null;

        v = inflater.inflate(R.layout.frame_registro, container, false);
        tv = v.findViewById(R.id.text);

        ((TextView)tv).setText("Fragmento nº" + mParam1_num);
        mItem = (TextView)v.findViewById(R.id.item);
        mPlace = (TextView)v.findViewById(R.id.place);
        mDescription  = (TextView)v.findViewById(R.id.description);
        mImportance  = (TextView)v.findViewById(R.id.importance);
        id = (TextView)v.findViewById(R.id.identificator);
        populateFieldsFromDB(mParam1_num);

        return v;
    }
    private void populateFieldsFromDB(int numTarea) {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(numTarea);
            if (c.moveToFirst()) {
                mItem.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                mPlace.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                mDescription.setText(c.getString(2));
                mImportance.setText(Integer.toString(c.getInt(3)));
                id.setText(Integer.toString(c.getInt(4)));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}

package com.example.adrlop.fragmentodinamico;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by adrlop on 9/01/18.
 */

public class Fragmento extends Fragment {
    int mNum;
    View tv;
    static Fragment newInstance(int number) {
        Fragment f = new Fragment();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragmento_sinple, container, false);
            v.findViewById(R.id.text);
        }
        else{
            v = inflater.inflate(R.layout.fragmento_simple2 , container, false);
            v.findViewById(R.id.text2);

        }

        ((TextView)tv).setText("Fragmento numero #" + mNum);
        return v;
    }
}


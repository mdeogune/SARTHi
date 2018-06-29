package com.example.mdeogune.sarthi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nEW u on 28-May-18.
 */

public class DriverHistoryFragment extends Fragment {

    EditText mName,mVecID;
    Button mLogout,search;
    ImageView mProfileImage;
     static TextView tv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_driver_history, container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        mName=(EditText)getView().findViewById(R.id.name);
        mVecID=(EditText)getView().findViewById(R.id.vec_id);
        mLogout=(Button)getView().findViewById(R.id.logout);
        mProfileImage=(ImageView)getView().findViewById(R.id.profileImage);
        search=(Button)getView().findViewById(R.id.info);
        tv=(TextView)getView().findViewById(R.id.display);
        tv.setMovementMethod(new ScrollingMovementMethod());
        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fetchData process=new fetchData();
                process.execute();
            }
        });
    }
}


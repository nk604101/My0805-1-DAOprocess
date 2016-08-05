package com.work.hsinwei.my0805_1_daoprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }
    public void click_add(View v)
    {
        EditText ed =(EditText)findViewById(R.id.editText);
        EditText ed2 =(EditText)findViewById(R.id.editText2);
        EditText ed3 =(EditText)findViewById(R.id.editText3);

        String n = ed.getText().toString();
        String a = ed2.getText().toString();
        String p = ed3.getText().toString();

        dataInfoDAOImpl data = new dataInfoDAOImpl(AddActivity.this);
        data.addDataInfo(new dataInfo(n,a,p));
    }
}

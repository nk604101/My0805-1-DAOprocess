package com.work.hsinwei.my0805_1_daoprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DAO
        dataInfoDAO dao =new dataInfoDAOImpl(MainActivity.this);
        /*
        dao.addDataInfo(new dataInfo("aaa","addr1","11111"));
        dao.addDataInfo(new dataInfo("bbb","addr2","22222"));
        dao.addDataInfo(new dataInfo("ccc","addr3","33333"));
        */

        ArrayList<String> display = new ArrayList<>();
        for (dataInfo data:dataInfoDAOImpl.mylist)
        {
            display.add(data.name);
        }
        ArrayAdapter<String> adpt= new ArrayAdapter<String>(
                                    MainActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    display);
        ListView lv =(ListView)findViewById(R.id.listView);
        lv.setAdapter(adpt);

        //Log.d("T0805-DAO",""+dao.getAllDataInfo().size());
        //Log.d("T0805-DAO",""+str);
    }
    //建立 Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);//讀取menu 介面參數
        return true;
    }
}

package com.work.hsinwei.my0805_1_daoprocess;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hsinwei on 2016/8/4.
 */
public class dataInfoDAOImpl implements dataInfoDAO {
    static ArrayList<dataInfo> mylist;
    Context context;
    String fName="dataInfo.json";   //設定檔案名稱
    public dataInfoDAOImpl(Context context)
    {
        this.context=context;   //將 Activity 傳入
        //String fName="dataInfo.json";
        File readFile = new File(context.getFilesDir()+File.separator+fName);
        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        //當錯誤為可處理時 不要使用try catch處理
        //所以readFile 不存在時 可以用 readFile.exists()做判斷
        //
        //若沒有就先讓程式建立一個 沒有內容的 Json檔
        //再建立 ArrayList 去編輯檔案
        if(readFile.exists()) {
            try {
                fr = new FileReader(readFile);
                while (fr.read(buffer) != -1)   //讀取 讀不到會是-1
                {
                    sb.append(new String(buffer));
                }
                fr.close();
                //Log.d("T0804-FileR", sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = sb.toString();

            Gson gson =new Gson();
            mylist = gson.fromJson(data,new TypeToken<ArrayList<dataInfo>>(){}.getType());
            //Log.d("T0805-DataGson",str);
        }
        else
        {
            mylist=new ArrayList<>();
        }
        /*  //資料長度為 0 就新增物件
        if(data.length()==0)
        {
            mylist=new ArrayList<>();
        }
        else
        {
            Gson gson =new Gson();
            String str = gson.toJson(data,new TypeToken<ArrayList<dataInfo>>(){}.getType());
            Log.d("T0805-DataGson",str);
        }*/
    }

    @Override
    public void addDataInfo(dataInfo d) {
        mylist.add(d);

        dataSave();

    }

    @Override
    public void delDataInfo(dataInfo d) {
        mylist.remove(d);
        dataSave();

    }

    @Override
    public void updtaeDataInfo(dataInfo d) {
        for(dataInfo dinfo : mylist)
        {
            if(dinfo.name.equals(d.name))
                dinfo.addr=d.addr;
                dinfo.tel=d.tel;
        }
        dataSave();
    }

    @Override
    public List getAllDataInfo() {

        return mylist;
    }

    private void dataSave()
    {
        Gson gson = new Gson();
        String json = gson.toJson(mylist,new TypeToken<ArrayList<dataInfo>>(){}.getType());
        FileOutputStream fos= null;
        try {
            fos=context.openFileOutput(fName,context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        try {
            osw.write(json);
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

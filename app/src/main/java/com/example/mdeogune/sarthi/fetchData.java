package com.example.mdeogune.sarthi;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by nEW u on 06-Jun-18.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {

    String data="";
    @Override
    protected Void doInBackground(Void... voids) {
        try
        {
            URL url=new URL("https://api.myjson.com/bins/b1gya");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
               line=bufferedReader.readLine();
               data=data+line;
            }

        } catch (MalformedURLException e)
        {
            e.printStackTrace();

        } catch (IOException e)
        {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        DriverHistoryFragment.tv.setText(this.data);
        super.onPostExecute(aVoid);
    }
}

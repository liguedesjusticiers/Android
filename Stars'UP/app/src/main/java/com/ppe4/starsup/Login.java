package com.ppe4.starsup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Alex on 19/04/2016.
 */
public class Login extends AsyncTask<String,Void,String>{
    private TextView nom;
    private Context context;

    public Login(Context context, TextView nom){
        this.context = context;
        this.nom = nom;
    }

    protected void onPreExecute(){

    }

    @Override
    protected String doInBackground(String... params) {
        try{
            String username = (String)params[0];
            String password = (String)params[1];

            String link = "http://127.0.0.1/starsup/index.php";
            String data = URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8");
            data += "&" + URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader((new InputStreamReader(conn.getInputStream())));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null){
                sb.append(line);
                break;
            }

            return sb.toString();
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
        this.nom.setText(result);
    }
}

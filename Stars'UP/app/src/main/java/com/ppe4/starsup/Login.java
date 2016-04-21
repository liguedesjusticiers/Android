package com.ppe4.starsup;

import android.content.Context;
import android.os.AsyncTask;

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
    private Context context;

    public interface AsyncResponse{
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public Login(Context context,AsyncResponse delegate){
        this.context = context;
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            String username = params[0];
            String password = params[1];

            String link = "http://192.168.1.88/starsup/index.php"; //remplacer adresse par ipv4 du pc de la bdd (meme réseau)
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
            String line;

            while((line = reader.readLine()) != null){
                sb.append(line);
                break;
            }

            return sb.toString();
        }
        catch(Exception e){
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result){
        delegate.processFinish(result);
    }
}

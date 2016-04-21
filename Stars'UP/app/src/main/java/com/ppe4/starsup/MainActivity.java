package com.ppe4.starsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Login.AsyncResponse {
    private EditText identifiant,mdp;
    private Button valider;
    String test = "";

    Login asyncTask = new Login(new Login.AsyncResponse(){
        @Override
        void processFinish(String output) {
            test = output;
        }
    }).execute();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        identifiant = (EditText)findViewById(R.id.ET_identifiant);
        mdp = (EditText)findViewById(R.id.ET_mdp);
        valider = (Button)findViewById(R.id.bValider);
    }

    public void login(){
        String username = identifiant.getText().toString();
        String password = mdp.getText().toString();
        new Login(this).execute(username,password);

        Intent startNewActivity = new Intent(this, GestionVisites.class);
        startActivity(startNewActivity);
    }
}

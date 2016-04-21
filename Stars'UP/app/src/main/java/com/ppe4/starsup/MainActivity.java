package com.ppe4.starsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Login.AsyncResponse{
    private EditText identifiant,mdp;
    private String test = "";

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        identifiant = (EditText)findViewById(R.id.ET_identifiant);
        mdp = (EditText)findViewById(R.id.ET_mdp);
    }

    public void login(View view){
        String username = identifiant.getText().toString();
        String password = mdp.getText().toString();
        new Login(this, new Login.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                setTest(output);
                ouvertureListe();
            }
        }).execute(username, password);
    }

    @Override
    public void processFinish(String output) {
        //ça sert a rien mais faut le mettre, je sais pas pourquoi mdr
    }

    public void ouvertureListe(){
        if(getTest().equals("succes")){
            Toast.makeText(MainActivity.this, "Vous vous êtes bien connecté\nBienvenue "+identifiant.getText().toString()+" !", Toast.LENGTH_SHORT).show();

            Intent startNewActivity = new Intent(this, GestionVisites.class);
            startActivity(startNewActivity);
        }
        else{
            Toast.makeText(MainActivity.this, "L'identification a échouée !\nVeuillez réessayer", Toast.LENGTH_SHORT).show();
        }
    }


    
}

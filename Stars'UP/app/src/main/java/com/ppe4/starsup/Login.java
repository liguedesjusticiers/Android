package com.ppe4.starsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText identifiant = null;
    EditText mdp = null;
    Button valider = null;
    public String identifiant_test = "alex";
    public String mdp_test = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        identifiant = (EditText)findViewById(R.id.ET_identifiant);
        mdp = (EditText)findViewById(R.id.ET_mdp);
        valider = (Button)findViewById(R.id.bValider);

        valider.setOnClickListener(verifListener);
    }

    private View.OnClickListener verifListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(identifiant.getText().toString().equals(identifiant_test) && mdp.getText().toString().equals(mdp_test)){
                Toast.makeText(Login.this, "Vous vous êtes bien connecté\nBienvenue "+identifiant.getText().toString()+" !", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Login.this, "L'identification a échouée !\nVeuillez réessayer", Toast.LENGTH_SHORT).show();
            }
        }
    };


}

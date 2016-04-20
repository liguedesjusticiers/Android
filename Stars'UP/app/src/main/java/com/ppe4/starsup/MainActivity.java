package com.ppe4.starsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText identifiant,mdp;
    private TextView nom;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        identifiant = (EditText)findViewById(R.id.ET_identifiant);
        mdp = (EditText)findViewById(R.id.ET_mdp);
        nom = (TextView)findViewById(R.id.TVtest);

//        valider = (Button)findViewById(R.id.bValider);

//        valider.setOnClickListener(verifListener);
    }

    public void login(View view) {
        String username = identifiant.getText().toString();
        String password = mdp.getText().toString();
        new Login(this, nom).execute(username, password);
    }

//    private View.OnClickListener verifListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(identifiant.getText().toString().equals(identifiant_test) && mdp.getText().toString().equals(mdp_test)){
//                Toast.makeText(MainActivity.this, "Vous vous êtes bien connecté\nBienvenue "+identifiant.getText().toString()+" !", Toast.LENGTH_SHORT).show();
//
//                Intent startNewActivity = new Intent(v.getContext(), GestionVisites.class);
//                startActivity(startNewActivity);
//            }
//            else{
//                Toast.makeText(MainActivity.this, "L'identification a échouée !\nVeuillez réessayer", Toast.LENGTH_SHORT).show();
//            }
//        }
//    };


}

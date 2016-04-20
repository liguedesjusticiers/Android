package com.ppe4.starsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText identifiant,mdp;
    private Button valider;
    Login log = new Login(this);

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
            String username = identifiant.getText().toString();
            String password = mdp.getText().toString();
            log.execute(username, password);
            if(log.isVerif()){
                Toast.makeText(MainActivity.this, "Vous vous êtes bien connecté\nBienvenue "+identifiant.getText().toString()+" !", Toast.LENGTH_SHORT).show();

                Intent startNewActivity = new Intent(v.getContext(), GestionVisites.class);
                startActivity(startNewActivity);
            }
            else{
                Toast.makeText(MainActivity.this, "L'identification a échouée !\nVeuillez réessayer", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, ""+log.isVerif()+"", Toast.LENGTH_SHORT).show();
            }
        }
    };


}

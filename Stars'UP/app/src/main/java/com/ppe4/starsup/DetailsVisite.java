package com.ppe4.starsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsVisite extends AppCompatActivity {

    private TextView TVnom;
    private TextView TVnote;
    private EditText ETcommentaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_visite);

        TVnom = (TextView)findViewById(R.id.TVnomVisite);
        TVnote = (TextView)findViewById(R.id.TVnoteVisite);
        ETcommentaire = (EditText)findViewById(R.id.ETcommentaireVisite);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nom = (String)bundle.get("nomVisite");
        String note = (String) bundle.get("noteVisite");
        String commentaire = (String) bundle.get("commentaireVisite");
        TVnom.setText(nom);
        TVnote.setText(note);
        ETcommentaire.setText(commentaire);
    }

    private View.OnClickListener confirmListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
        }
    };
}

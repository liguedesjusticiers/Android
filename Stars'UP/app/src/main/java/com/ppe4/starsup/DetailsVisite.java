package com.ppe4.starsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsVisite extends AppCompatActivity {

    private TextView TVnom;
    private TextView TVnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_visite);

        TVnom = (TextView)findViewById(R.id.TVnomVisite);
        TVnote = (TextView)findViewById(R.id.TVnoteVisite);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nom = (String)bundle.get("nomVisite");
        String note = (String) bundle.get("noteVisite");
        TVnom.setText(nom);
        TVnote.setText(note);
    }
}

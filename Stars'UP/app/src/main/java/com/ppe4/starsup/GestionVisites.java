package com.ppe4.starsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GestionVisites extends AppCompatActivity {

    ListView mListView;
    String nomVisite = "Au bon tavernier";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_visites);

        mListView = (ListView) findViewById(R.id.listView);
        List<Visite> visites = genererVisites();

        VisiteAdapter adapter = new VisiteAdapter(GestionVisites.this, visites);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GestionVisites.this , DetailsVisite.class);
                intent.putExtra("nomVisite", genererVisites().get(position).getNom().toString());
                intent.putExtra("noteVisite", genererVisites().get(position).getNote().toString());
                intent.putExtra("commentaireVisite", genererVisites().get(position).getCommentaire().toString());
                startActivity(intent);
            }
        });
    }

    private List<Visite> genererVisites(){
        List<Visite> visites = new ArrayList<Visite>();
        visites.add(new Visite("A la petite chaise", "8", ""));
        visites.add(new Visite("Le gourmandin", "2", ""));
        visites.add(new Visite("La bouche des goûts", "4", ""));
        visites.add(new Visite("Mia cucina", "5", ""));
        visites.add(new Visite("Le bouche à oreille", "7", ""));
        visites.add(new Visite("Kebab du coin", "4", ""));
        visites.add(new Visite("Panini Gourmand", "8", ""));
        visites.add(new Visite("La boulangerie", "6", ""));
        visites.add(new Visite("La taverne du poney qui tousse", "3", ""));
        visites.add(new Visite("La baraque à frites", "6", ""));
        visites.add(new Visite("La table du pécheur", "10", ""));
        visites.add(new Visite("Les frères toqués", "8", ""));
        visites.add(new Visite("L'auberge du vieux crouton", "6", ""));
        visites.add(new Visite("Le patio", "8", ""));
        visites.add(new Visite("Flunch", "0", ""));
        return visites;
    }
}

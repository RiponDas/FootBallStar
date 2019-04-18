package com.example.talkingglass.footballstar;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {


    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);


        rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        country = new String[] { "messi", "ronaldo", "neymar",
                "ramos", "griezmann", "modric", "suarez", "mbappe",
                "neuer", "bruyne" };

        population = new String[] { "Lionel Andrés Messi Cuccittini is an Argentine professional footballer who plays as a forward and captains both Spanish club Barcelona and the Argentina",
                "Cristiano Ronaldo dos Santos Aveiro GOIH ComM is a Portuguese professional footballer who plays as a forward for Italian club Juventus and captains",
                "Neymar da Silva Santos Júnior commonly known as Neymar Jr. or simply Neymar, is a Brazilian professional footballer who plays as a forward",
                "Sergio Ramos García is a Spanish professional footballer who plays for and captains both Real Madrid and the Spain national team as a centre back.",
                "Antoine Griezmann is a French professional footballer who plays as a forward for Atlético Madrid and the French national team",
                "Luka Modrić is a Croatian professional footballer who plays as a midfielder for Spanish club Real Madrid and is the captain of the Croatia national team",
                "Luis Alberto Suárez Díaz is a Uruguayan professional footballer who plays as a striker for Spanish club Barcelona and the Uruguay national team",
                "Kylian Mbappé Lottin is a French professional footballer who plays as a forward for Ligue 1 club Paris Saint-Germain and the France national team.",
                "Manuel Peter Neuer is a German professional footballer who plays as a goalkeeper and captain for both German club Bayern Munich and the Germany national ",
                "Kevin De Bruyne is a Belgian professional footballer who plays as a midfielder for English club Manchester City and the Belgian national team. His playing style" };

        flag = new int[] { R.drawable.messi, R.drawable.ronaldo,
                R.drawable.neymar, R.drawable.ramos,
                R.drawable.griezmann, R.drawable.modric, R.drawable.suarez,
                R.drawable.mbappe, R.drawable.neuer, R.drawable.bruyne };

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < rank.length; i++)
        {
            WorldPopulation wp = new WorldPopulation(rank[i], country[i],
                    population[i], flag[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
}
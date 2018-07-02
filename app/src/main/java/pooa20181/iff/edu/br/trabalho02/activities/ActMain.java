package pooa20181.iff.edu.br.trabalho02.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pooa20181.iff.edu.br.trabalho02.R;

public class ActMain extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private String[] activities = {"ActCandidatos","ActEleitores"};
    private String[] itemMenu = {"Candidatos","Eleitores"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemMenu);

        ListView listView = findViewById(R.id.listaMenu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Intent intent = null;

        try {
            Class obj =    Class.forName("pooa20181.iff.edu.br.trabalho02.activities." + activities[position]);
            intent = new Intent(this, obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}




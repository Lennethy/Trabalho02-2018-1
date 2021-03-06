package pooa20181.iff.edu.br.trabalho02.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import io.realm.Realm;
import pooa20181.iff.edu.br.trabalho02.R;
import pooa20181.iff.edu.br.trabalho02.adapters.ClickRecyclerViewListener;
import pooa20181.iff.edu.br.trabalho02.adapters.AdapterEleitor;
import pooa20181.iff.edu.br.trabalho02.models.Eleitor;

public class ActEleitores extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_eleitores);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActEleitores.this, ActEleitorPerfil.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvEleitor);
        recyclerView.setAdapter(new AdapterEleitor(getEleitores(), this, this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Eleitor> getEleitores()
    {
        return (List) realm.where(Eleitor.class).findAll();
    }

    public void onClick(Object object) {
        Eleitor eleitor = (Eleitor) object;
        Intent intent = new Intent( ActEleitores.this, ActEleitorPerfil.class);
        intent.putExtra("id", eleitor.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }

}

package pooa20181.iff.edu.br.trabalho02.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20181.iff.edu.br.trabalho02.R;
import pooa20181.iff.edu.br.trabalho02.models.Eleitor;

public class AdapterEleitor extends RecyclerView.Adapter {
    private List<Eleitor> eleitores;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public AdapterEleitor(List<Eleitor> eleitores, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.eleitores = eleitores;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_eleitor_cv, parent, false);
        EleitorViewHolder eleitorViewHolder = new EleitorViewHolder(view);

        return eleitorViewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        EleitorViewHolder eleitorHolder = (EleitorViewHolder) viewHolder;
        Eleitor eleitor = this.eleitores.get(position);

        eleitorHolder.nome.setText(eleitor.getNome());
        eleitorHolder.numeroTitulo.setText(eleitor.getNumeroTitulo());
        eleitorHolder.zona.setText(eleitor.getZona());
        eleitorHolder.secao.setText(eleitor.getSecao());

        eleitorHolder.txtNome.setText("Nome do Eleitor: ");
        eleitorHolder.txtNumeroTitulo.setText("Número do Titulo: ");
        eleitorHolder.txtZona.setText("Zona: ");
        eleitorHolder.txtSecao.setText("Seção: ");
    }

    @Override
    public int getItemCount() {
        return eleitores.size();
    }

    public class EleitorViewHolder extends RecyclerView.ViewHolder{

        private final TextView nome;
        private final TextView numeroTitulo;
        private final TextView zona;
        private final TextView secao;

        private final TextView txtNome;
        private final TextView txtNumeroTitulo;
        private final TextView txtZona;
        private final TextView txtSecao;

        public EleitorViewHolder(View itemView){
            super(itemView);

            nome = itemView.findViewById(R.id.tvNomeEleitor);
            numeroTitulo = itemView.findViewById(R.id.tvNumeroTitulo);
            zona = itemView.findViewById(R.id.tvZona);
            secao = itemView.findViewById(R.id.tvSecao);

            txtNome = itemView.findViewById(R.id.textNomeEleitor);
            txtNumeroTitulo = itemView.findViewById(R.id.textNumeroTitulo);
            txtZona = itemView.findViewById(R.id.textZona);
            txtSecao = itemView.findViewById(R.id.textSecao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(eleitores.get(getLayoutPosition()));
                }
            });
        }
    }


}

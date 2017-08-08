package com.example.luana.proprietario_realm.adapter;

import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

import com.example.luana.proprietario_realm.R;
import com.example.luana.proprietario_realm.model.Proprietario;

import java.util.List;


public class ProprietarioAdapter  extends RecyclerView.Adapter {

    private List<Proprietario> proprietarios;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ProprietarioAdapter(List<Proprietario> proprietarios, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.proprietarios = proprietarios;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_item, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario livro  = proprietarios.get(position) ;

        holder.Nnome.setText(livro.getNome());
        holder.Nend.setText(livro.getEnd());
        holder.Ntel.setText(livro.getTel());



    }

    @Override
    public int getItemCount() {

        return proprietarios.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class ProprietarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView Nnome;
        private final TextView Nend;
        private final TextView Ntel;


        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            Nnome = (TextView) itemView.findViewById(R.id.Nnome);
            Nend = (TextView) itemView.findViewById(R.id.Nend);
            Ntel = (TextView) itemView.findViewById(R.id.Ntel);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getLayoutPosition()));

                }
            });


        }
    }
}
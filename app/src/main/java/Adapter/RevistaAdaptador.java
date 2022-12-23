package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import Models.Revista;
import Models.Usuario;
import uteq.solutions.recyclercardview.R;

public class RevistaAdaptador extends RecyclerView.Adapter<RevistaAdaptador.RevistaViewHolder> {
    private Context Ctx;
    private List<Revista> lista_revistas;

    public RevistaAdaptador(Context mCtx, List<Revista> revista) {
        this.lista_revistas = revista;
        Ctx = mCtx;
    }

    @Override
    public RevistaAdaptador.RevistaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyrevista_item, null);
        return new RevistaAdaptador.RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RevistaAdaptador.RevistaViewHolder holder, int position) {
        Revista revista = lista_revistas.get(position);
        holder.textViewNrevista.setText(revista.getTitulo());

        Glide.with(Ctx)
                .load(revista.getPortada())
                .into(holder.imageportada);
    }

    @Override
    public int getItemCount() {
        return lista_revistas.size();
    }

    class RevistaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNrevista;
        ImageView imageportada;
        public RevistaViewHolder(View itemView) {
            super(itemView);
            textViewNrevista = itemView.findViewById(R.id.txtnombrerevista);
            imageportada = itemView.findViewById(R.id.imgportada);
        }

    }

}

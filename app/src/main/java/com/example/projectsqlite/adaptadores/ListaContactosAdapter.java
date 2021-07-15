package com.example.projectsqlite.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectsqlite.R;
import com.example.projectsqlite.entidades.Contactos;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    ArrayList<Contactos> listaContactos;

    public ListaContactosAdapter(ArrayList<Contactos> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_contactos, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.tvNombre.setText(listaContactos.get(position).getNombre());
        holder.tvTelefono.setText(listaContactos.get(position).getTelefono());
        holder.tvCorreoElectronico.setText(listaContactos.get(position).getCorreo_electronico());
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre, tvTelefono, tvCorreoElectronico;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView)itemView.findViewById(R.id.tvName);
            tvTelefono = (TextView)itemView.findViewById(R.id.tvPhone);
            tvCorreoElectronico = (TextView)itemView.findViewById(R.id.tvEmail);

        }
    }
}

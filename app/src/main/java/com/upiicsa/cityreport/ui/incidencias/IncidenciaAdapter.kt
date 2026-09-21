package com.upiicsa.cityreport.ui.incidencias

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upiicsa.cityreport.data.Incidencia
import com.upiicsa.cityreport.databinding.ItemIncidenciaBinding

class IncidenciaAdapter(
    private val lista: List<Incidencia>
) : RecyclerView.Adapter<IncidenciaAdapter.IncidenciaViewHolder>() {

    inner class IncidenciaViewHolder(
        val binding: ItemIncidenciaBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciaViewHolder {
        val binding = ItemIncidenciaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IncidenciaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IncidenciaViewHolder, position: Int) {
        val item = lista[position]
        holder.binding.tvTituloIncidencia.text = item.titulo
        holder.binding.tvDescripcionIncidencia.text = item.descripcion
        holder.binding.tvFechaIncidencia.text = "Fecha: ${item.fecha}"
        holder.binding.tvEstadoIncidencia.text = "Estado: ${item.estado}"
    }

    override fun getItemCount(): Int = lista.size
}

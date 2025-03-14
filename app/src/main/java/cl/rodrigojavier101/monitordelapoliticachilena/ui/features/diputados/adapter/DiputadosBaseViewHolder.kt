package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.Diputado

abstract class DiputadosBaseViewHolder<T>(item: View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: Diputado)
}

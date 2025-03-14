package cl.antoinette.monitor_politico_econmico.ui.features.diputados.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado

abstract class DiputadosBaseViewHolder<T>(item: View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: Diputado)
}

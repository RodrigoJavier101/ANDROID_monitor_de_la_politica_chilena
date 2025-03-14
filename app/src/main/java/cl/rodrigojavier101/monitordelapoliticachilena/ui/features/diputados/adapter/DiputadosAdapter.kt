package cl.antoinette.monitor_politico_econmico.ui.features.diputados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado

class DiputadosAdapter(
   private var list: List<Diputado> = mutableListOf(),
) : RecyclerView.Adapter<DiputadosBaseViewHolder<*>>() {

   override fun onCreateViewHolder(
      parent: ViewGroup,
      viewType: Int
   ): DiputadosBaseViewHolder<*> {
      val binding = ItemDiputadosActualesBinding.inflate(
         LayoutInflater.from(parent.context),
         parent,
         false
      )
      return DiputadosItemViewHolder(binding)
   }

   override fun onBindViewHolder(
      holder: DiputadosBaseViewHolder<*>,
      position: Int
   ) {

      when (holder) {
         is DiputadosItemViewHolder -> holder.bind(list[position])
      }
   }


   fun setItemInTheView(diputadosActuales: List<Diputado>?) {
      if (diputadosActuales != null) {
         this.list = diputadosActuales
         notifyDataSetChanged()
      }
   }

   override fun getItemCount() = list.size
}
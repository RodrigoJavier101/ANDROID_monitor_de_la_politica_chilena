package cl.antoinette.monitor_politico_econmico.ui.features.diputados.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import cl.antoinette.monitor_politico_econmico.R
import cl.antoinette.monitor_politico_econmico.data.network.model.DiputadoNetworkModel
import cl.antoinette.monitor_politico_econmico.databinding.ItemDiputadosActualesBinding
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
import com.squareup.picasso.Picasso

class DiputadosItemViewHolder(private val binding: ItemDiputadosActualesBinding) : DiputadosBaseViewHolder<DiputadoNetworkModel>(binding.root) {

   override fun bind(
      item: Diputado,
   ) = with(binding) {
      Picasso
         .get()
         .load(item.picture)
         .into(imageViewDiputadoActual)
      textViewNombreDiputadoActual.text = item.nombre

      linearLayoutDiputadosActuales.setOnClickListener {
         startRotationAnimation(
            textViewNombreDiputadoActual,
            id = item.idDiputadoActual,
            web = item.paginaWeb,
         )
      }
   }

   private fun startRotationAnimation(
      view: View,
      id: String,
      web: String,
   ) {
      view
         .animate()
         .apply {
            duration = 600
            interpolator = LinearInterpolator()
            scaleX(1.2f)
            withEndAction {
               Navigation
                  .findNavController(view)
                  .navigate(
                     R.id.action_diputadosFragment_to_diputadoDetailFragment,
                     bundleOf(
                        "id" to id,
                        "web" to web,
                     )
                  )
            }
            start()
         }
   }
}
package cl.rodrigojavier101.monitordelapoliticachilena.data.network

import cl.rodrigojavier101.monitordelapoliticachilena.data.network.model.DiputadoNetworkModel
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.BASE_URL_DIP_ACT
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.DIPUTADOS_DIP_ACT
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.END_POINT_DIP_ACT
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.stream.Collectors
import javax.inject.Inject

class DiputadosWebScrapProvider @Inject constructor() {

    private var diputadosList = mutableListOf<DiputadoNetworkModel>()

    /*LEGISLATIVO*/
    private fun getDiputadosDocument(): Document {
        val url = "${BASE_URL_DIP_ACT}${END_POINT_DIP_ACT}"
        val jsoup = Jsoup
            .connect(url)
            .get()
        return jsoup
    }


    suspend fun getDiputadosActuales(): List<DiputadoNetworkModel?> {
        try {
            val document: Document = getDiputadosDocument()
            val articleElement: Elements = document.select("article.grid-2")
            val nameList = articleElement
                .select("h4")
                .eachText()
                .stream()
                .collect(Collectors.toList())

            val webpage = articleElement
                .select("a")
                .eachAttr("href")
                .stream()
                .collect(Collectors.toList())
            val imagesList = articleElement
                .select("img")
                .eachAttr("src")
                .stream()
                .collect(Collectors.toList())
            var countAttr = 0

            if (webpage.size / 3 == nameList.size) {
                val oldValueOne = "Sr. "
                val oldValueTwo = "Sra. "
                val newValue = ""

                for ((i, f) in imagesList.withIndex()) {
                    diputadosList.add(
                        DiputadoNetworkModel(
                            nombre = nameList[i]
                                .replace(
                                    oldValueOne,
                                    newValue
                                )
                                .replace(
                                    oldValueTwo,
                                    newValue
                                ),
                            paginaWeb = "${BASE_URL_DIP_ACT}$DIPUTADOS_DIP_ACT${webpage[countAttr]}",
                            id = "${BASE_URL_DIP_ACT}$DIPUTADOS_DIP_ACT${webpage[countAttr]}".split(
                                "prmID="
                            )[1],
                            picture = "${BASE_URL_DIP_ACT}${f}"
                        )
                    )
                    countAttr += 3
                }
            }
            return diputadosList.toList()
        } catch (e: Exception) {
            return listOf<DiputadoNetworkModel>()
        }
    }

}
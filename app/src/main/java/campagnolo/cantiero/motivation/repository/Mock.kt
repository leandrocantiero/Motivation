package campagnolo.cantiero.motivation.repository

import campagnolo.cantiero.motivation.infra.Motivation
import java.util.*

data class Phrase (val description: String, val category: Int)

class Mock {
    private val ALL = Motivation.fraseFilter.ALL
    private val HAPPY = Motivation.fraseFilter.HAPPY
    private val SUN = Motivation.fraseFilter.SUN

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUN),
        Phrase("Você perde todas as chances que você não aproveita.", SUN),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUN),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUN),
        Phrase("Se você acredita, faz toda a diferença.", SUN),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUN)
    )

    fun getPhrase(value: Int): String {
        val filtered = mListPhrases.filter { (it.category == value || value == ALL) }
        val rand = Random().nextInt(filtered.size)
        return filtered[rand].description
    }
}

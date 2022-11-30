package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vesalius.databinding.ActivityConteudoViewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class ConteudoView : AppCompatActivity() {
    lateinit var binding: ActivityConteudoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConteudoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btAr.setOnClickListener {
            val intent = Intent (this, UnityHolderActivity::class.java)
            startActivity(intent)
        }

        var  tipo = intent.getStringExtra("siste")
        when (tipo) {
            "esque" -> {
                esqueletico()
            }
            "cardio" -> {
                cardio()
            }
            "fem" -> {
               femi()
            }
            "nervo" -> {
                nervoso()
            }
            "musc" -> {
                muscular()
            }
            else -> {
                Log.d("img", "Error")
            }
        }

    }

    private fun muscular() {
       binding.titulo1.text= "INTRODUÇÃO"
        binding.ass1.text= "O Sistema Muscular é o conjunto de músculos existentes no corpo humano, sua formação se dá por tecido originado pelo mesoderma (folheto embrionário que dá origem aos músculos, o esqueleto e os sistemas cardiovascular, excretor e reprodutor). Sua característica principal é a propriedade de contração e relaxamento de suas fibras. O ramo da anatomia que o estuda é a Miologia."
        binding.titulo2.text = "MUSCULOS"
        binding.ass2.text = "Os músculos são estruturas anatômicas de formas e comprimentos variáveis, formadas por miócitos e que se inserem aos ossos através de tendões, são caracterizados pela contração (capacidade de diminuir o comprimento) e relaxamento, onde estas ações movimentam partes do corpo, inclusive os órgãos internos. Os músculos representam cerca de 40% a 50% do peso corporal total, e são capazes de transformar energia química em energia mecânica"
        binding.titulo3.text = "TIPOS DE MUSCULOS"
        binding.ass3.text = "O corpo humano contém três tipos de músculos: músculo não estriado (músculo liso), músculo estriado esquelético e músculo estriado cardíaco. Com base no tipo de controle exercido sobre sua atividade podem ser classificados também em músculos voluntários e músculos involuntários.\n" +
                "Nos músculos voluntários as contrações estão normalmente sob controle consciente do indivíduo que as executa, mas devemos saber que em algumas condições, as contrações destes músculos não requerem um propósito consciente, como por exemplo, usualmente um indivíduo não tem que pensar na contração dos músculos envolvidos na manutenção da postura, não é mesmo? Os músculos voluntários são controlados pela porção do sistema nervoso somático. Nos músculos involuntários as contrações não estão sob controle consciente do indivíduo. Estes músculos são controlados pela porção do sistema nervoso autônomo.\n" +
                "Agora falaremos logo abaixo um pouco sobre os três tipos de músculos do corpo:\n" +
                "\n" +
                "\n" +
                "• Músculo Não Estriado (Músculo Liso): neste tipo de músculo as células não apresentam as estriações que são microscopicamente visíveis nas células musculares esqueléticas. Como este músculo é encontrado nas paredes das vísceras ocas e tubulares, como nos vasos sanguíneos, estômago e intestinos, é também chamado de músculo visceral. O músculo não estriado (músculo liso) é um músculo involuntário, pois suas contrações comandam o movimento de\n" +
                "materiais através dos sistemas de órgãos do corpo humano.\n" +
                "•\tMúsculo Estriado Esquelético: está fixado aos ossos, geralmente através de cordões fibrosos, denominados tendões. As contrações deste músculo estriado esquelético exercem força nos ossos e então eles se movimentam e consequentemente é o responsável por diversas atividades, como levantar objetos e andar ou correr. Vale ressaltar que os músculos estriados esqueléticos são os únicos músculos voluntários do corpo.\n" +
                "• Músculo Estriado Cardíaco: é um tipo especializado de músculo que forma a parede do coração e pode ser também chamado de miocárdio. Controla os batimentos cardíacos. Este músculo é involuntário, como o músculo liso, e é estriado, como o músculo esquelético. Sua contração é forte e como já vimos involuntária.\n"
        binding.titulo4.text= "DISPOSIÇÃO DA FIBRA MUSCULAR:"
        binding.ass4.text = "\n" +
                "• Transverso: encontra-se perpendicular à linha média e podemos citar como\n" +
                "exemplo o músculo transverso abdominal.\n" +
                "\n" +
                "• Reto: apresenta-se paralelo à linha média e podemos citar como exemplo o\n" +
                "músculo reto abdominal.\n" +
                "\n" +
                "• Obliquo: apresenta-se diagonalmente à linha média, exemplo desse músculo temos o oblíquo externo.\n" +
                "\n" +
                "Quanto à Função: na realização de algum movimento, são envolvidos vários\n" +
                "músculos além daquele diretamente responsável pelo mesmo. São os seguintes:\n" +
                "\n" +
                "• Músculo Agonista: agente principal de um movimento, esse músculo se contrai ativamente para produzir um movimento desejado. Ex.: músculos flexores dos dedos, quando apertamos a mão de uma pessoa.\n" +
                "\n" +
                "• Músculo Antagonista: quando um músculo se opõe ao trabalho de um agonista, regulando força e velocidade do movimento. Ex.: músculos extensores dos dedos, não deixando apertar com força nem rapidez a mão da pessoa.\n" +
                "\n" +
                "• Músculo Sinergista: músculo que tem função de estabilizar as articulações\n" +
                "para que não ocorram movimentos indesejáveis durante uma ação normal.\n" +
                "Ex.: um dos músculos sinergista do movimento de abdução da coxa é o reto\n" +
                "femoral.\n" +
                "\n" +
                "• Músculos Fixadores ou Posturais: sua atuação não está diretamente relacionada ao movimento, mas sim na fixação de um segmento do corpo para\n" +
                "\n" +
                "permitir um apoio básico nos movimentos executados por outros músculos.\n" +
                "A inervação dos músculos esqueléticos ocorre no sistema nervoso central que\n" +
                "\n" +
                "envia através dos nervos o comando para que haja a contração dos músculos. Algumas lesões ou cortes nestes nervos deixam o músculo sem movimento, causando sua atrofia, que é a diminuição da massa muscular pelo desuso. Sabemos que os músculos são estruturas que contêm uma grande rede vascular que os nutrem de sangue arterial, abastecendo-os de oxigênio e nutrientes, necessários ao seu dispêndio de energia com o trabalho muscular. Para efeito de informação destacamos aqui o porquê da aplicação de medicamentos por via intra-\n" +
                "muscular. O músculo funciona como um depósito da substância nele injetada e que aos poucos vai sendo absorvida pela presença da grande rede vascular nele contido.\n"
    }

    private fun nervoso() {

    }

    private fun femi() {

    }

    private fun cardio() {

    }

    private fun esqueletico() {

    }
}
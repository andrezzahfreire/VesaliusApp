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
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btAr.setOnClickListener {
            val intent = Intent (this, UnityHolderActivity::class.java)
            startActivity(intent)
        }

        binding.btAnot.setOnClickListener {
            val intent = Intent (this, Anotacoes::class.java)
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

        binding.img1.setImageResource(R.drawable.muscular1)
        binding.img2.setImageResource(R.drawable.muscular2)
    }

    private fun nervoso() {
        binding.titulo1.text= "Introdução"
        binding.ass1.text= "O sistema nervoso é o sistema responsável por captar, processar e gerar respostas diante dos estímulos aos quais somos submetidos. É devido à presença desse sistema que somos capazes de sentir e reagir a diferentes alterações que ocorrem em nossa volta e mesmo no interior do nosso corpo.\"\n" +
                "\n"
        binding.titulo2.text =""
        binding.ass2.text ="Ele pode ser dividido em duas porções:\n" +
                "\n" +
                "•Sistema nervoso central: formado pelo encéfalo e medula espinhal.\n" +
                "\n" +
                "•Sistema nervoso periférico: formado pelos nervos, gânglios e terminações nervosas.\"\n" +
                "\n" +
                "\"O sistema nervoso é composto por um tipo especial de tecido denominado tecido nervoso, o qual possui como tipos celulares os neurônios e as chamadas células da glia.\n" +
                "\n"
        binding.titulo3.text = ""
        binding.ass3.text = "Os neurônios são responsáveis pela propagação do impulso nervoso e apresentam como partes básicas o corpo celular, onde está localizado o núcleo, e dois tipos de prolongamentos, os axônios e os dendritos. De acordo com a função desempenhada, os neurônios podem ser classificados em dois grupos básicos: sensitivos ou aferentes (levam impulsos para o sistema nervoso) e motores ou eferentes (levam impulsos para outras partes, como músculos e glândulas).\"\n" +
                "\n"
        binding.titulo4.text= ""
        binding.ass4.text = "O grupo de células chamado células da glia está relacionado com várias funções, tais como nutrição e regulação do funcionamento dos neurônios. Células ependimárias, astrócitos, oligodendrócitos, microglia e células de Schwann são células da glia.\"\n"
        binding.img1.setImageResource(R.drawable.nervoso1)
        binding.img2.setImageResource(R.drawable.nervoso1)

    }

    private fun femi() {
        binding.titulo1.text= "Introdução"
        binding.ass1.text= "O Sistema Reprodutor Feminino ou Aparelho Reprodutor Feminino é o sistema responsável pela reprodução humana."
        binding.titulo2.text ="Funções"
        binding.ass2.text ="Ele cumpre diversos papéis importantes:\n" +
                "•\tproduz os gametas femininos (óvulos);\n" +
                "•\tfornece um local apropriado para a ocorrência da fecundação;\n" +
                "•\tpermite a implantação de embrião;\n" +
                "•\toferece ao embrião condições para seu desenvolvimento;\n" +
                "•\texecuta atividade motora suficiente para expelir o novo ser quando ele completa sua formação.\n" +
                "•\tO sistema reprodutor feminino é formado pelos seguintes órgãos: ovários, tubas uterinas, útero e vagina.\n" +
                "•\t\n"
        binding.titulo3.text = "Ovários"
        binding.ass3.text = "Os ovários são dois órgãos de forma oval que medem de 3 a 4 cm de comprimento. Eles são responsáveis pela produção dos hormônios sexuais da mulher, o progesterona e o estrogênio. Nos ovários também são armazenadas as células sexuais femininas, os óvulos."
        binding.titulo4.text= ""
        binding.ass4.text = "Assim, durante a fase fértil da mulher, aproximadamente uma vez por mês, um dos ovários lança um óvulo na tuba uterina: é a chamada ovulação."
        binding.img1.setImageResource(R.drawable.feminino1)
        binding.img2.setImageResource(R.drawable.feminino1)
    }

    private fun cardio() {
        binding.titulo1.text= "Introdução ao sistema cardiovascular"
        binding.ass1.text= "A principal função do sistema cardiovascular é oferecer ao organismo nutrição\n" +
                "e oxigenação celular para seu crescimento e manutenção. Este sistema transporta\n" +
                "material nutritivo que foi absorvido pela digestão e o oxigênio captado pela respi-\n" +
                "ração para todas as células do corpo e de modo semelhante, recolhe os produtos\n" +
                "residuais do metabolismo celular levando-os até onde serão excretados. O sistema\n" +
                "circulatório é do tipo fechado, ou seja, sem comunicação com o meio externo do\n" +
                "corpo, sendo formado pelo coração, vasos, sangue e linfa, que estudaremos em\n" +
                "seguida.\n" +
                "\n"
        binding.titulo2.text = "Coração"
        binding.ass2.text = "O coração é o órgão responsável pelo bombeamento do sangue através do\n" +
                "corpo. É um órgão muscular, oco, situado na porção mediastinal da cavidade torá-\n" +
                "cica, entre o osso esterno e a coluna vertebral, abraçado pelos pulmões e acima do\n" +
                "diafragma. Está disposto obliquamente e seu ápice mais inclinado para o lado es-\n" +
                "querdo do plano mediano, conforme visualizamos na figura 1. O ápice do coração,\n" +
                "situado na região inferior, é mais lateral, enquanto a base é medial. Na base do co-\n" +
                "ração estão os grandes vasos que chegam e saem deste órgão.\n" +
                "\n"
        binding.titulo3.text = "Estrutura anatômica do coração"
        binding.ass3.text = "O coração, órgão do sistema cardiovascular, é uma câmara oca com quatro cavidades: dois átrios e dois ventrículos. Possui o formato de um cone invertido com o ápice voltado para baixo e apresenta o volume aproximado de uma mão fechada. Normalmente pesa cerca de 300 g\n "+
                "\n" +
                "\"As paredes do coração são compostas por três túnicas:\n" +
                "\n" +
                "Endocárdio: túnica formada por endotélio que repousa sobre uma camada de tecido conjuntivo frouxo, a camada subendotelial. Essa última camada é conectada ao miocárdio pela camada subendocardial, a qual apresenta nervos, veias e ramos do sistema que conduz o impulso nervoso.\n" +
                "\n" +
                "Miocárdio: camada mais espessa do coração e responsável pela capacidade de contração do órgão. Essa camada é formada por feixes de fibras musculares cardíacas, as quais estão orientadas em várias direções. O miocárdio envolve as câmeras do coração, sendo mais espesso nos ventrículos – em especial, no ventrículo esquerdo – e mais fino nas paredes dos átrios.\n" +
                "\n" +
                "Pericárdio: saco invaginado que envolve o coração e formado pelo pericárdio parietal e o pericárdio visceral. O pericárdio parietal é uma camada externa, enquanto o pericárdio visceral é uma camada mais interna. O pericárdio visceral forma o chamado epicárdio e reveste o coração externamente.\"\n" +
                "\n"
        binding.titulo4.text= "Estrutura da parede do coração"
        binding.ass4.text = "A parede do coração é formada por três camadas distintas: epicárdio, miocárdio e endocárdio. O epicárdio é a camada mais externa e reveste superficialmente o órgão. O miocárdio, por sua vez, está localizado logo abaixo do epicárdio e é formado por tecido muscular estriado cardíaco. Já o endocárdio é o revestimento mais interno e é formado por tecido conjuntivo e endotélio.\n" +
                "O coração humano, assim como o de outros mamíferos, é formado por quatro cavidades: átrio esquerdo e direito e ventrículo esquerdo e direito. Essas estruturas são separadas em lado esquerdo e direito em razão da presença de um septo que divide o órgão em duas metades.\n" +
                "Separando os átrios dos ventrículos, existem valvas que garantem que o sangue não retorne à cavidade anterior. Entre o átrio e o ventrículo direito, existe uma valva denominada tricúspide ou valva atrioventricular direita. Já entre o átrio e o ventrículo esquerdo, encontramos a valva mitral ou valva atrioventricular esquerda. Na saída do ventrículo direito, existe ainda a valva pulmonar, e na saída do ventrículo esquerdo, encontramos a valva aórtica. As valvas pulmonares juntamente às aórticas são denominadas de valvas semilunares.\n" +
                "\n"
        binding.img1.setImageResource(R.drawable.cardiovascular1)
        binding.img2.setImageResource(R.drawable.cardiovascular2)

    }

    private fun esqueletico() {
        binding.titulo1.text= "Introdução"
        binding.ass1.text= "O esqueleto é um conjunto de ossos e cartilagens ligados entre si para formar o arcabouço do corpo e desempenhar várias funções. Os ossos são rijos com variação de forma, coloração e número, geralmente unidos por articulações e ligamentos (formando o esqueleto articulado) ou isolados, dos quais os únicos exemplos são o osso híódeo e os sesamóides."
        binding.titulo2.text =""
        binding.ass2.text ="Podemos citar várias funções importantes do esqueleto humano, tais como:\n" +
                "• Sustentação e conformidade: fornece uma base estrutural para o corpo,\n" +
                "sustenta os tecidos moles e forma pontos fixos para tendões de diversos\n" +
                "músculos esqueléticos;\n" +
                "• Proteção: protege órgãos nobres (encéfalo, coração e pulmões) contra trau-\n" +
                "matismos externos;\n" +
                "• Participação na alavancagem (movimentação): juntamente com os múscu-\n" +
                "los esqueléticos desloca o corpo ou parte dele;\n" +
                "• Hematopoiese: produz células sanguíneas através da medula óssea verme-\n" +
                "lha;\n" +
                "\n"
        binding.titulo3.text = ""
        binding.ass3.text = "• Homeostasia mineral: armazena vários tipos de minerais, principalmente\n" +
                "cálcio e fósforo.\n" +
                "• Armazenamento de energia: armazena lipídios na medula óssea amarela\n" +
                "ou flava.\n" +
                "\n"
        binding.titulo4.text= ""
        binding.ass4.text = "O esqueleto humano está didaticamente dividido em duas grandes partes:\n" +
                "• Esqueleto axial: medial formando o eixo do corpo, constituído pelos ossos\n" +
                "do crânio e face, coluna vertebral, costelas e esterno. (Do latim axis igual a\n" +
                "eixo, está formado por 80 ossos, sendo 28 ossos entre crânio e face. E 26\n" +
                "ossos da coluna vertebral, 24 costelas, um osso esterno e um osso hioide).\n" +
                "• Esqueleto apendicular: formado pelos ossos dos membros superiores e in-\n" +
                "feriores.\n" +
                "\n"
        binding.img1.setImageResource(R.drawable.esqueletico1)
        binding.img2.setImageResource(R.drawable.esqueletico1)
    }
}
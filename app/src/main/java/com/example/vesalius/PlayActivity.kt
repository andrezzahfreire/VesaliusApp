package com.example.vesalius

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.vesalius.databinding.ActivityPlayBinding
import java.util.*
import java.util.concurrent.TimeUnit

class PlayActivity : AppCompatActivity() {
    private lateinit var activityPlayBinding: ActivityPlayBinding
    //    timer
    private var countDownTimer: CountDownTimer? = null
    private val countDownInMilliSecond: Long = 30000
    private val countDownInterval: Long = 1000
    private var timeLeftMilliSeconds: Long = 0
    private var defaultColor: ColorStateList? = null
    private var score = 0
    private var correct = 0
    private var wrong = 0
    private var skip = 0
    private var qIndex = 0
    private var updateQueNo = 1

    // create string for question, answer and options
    private var questoescardio = arrayOf(
        "Marque abaixo o item que melhor explica de que é formado o sistema circulatório?",
         "Marque abaixo a opção que descreve qual a função do coração",
        "Ao analisarmos a posição do coração no organismo, não podemos afir-\n" +
                "mar que:",
        "De que maneira o sangue proveniente da circulação sistêmica chega ao\n" +
                "coração? Marque a opção correta:",
        "Quais são as veias da circulação pós-fetal do corpo humano que carre-\n" +
                "gam sangue oxigenado. Marque a opção correta"

    )
    private var questoesnervo = arrayOf(
        "Analise as alternativas a seguir e marque aquela que NÃO descreve uma função do sistema nervoso.",
        "O sistema nervoso é dividido entre sistema nervoso central (SNC) e sistema nervoso periférico (SNP). Assinale a alternativa que contém os órgãos que fazem parte desses sistemas.",
        "São células MAIS DIFERENCIADAS e com MENOR capacidade de reprodução",
        "Qual dos seguintes comportamentos envolve maior número de órgãos do sistema nervoso?",
        "É comum ouvir expressões como: “Meu coração disparou”, “Fiquei tão nervoso que comecei a suar”, “Senti a boca seca”. Estas reações são características de um estado emocional alterado, e são controladas sob a ação do(s):"

    )
    private var questoesquet = arrayOf(
      "Os ossos são órgãos do corpo humano responsáveis por diversas funções, EXCETO:",
        "O corpo de um adulto é formado por 206 ossos, que podem ser classificados de acordo com o formato em 6 tipos principais: longos, curtos, planos, irregulares, sesamoides e suturais.\n" +
                "O fêmur é um osso que possui como principal característica a resistência e o fato de ser um osso",
        "As articulações são o ponto de encontro entre os ossos, pois realiza a conexão entre ossos e cartilagens. As articulações são classificadas pelo grau de mobilidade em",
        "Os ossos são órgãos do corpo humano responsáveis por diversas funções, EXCETO:",
        "O corpo de um adulto é formado por 206 ossos, que podem ser classificados de acordo com o formato em 6 tipos principais: longos, curtos, planos, irregulares, sesamoides e suturais.\n" +
                "O fêmur é um osso que possui como principal característica a resistência e o fato de ser um osso",

    )

    private var questoemusc = arrayOf(
        " Músculo responsável pelo fechamento das pálpebras e pelo fechamento\n" +
                "dos lábios\n",
        "No corpo humano existem 3 tipos de músculos, que são:",
        "Os músculos são classificados de várias formas, como:",
        "Quanto à disposição das fibras musculares, os músculos podem ser:",
        "Músculo em que seu cumprimento predomina sobre a largura e esta per-\n" +
                "manece mais ou menos constante em todo seu trajeto. Identifique a al-\n" +
                "ternativa correta.\n"
    )

    private var questoesfem = arrayOf(
       "Essas estruturas, além de serem responsáveis por dar origem aos óvulos, produzem os hormônios:",
        "O sistema reprodutor feminino é formado, além dos órgãos internos ao abdômen, por dois lábios maiores, dois lábios menores, clítoris e vestíbulo vaginal. Esses órgãos, situados externamente ao corpo da mulher, recebem o nome de:",
        "O ovócito secundário, após ser liberado no momento da ovulação, vai imediatamente para qual órgão do sistema genital feminino?",
        "O epidídimo tem a função de:",
        "Sobre a reprodução humana, todos os itens abaixo estão corretos, exceto:"
    )

    private var rescardio= arrayOf(
        " é formado pelo coração, vasos, sangue e linfa" ,
        "é responsável pela circulação do sangue\n" ,
        " está repousada sobre o diafragma;\n" ,
        " aorta" ,
        " veia porta;\n"
    )

    private var respnervo = arrayOf(
        "transportar de nutrientes e oxigênio para o corpo.",
        " SNC: encéfalo e medula espinhal; SNP: nervos e gânglios nervosos." ,
        "neurônios.",
        "Preencher uma ficha de identificação.",
        "nervos do cerebelo.",

    )
    private var respesq = arrayOf(
        "Reserva de vitaminas",
        "longo ",
        "sinartrose, anfiartrose e diartrose",
        "Reserva de vitaminas",
        "longo ",
    )
    private var respmusc = arrayOf(
        "Orbicular dos olhos e orbicular da boca.\n" ,
        "músculo estriado esquelético, músculo não estriado e músculo estriado cardíaco.\n",
        "quanto à situação, quanto ao movimento, quanto à forma, quanto à disposição das fibras, e quanto à função. \n",
        "Transverso, reto e oblíquo.\n",
        "Músculo largo.\n",
    )
    private var respfem = arrayOf(
        " estrógenos e progesterona.",
        " pudendo feminino.\n",
        "tuba uterina.\n",
        "armazenar espermatozóides.\n",
        "A fecundação ocorre no útero.\n",
    )


    private var opcardio = arrayOf(
        "        é formado pelo sangue e linfa" ,
                " é formado pelo coração, vasos, sangue e linfa" ,
                " é formado pelos vasos e coração" ,
                " é formado por sangue, coração e linfa",

                "é responsável pela circulação do sangue\n" ,
                "responsável pela distribuição de oxigênio\n" ,
                " responsável pelo bombeamento do sangue através do corpo\n" ,
                "responsável pelo transporte ativo e incessante de íons sódio e potássio\n",

                       " está repousada sobre o diafragma;\n" ,
                       " o ápice deste órgão aponta para cima, ligeiramente para a direita, entre os pulmões;\n" ,
                       " cerca de dois terços do órgão se encontra a esquerda do plano mediano;\n" ,
                       " é coberto ventralmente pelo esterno e cartilagens costais;\n" ,
                       " ocupa uma região denominada mediastino médio;\n",

                         " aorta" ,
                        " veias pulmonares" ,
                        " veias cavas" ,
                        " veias brônquicas" ,
                        " artéria pulmonar",

                         " veia porta;\n" ,
                         " veia cava superior;\n" ,
                         " veia cava inferior;\n" ,
                         " veias pulmonares;\n" ,
                         " veias ilíacas.\n"


    )
    private var opnervo = arrayOf(
      " captar e interpretar estímulos do ambiente" ,
              " transportar informações.",
              "criar respostas por meio de movimentos, sensações ou constatações." ,
              "transportar de nutrientes e oxigênio para o corpo.",

        " SNC: encéfalo e medula espinhal; SNP: nervos e gânglios nervosos." ,
                "SNC: cérebro e neurotransmissores SNP: tronco encefálico e raízes dorsais." ,
                "NC: nervos e gânglios nervosos; SNP: encéfalo e medula espinhal." ,
                "SNC: cérebro e cerebelo; SNP: diencéfalo e medula espinhal.",

        "neurônios.",
                " epiteliais de revestimento.",
                "hepatócitos.",
                "fibroblastos.",

        "Levantar a perna quando o médico toca com martelo no joelho do paciente.",
                " Piscar com a aproximação brusca de um objeto.",
                "Retirar bruscamente a mão ao tocar um objeto muito quente.",
                "Preencher uma ficha de identificação.",

        " sistema nervoso autônomo.",
                " sistema nervoso somático." ,
                "hormônios da tireoide." ,
                "nervos do cerebelo.",

    )
    private var opesq = arrayOf(
      " Sustentação do corpo",
              " Proteção de órgãos internos",
              "Apoio para realização dos movimentos",
              "Reserva de vitaminas",

        "irregular",
                "sesamoide",
                "longo ",
                "plano",

        "suspensoras, segmentares e anexas",
                "sinartrose, anfiartrose e diartrose",
                "fibrosas, musculares e nervosas",
                "longas, curtas e circulares",

        " Sustentação do corpo",
        " Proteção de órgãos internos",
        "Apoio para realização dos movimentos",
        "Reserva de vitaminas ",

        "irregular",
        "sesamoide",
        "longo ",
        "plano"


    )
    private var opmusc = arrayOf(
      "Auricular dos olhos e orbicular da boca.\n" ,
              "Orbicular dos olhos e orbicular da boca.\n" ,
              "Orbicular dos olhos e auricular da boca.\n" ,
              " Auricular dos olhos e auricular da boca.\n",

        "músculo estriado esquelético, músculo não estriado e músculo estriado cardíaco.\n",
                "músculo estriado simples, músculo não estriado e músculo estriado cardíaco\n",
                "músculo estriado composto, músculo não estriado e músculo estriado cardíaco \n",
                "músculo estriado esquelético, músculo não estriado e músculo estriado lateral\n",

        "quanto à situação, quanto ao movimento, quanto à forma, quanto à disposição das fibras, e quanto à função. \n",
                "quanto à ligação nervosa, quanto ao movimento, quanto à forma.\n",
                "quanto ao movimento, quanto à gelatina, quanto à disposição das fibras, e quanto à função.\n",
                "quanto à disposição das fibras, e quanto à função.\n",

        " Oblíquo, reto e reverso.\n",
                " Reto, reverso e transverso.\n",
                "Transverso, reto e oblíquo.\n",
                " Transverso, oblíquo e anverso.\n",

        "Músculo curto.\n",
                "Músculo largo.\n",
                " Músculo longo.\n",
                "Músculo chato.\n"


    )
    private var opfem = arrayOf(
      " insulina e glucagon.",
              "glucagon e testosterona.\n",
              " estrógenos e progesterona.",
              "ocitocina e calcitonina.\n",

        " vagina.\n",
                " pudendo feminino.\n",
                "sistema urinário feminino.\n",
                " hímen.\n",

        " vagina.\n",
                "ovário.\n",
                "útero\n",
                "tuba uterina.\n",

        "armazenar espermatozóides.\n",
                "produzir hormônio sexual masculino.\n",
                "produzir espermatozoides.\n",
                "produzir hormônios gonadotróficos.\n",

         "A fecundação ocorre no útero.\n",
                 "A espermatogênese ocorre nos testículos.\n" ,
                 " A placenta é responsável pela respiração e nutrição do embrião.\n" ,
                 "Na ovulação, rompe-se a parede do ovário e o ovócito é liberado na trompa de Falópio.\n"


    )

    private var questions = arrayOf(
        "Q.1. If a computer has more than one processor then it is known as?",
        "Q.2. Full form of URL is?",
        "Q.3. One kilobyte (KB) is equal to",
        "Q.4. Father of ‘C’ programming language?",
        "Q.5. SMPS stands for",
        "Q.6. What is a floppy disk used for",
        "Q.7. Which operating system is developed and used by Apple Inc?",
        "Q.8. Random Access Memory (RAM) is which storage of device?",
        "Q.9. Who is the founder of the Internet?",
        "Q.10. Which one is the first search engine in internet?")
    private var answer = arrayOf(
        "Multiprocessor",
        "Uniform Resource Locator",
        "1,024 bytes",
        "Dennis Ritchie",
        "Switched mode power supply",
        "To store information",
        "iOS",
        "Primay",
        "Tim Berners-Lee",
        "Archie")
    private var options = arrayOf(
        "Uniprocess",
        "Multiprocessor",
        "Multithreaded",
        "Multiprogramming",
        "Uniform Resource Locator",
        "Uniform Resource Linkwrong",
        "Uniform Registered Link",
        "Unified Resource Link",
        "1,000 bits",
        "1,024 bytes",
        "1,024 megabytes",
        "1,024 gigabytes",
        "Dennis Ritchie",
        "Prof Jhon Kemeny",
        "Thomas Kurtz",
        "Bill Gates",
        "Switched mode power supply",
        "Start mode power supply",
        "Store mode power supply",
        "Single mode power supply",
        "To unlock the computer",
        "To store information",
        "To erase the computer screen",
        "To make the printer work",
        "Windows",
        "Android",
        "iOS",
        "UNIX",
        "Primay",
        "Secondary",
        "Teriary",
        "Off line",
        "Vint Cerf",
        "Charles Babbage",
        "Tim Berners-Lee",
        "None of these",
        "Google",
        "Archie",
        "Altavista",
        "WAIS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlayBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(activityPlayBinding.root)
        initViews()
    }
    @SuppressLint("SetTextI18n")
    private fun showNextQuestion() {
        checkAnswer()
        activityPlayBinding.apply {
            if (updateQueNo < 10) {
                tvNoOfQues.text = "${updateQueNo + 1}/10"
                updateQueNo++
            }
            if (qIndex <= questions.size - 1) {
                tvQuestion.text = questions[qIndex]
                radioButton1.text = options[qIndex * 4] // 2*4=8
                radioButton2.text = options[qIndex * 4 + 1] //  2*4+1=9
                radioButton3.text = options[qIndex * 4 + 2] //  2*4+2=10
                radioButton4.text = options[qIndex * 4 + 3] //  2*4+3=11
            } else {
                score = correct
                val intent = Intent(this@PlayActivity, ResultActivity::class.java)
                intent.putExtra("correct", correct)
                intent.putExtra("wrong", wrong)
                intent.putExtra("skip", skip)
                startActivity(intent)
                finish()
            }
            radiogrp.clearCheck()
        }
    }
    @SuppressLint("SetTextI18n")

    private fun checkAnswer() {
        activityPlayBinding.apply {
            if (radiogrp.checkedRadioButtonId == -1) {
                skip++
               // timeOverAlertDialog()
            } else {
                val checkRadioButton =
                    findViewById<RadioButton>(radiogrp.checkedRadioButtonId)
                val checkAnswer = checkRadioButton.text.toString()
                if (checkAnswer == answer[qIndex]) {
                    correct++
                   // txtPlayScore.text = "Score : $correct"
                    correctAlertDialog()
                    countDownTimer?.cancel()
                } else {
                    wrong++
                    wrongAlertDialog()
                    countDownTimer?.cancel()
                }
            }
            qIndex++
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        activityPlayBinding.apply {
            var quest = intent.getStringExtra("sis")
            when (quest) {
                "esq" -> {
                    questions = questoesquet
                    options = opesq
                    answer = respesq
                }
                "cardio" -> {
                    questions = questoescardio
                    options = opcardio
                    answer = rescardio
                }
                "fem" -> {
                    questions = questoesfem
                    options = opfem
                    answer = respfem
                }
                "ner" -> {
                    questions = questoesnervo
                    options = opnervo
                    answer = respnervo
                }
                "musc" -> {
                    questions = questoemusc
                    options = opmusc
                    answer = respmusc
                }
                else -> {
                    Log.d("img", "Error")
                }
            }
            tvQuestion.text = questions[qIndex]
            radioButton1.text = options[0]
            radioButton2.text = options[1]
            radioButton3.text = options[2]
            radioButton4.text = options[3]
            // check options selected or not
            // if selected then selected option correct or wrong
            nextQuestionBtn.setOnClickListener {
                if (radiogrp.checkedRadioButtonId == -1) {
                    Toast.makeText(this@PlayActivity,
                        "Selecione uma das alternativas",
                        Toast.LENGTH_SHORT)
                        .show()
                } else {
                    showNextQuestion()
                }
            }
            tvNoOfQues.text = "$updateQueNo/5"
            tvQuestion.text = questions[qIndex]
           // defaultColor = quizTimer.textColors
            timeLeftMilliSeconds = countDownInMilliSecond
            //statCountDownTimer()

        }
    }

    private fun statCountDownTimer() {
        countDownTimer = object : CountDownTimer(timeLeftMilliSeconds, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                activityPlayBinding.apply {
                    timeLeftMilliSeconds = millisUntilFinished
                    val second = TimeUnit.MILLISECONDS.toSeconds(timeLeftMilliSeconds).toInt()
                    // %02d format the integer with 2 digit
                    val timer = String.format(Locale.getDefault(), "Time: %02d", second)
                    //quizTimer.text = timer
                    if (timeLeftMilliSeconds < 10000) {
                   //     quizTimer.setTextColor(Color.RED)
                    } else {
                  //      quizTimer.setTextColor(defaultColor)
                    }
                }
            }
            override fun onFinish() {
                showNextQuestion()
            }
        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun correctAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.correct_answer, null)
        builder.setView(view)
        val tvScore = view.findViewById<TextView>(R.id.tvDialog_score)
        val correctOkBtn = view.findViewById<Button>(R.id.correct_ok)
        tvScore.text = "Resposta correta"
        val alertDialog = builder.create()
        correctOkBtn.setOnClickListener {
           // timeLeftMilliSeconds = countDownInMilliSecond
            //statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun wrongAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.wrong_answer, null)
        builder.setView(view)
        val tvWrongDialogCorrectAns = view.findViewById<TextView>(R.id.tv_wrongDialog_correctAns)
        val wrongOk = view.findViewById<Button>(R.id.wrong_ok)
        tvWrongDialogCorrectAns.text = "Resposta certa : " + answer[qIndex]
        val alertDialog = builder.create()
        wrongOk.setOnClickListener {
           // timeLeftMilliSeconds =
            //    countDownInMilliSecond
          //  statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun timeOverAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.time_over, null)
        builder.setView(view)
        val timeOverOk = view.findViewById<Button>(R.id.timeOver_ok)
        val alertDialog = builder.create()
        timeOverOk.setOnClickListener {
           // timeLeftMilliSeconds = countDownInMilliSecond
            //statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}


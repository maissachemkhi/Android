package tn.esprit.color_mixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.color_mixer.databinding.ActivityAnswerBinding
import android.os.Bundle
import android.widget.Toast

class AnswerActivity : AppCompatActivity() {

    //TODO 12 Add lateint var for binding
    private lateinit var binding:ActivityAnswerBinding


    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 13 Bind the view and implement setContentView()
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        correctColor = intent.getStringExtra(MIXED_COLOR).toString()
        name = intent.getStringExtra(NAME).toString()
        color1 = intent.getStringExtra(COLOR1).toString()
        color2 = intent.getStringExtra(COLOR2).toString()
        //TODO 15 Change the txtChoosed with : "You chose $color1 and $color2"
        binding.txtChoosed.text = "You chose $color1 and $color2"
        //TODO 16 Implement setOnClickListener on the btnSubmit and call checkAnswer()
        // You must check if only one radio button is selected the navigate to the ResultActivity with the data name and RESULT (FAILED/SUCCESS)
        binding.btnSubmit.setOnClickListener {
            var result =checkAnswer()
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(RESULT, result)
            intent.putExtra(NAME,name)
            startActivity(intent)
        }
    }

    private fun checkAnswer(): Boolean{

        //TODO 17 Check if the answer of the chosen color is correct
        if(binding.rbGreen.isChecked){
            return correctColor == GREEN
        }
        else if(binding.rbOrange.isChecked){
            return correctColor == ORANGE
        }
        else if(binding.rbPurple.isChecked){
            return correctColor == PURPLE
        }
        return false
    }
}
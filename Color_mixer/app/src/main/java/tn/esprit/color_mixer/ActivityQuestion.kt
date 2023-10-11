package tn.esprit.color_mixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.material.snackbar.Snackbar
import tn.esprit.color_mixer.databinding.ActivityQuestionBinding


//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE
val RED = "RED"
val BLUE = "BLUE"
val YELLOW = "YELLOW"
val PURPLE = "PURPLE"
val GREEN = "GREEN"
val ORANGE = "ORANGE"
//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED
val NAME = "NAME"
val MIXED_COLOR = "MIXED_COLOR"
val COLOR1 = "COLOR1"
val COLOR2 = "COLOR2"
val RESULT = "RESULT"
val SUCCESS = "SUCCESS"
val FAILED = "FAILED"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    private lateinit var binding:ActivityQuestionBinding
    //TODO 5 Add var for colorMixed / color1 / color2 / name
    var colorMixed:String = ""
    var color1:String = ""
    var color2:String = ""
    var name:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        binding.btnMix.setOnClickListener {
            mixColor()
        }
    }

    private fun mixColor(){

        //TODO 8 Check if the input for FullName. IF it's empty show a snackbar with the message : You must enter your name !
        if(binding.tfFullName.text.toString().isEmpty()){
            Snackbar.make(binding.contextView, "You must enter your name !", Snackbar.LENGTH_SHORT).show()
            return
        }
        //TODO 9 Check if Only 2 colors are selected then change the value of  colorMixed / color1 / color2
        if (binding.cbBlue.isChecked && binding.cbRed.isChecked && binding.cbYellow.isChecked){
            Snackbar.make(binding.contextView, "You must choose 2 colors !", Snackbar.LENGTH_SHORT).show()
            return
        }else if (binding.cbBlue.isChecked && binding.cbRed.isChecked){
            colorMixed = PURPLE
            color1 = BLUE
            color2 = RED
        }else if (binding.cbBlue.isChecked && binding.cbYellow.isChecked){
            colorMixed = GREEN
            color1 = BLUE
            color2 = YELLOW
        }else if (binding.cbYellow.isChecked && binding.cbRed.isChecked){
            colorMixed = ORANGE
            color1 = YELLOW
            color2 = RED
        }else{
            Snackbar.make(binding.contextView,"You must choose 2 colors !", Snackbar.LENGTH_SHORT).show()
            return
        }
            //TODO 10 Change the value of name with the input
            name = binding.tfFullName.text.toString()
            //TODO 11 Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2 Then start the Activity
          //  var intent = Intent(this, AnswerActivity::class.java)
        val intent = Intent(this, AnswerActivity::class.java).apply {
            putExtra(NAME, name)
            putExtra(MIXED_COLOR, colorMixed)
            putExtra(COLOR1, color1)
            putExtra(COLOR2, color2)
        }

        startActivity(intent)
    }
}
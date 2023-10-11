package tn.esprit.color_mixer

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import tn.esprit.color_mixer.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    //TODO 18 Add lateint var for binding
    private lateinit var binding:ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 19 Bind the view and implement setContentView()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 20 Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        var result:Boolean= intent.getBooleanExtra(RESULT,false)
        var name:String = intent.getStringExtra(NAME).toString()
        binding.txtName.text = result.toString()
        if(result){
            binding.rlBackground.setBackgroundColor(getResources().getColor(R.color.success))
            binding.imgResult.setImageResource(R.drawable.ic_success)
            binding.txtResult.text = SUCCESS
            binding.txtName.text = "Congratulation $name !"
            binding.txtAnswer.text = "Your answer is correct !"
            binding.btnQuit.setBackgroundColor(getResources().getColor(R.color.success))
        }
        else{
            binding.rlBackground.setBackgroundColor(getResources().getColor(R.color.error))
            binding.imgResult.setImageResource(R.drawable.ic_failure)
            binding.txtResult.text = "WRONG"
            binding.txtName.text = "Sorry $name !"
            binding.txtAnswer.text = "Your answer is wrong !"
            binding.btnQuit.setBackgroundColor(getResources().getColor(R.color.error))
        }
        //TODO 21 Implement setOnClickListener for btnQuit to destroy the activity
        val intent = Intent(this,QuestionActivity::class.java)

        binding.btnQuit.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }
}
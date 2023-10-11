package tn.esprit.nascar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import tn.esprit.nascar.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 11 Bind the toolbar to the activity
        val toolbar: Toolbar = binding.toolbar.appBar
        setSupportActionBar(toolbar)

        //TODO 1 Implement the click on the 3 buttons (btnNews|btnEvents|btnProfile) to call changeFragment(...)
        binding.btnNews.setOnClickListener {
            val fragment = NewsFragment()
            changeFragment(fragment, "news")
        }
        binding.btnEvents.setOnClickListener {
            val fragment = EventsFragment()
            changeFragment(fragment, "events")
        }

        binding.btnProfile.setOnClickListener {
            val fragment = ProfileFragment()
            changeFragment(fragment, "profile")
        }

        //TODO 2 Implement the first call of the first fragment
        val initialFragment = NewsFragment()
        changeFragment(initialFragment, "news")
    }

    private fun changeFragment(fragment: Fragment, tag: String) {

        //TODO 3 Check if tag is empty then replace the new fragment in the activity.
        //    If tag is not empty replace the new fragment in the activity and use addToBackStack
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)

        if (tag.isNotEmpty()) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    //TODO 12 Override the method onCreateOptionsMenu()
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //TODO 13 Override the method onOptionsItemSelected() and Implement info and logout behavior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.infoMenu -> {
                changeFragment(AboutFragment(),"AboutMe")
            }
            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("Are you sure you want to logout ?")
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
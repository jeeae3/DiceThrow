package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]

        dieViewModel.setSides(20)



        //remove fragment container name from activity_main
        //adding by code
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)==null){
            //val dieFragment = DieFragment.newInstance(20)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment())
                .commit()
        }


        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieViewModel.rollDie()
        }
    }

}
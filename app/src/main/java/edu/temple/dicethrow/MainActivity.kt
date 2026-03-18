package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainerView,
                    DieFragment().apply {
                        arguments = Bundle().apply {
                            putInt(DIESIDE, 6)
                        }
                    }
                )
                .replace(
                    R.id.fragmentContainerView2,
                    DieFragment().apply {
                        arguments = Bundle().apply {
                            putInt(DIESIDE, 20)
                        }
                    }
                )
                .commit()
        }
        val rollButton = findViewById<Button>(R.id.rollDiceButton)
        rollButton.text = getString(R.string.roll)

        rollButton.setOnClickListener {
            val dieFragment = supportFragmentManager.findFragmentById(
                R.id.fragmentContainerView
            ) as? DieFragment
            dieFragment?.throwDie()

            val dieFragment2 = supportFragmentManager.findFragmentById(
                R.id.fragmentContainerView2
            ) as? DieFragment
            dieFragment2?.throwDie()

        }
    }
}
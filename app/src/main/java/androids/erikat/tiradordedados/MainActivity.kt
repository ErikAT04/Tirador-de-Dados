package androids.erikat.tiradordedados

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val dado = Dado()
        val throwBtt:Button = findViewById(R.id.throwBtt)
        val textView:TextView = findViewById(R.id.diceText)
        val diceImg:ImageView = findViewById(R.id.diceView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        throwBtt.setOnClickListener {
            var numberThrown = dado.tirarDado()
            if (numberThrown in (1..6)){
                var id:Int = resources.getIdentifier("@drawable/dice_$numberThrown", null, packageName) //Busco el id del dado tirado en Drawable
                diceImg.setImageResource(id)
            } else {
                diceImg.setImageResource(R.drawable.dice_target)
            }
            textView.setText("Ha salido el número $numberThrown")
        }
    }
}
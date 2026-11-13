import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class ConsejosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consejos)

        val faltaAgua = intent.getBooleanExtra("FALTA_AGUA", false)
        val faltaFisica = intent.getBooleanExtra("FALTA_FISICA", false)
        val faltaSueno = intent.getBooleanExtra("FALTA_SUENO", false)

        if (faltaAgua) findViewById<TextView>(R.id.tvConsejoAgua).visibility = View.VISIBLE
        if (faltaFisica) findViewById<TextView>(R.id.tvConsejoFisica).visibility = View.VISIBLE
        if (faltaSueno) findViewById<TextView>(R.id.tvConsejoSueno).visibility = View.VISIBLE
    }
}
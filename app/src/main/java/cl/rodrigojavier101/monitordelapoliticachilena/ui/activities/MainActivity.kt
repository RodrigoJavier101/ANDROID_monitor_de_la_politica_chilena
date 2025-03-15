package cl.rodrigojavier101.monitordelapoliticachilena.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.tooling.preview.Preview
import cl.rodrigojavier101.monitordelapoliticachilena.databinding.ActivityMainBinding
import cl.rodrigojavier101.monitordelapoliticachilena.ui.theme.MonitorDeLaPoliticaChilenaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}



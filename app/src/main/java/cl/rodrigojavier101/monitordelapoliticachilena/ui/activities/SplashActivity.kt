package cl.rodrigojavier101.monitordelapoliticachilena.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import cl.antoinette.monitor_politico_econmico.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.jvm.java

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: cl.antoinette.monitor_politico_econmico.databinding.ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        binding = cl.antoinette.monitor_politico_econmico.databinding.ActivitySplashBinding.inflate(
            layoutInflater
        )
        setContentView(cl.antoinette.monitor_politico_econmico.databinding.ActivitySplashBinding.getRoot)
        lifecycleScope.launch {
            delay(2000)
            intent = Intent(
                this@SplashActivity,
                cl.antoinette.monitor_politico_econmico.ui.activities.MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}
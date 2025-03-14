package cl.rodrigojavier101.monitordelapoliticachilena.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import cl.rodrigojavier101.monitordelapoliticachilena.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    @SuppressLint("UnsafeIntentLaunch")
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            delay(2000)
            intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.app.AppCompatDelegate
//import androidx.lifecycle.lifecycleScope
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//@SuppressLint("CustomSplashScreen")
//class SplashActivity : AppCompatActivity() {
//
//    private lateinit var binding:cl.rodrigojavier101.monitordelapoliticachilena.databinding.ActivitySplashBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        super.onCreate(savedInstanceState)
//        binding = cl.rodrigojavier101.monitordelapoliticachilena.databinding.ActivitySplashBinding.inflate(
//            layoutInflater
//        )
//        //setContentView(cl.rodrigojavier101.monitordelapoliticachilena.databinding.ActivitySplashBinding.getRoot)
//        setContentView(binding.root)
//        lifecycleScope.launch {
//            delay(2000)
//            intent = Intent(
//                this@SplashActivity,
//                MainActivity::class.java
//            )
//            startActivity(intent)
//            finish()
//        }
//    }
//}
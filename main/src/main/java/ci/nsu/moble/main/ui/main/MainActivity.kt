package ci.nsu.moble.main.ui.main

import ci.nsu.moble.main.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка BottomNavigationView и NavController
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment?.findNavController()
        if (navController != null) {
            bottomNav.setupWithNavController(navController)
        }

        // Кнопка перехода во вторую Activity
        val btnGo: Button = findViewById(R.id.btnGoToSecondActivity)
        btnGo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("DATA", "Привет из MainActivity!")
            startActivity(intent)
        }
    }
}
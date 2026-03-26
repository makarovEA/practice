package ci.nsu.moble.main.ui.main

import ci.nsu.moble.main.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Настройка Toolbar как ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Второй экран"

        // Получение переданных данных
        val receivedData = intent.getStringExtra("DATA") ?: "Нет данных"
        val tvData: TextView = findViewById(R.id.tvReceivedData)
        tvData.text = "Получено: $receivedData"
    }

    // Обработка нажатия кнопки "Назад" в ActionBar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Закрываем текущую Activity, возвращаясь в MainActivity
        return true
    }
}
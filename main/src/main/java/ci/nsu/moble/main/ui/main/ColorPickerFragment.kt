package ci.nsu.moble.main.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ci.nsu.moble.main.R

class ColorPickerFragment : Fragment() {

    // Структура данных: название цвета -> целое значение цвета
    private val colorMap = mapOf(
        "красный" to Color.RED,
        "зеленый" to Color.GREEN,
        "синий" to Color.BLUE,
        "желтый" to Color.YELLOW,
        "черный" to Color.BLACK,
        "белый" to Color.WHITE,
        "серый" to Color.GRAY,
        "пурпурный" to Color.MAGENTA,
        "голубой" to Color.CYAN,
        "коричневый" to Color.rgb(150,75,0),
        "cеробуромалиновый" to Color.rgb(115, 81, 132)
    )

    private lateinit var etColorName: EditText
    private lateinit var btnApply: Button
    private lateinit var rvPalette: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color_picker, container, false)
        etColorName = view.findViewById(R.id.etColorName)
        btnApply = view.findViewById(R.id.btnApplyColor)
        rvPalette = view.findViewById(R.id.rvPalette)

        // Настройка RecyclerView для палитры
        val adapter = ColorPaletteAdapter(colorMap)
        rvPalette.adapter = adapter

        // Обработка нажатия кнопки
        btnApply.setOnClickListener {
            val inputColorName = etColorName.text.toString().trim().lowercase()
            if (inputColorName.isNotEmpty()) {
                val foundColor = colorMap[inputColorName]
                if (foundColor != null) {
                    // Цвет найден – меняем фон кнопки
                    btnApply.setBackgroundColor(foundColor)
                } else {
                    // Цвет не найден – логируем и оставляем кнопку без изменений
                    Log.d("ColorPicker", "Пользовательский цвет \"$inputColorName\" не найден")
                }
            }
        }

        return view
    }
}
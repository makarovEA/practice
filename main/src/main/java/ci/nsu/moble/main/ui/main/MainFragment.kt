import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import ci.nsu.moble.main.R
import ci.nsu.moble.main.MainActivity

class MainFragment : Fragment() {
 companion object {
     fun newInstance() = MainFragment()
 }
    private lateinit var editTextColor: EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инфлейтим макет фрагмента
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // Находим View по ID
        editTextColor = view.findViewById(R.id.editTextColor)
        button = view.findViewById(R.id.buttonChangeColor)

        // Устанавливаем обработчик нажатия
        button.setOnClickListener {
            val colorText = editTextColor.text.toString().trim()

            if (colorText.isNotEmpty()) {
                try {
                    val color = Color.parseColor(colorText)
                    button.setBackgroundColor(color)
                } catch (e: IllegalArgumentException) {
                    Toast.makeText(requireContext(), "Некорректное название цвета", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Введите название цвета", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Инициализация View и логики здесь
    }
}
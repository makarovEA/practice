package ci.nsu.moble.main.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ci.nsu.moble.main.R

class ColorPaletteAdapter(private val colors: Map<String, Int>) :
    RecyclerView.Adapter<ColorPaletteAdapter.ColorViewHolder>() {

    // Преобразуем Map в список для удобства работы
    private val colorList = colors.toList()

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewColor: View = itemView.findViewById(R.id.viewColor)
        private val tvColorName: TextView = itemView.findViewById(R.id.tvColorName)

        fun bind(colorName: String, colorInt: Int) {
            tvColorName.text = colorName
            viewColor.setBackgroundColor(colorInt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_color, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val (name, colorInt) = colorList[position]
        holder.bind(name, colorInt)
    }

    override fun getItemCount() = colorList.size
}
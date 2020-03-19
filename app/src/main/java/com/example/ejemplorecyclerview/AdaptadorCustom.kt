package com.example.ejemplorecyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(items:ArrayList<Platillo>):RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista) {
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var precio:TextView? = null
        var rating:RatingBar? = null

        init {
            this.foto = vista.findViewById(R.id.ivFoto)
            this.nombre = vista.findViewById(R.id.tvNombre)
            this.precio = vista.findViewById(R.id.tvPrecio)
            this.rating = vista.findViewById(R.id.tvRating)
        }
    }
}
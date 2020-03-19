package com.example.ejemplorecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(var contexto:Context, items:ArrayList<Platillo>):RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var items: ArrayList<Platillo>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.template_platillo, parent, false)
        val viewHolder = ViewHolder(vista)

        return  viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre
        holder.precio?.text = item?.precio.toString()
        holder.rating?.rating = item?.rating!!
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
package com.example.ejemplorecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(items:ArrayList<Platillo>, var listener: ClickListener, var longClickListener:LongClickListener):RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var items: ArrayList<Platillo>? = null
    var multiSeleccion = false

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_platillo, parent, false)
        val viewHolder = ViewHolder(vista, listener, longClickListener)

        return  viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre
        holder.precio?.text = "$${item?.precio.toString()}"
        holder.rating?.rating = item?.rating!!
    }

    fun inicialActionMode() {
        multiSeleccion = true
    }

    fun destruirActionMode() {
        multiSeleccion = false
        notifyDataSetChanged()
    }

    fun terminarActionMode() {
        multiSeleccion = false
    }

    class ViewHolder(vista:View, listener: ClickListener, longListener: LongClickListener):RecyclerView.ViewHolder(vista), View.OnClickListener, View.OnLongClickListener {
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var precio:TextView? = null
        var rating:RatingBar? = null
        var listener:ClickListener? = null
        var longListener:LongClickListener? = null

        init {
            this.foto = vista.findViewById(R.id.ivFoto)
            this.nombre = vista.findViewById(R.id.tvNombre)
            this.precio = vista.findViewById(R.id.tvPrecio)
            this.rating = vista.findViewById(R.id.tvRating)
            this.listener = listener
            this.longListener = longListener

            vista.setOnClickListener(this)
            vista.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onCLick(v!!, adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            this.longListener?.longClick(v!!, adapterPosition)
            return true
        }
    }
}
package com.example.ejemplorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var lista:RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platillos = ArrayList<Platillo>()
        platillos.add(Platillo("Platillo 01", 250.0, 3.5f, R.drawable.foto_01))
        platillos.add(Platillo("Platillo 02", 250.0, 3.5f, R.drawable.foto_02))
        platillos.add(Platillo("Platillo 03", 250.0, 3.5f, R.drawable.foto_03))
        platillos.add(Platillo("Platillo 04", 250.0, 3.5f, R.drawable.foto_04))
        platillos.add(Platillo("Platillo 05", 250.0, 3.5f, R.drawable.foto_05))
        platillos.add(Platillo("Platillo 06", 250.0, 3.5f, R.drawable.foto_06))
        platillos.add(Platillo("Platillo 07", 250.0, 3.5f, R.drawable.foto_07))
        platillos.add(Platillo("Platillo 08", 250.0, 3.5f, R.drawable.foto_08))
        platillos.add(Platillo("Platillo 09", 250.0, 3.5f, R.drawable.foto_09))
        platillos.add(Platillo("Platillo 10", 250.0, 3.5f, R.drawable.foto_10))

        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

        adaptador = AdaptadorCustom(platillos, object:ClickListener{
            override fun onCLick(vista: View, index: Int) {
                Toast.makeText(applicationContext!!, platillos[index].nombre.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        lista?.adapter = adaptador
    }
}

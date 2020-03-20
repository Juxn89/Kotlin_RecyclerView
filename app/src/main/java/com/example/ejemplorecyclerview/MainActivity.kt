package com.example.ejemplorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    var lista:RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null

    var isActionMode = false

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

        val callBack = object:androidx.appcompat.view.ActionMode.Callback {
            override fun onActionItemClicked(mode: androidx.appcompat.view.ActionMode?, item: MenuItem?): Boolean {
                adaptador?.terminarActionMode()
                mode?.finish()
                isActionMode = false
                return  true
            }

            override fun onCreateActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
                adaptador?.inicialActionMode()
                return true
            }

            override fun onPrepareActionMode(mode: androidx.appcompat.view.ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
                adaptador?.destruirActionMode()
                isActionMode = false
            }
        }

        adaptador = AdaptadorCustom(platillos, object:ClickListener{
            override fun onCLick(vista: View, index: Int) {
                Toast.makeText(applicationContext!!, platillos[index].nombre.toString(), Toast.LENGTH_SHORT).show()
            }
        }, object:LongClickListener {
            override fun longClick(vista: View, index: Int) {
                if (!isActionMode) {
                    startSupportActionMode(callBack)
                    isActionMode = true
                } else {

                }
            }
        })

        lista?.adapter = adaptador

        val swipeToRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        swipeToRefresh.setOnRefreshListener {
            for (i in 1..1000000000) { }

            swipeToRefresh.isRefreshing = false
            platillos.add(Platillo("Platillo 11", 250.0, 3.5f, R.drawable.foto_01))
            adaptador?.notifyDataSetChanged()
        }
    }
}

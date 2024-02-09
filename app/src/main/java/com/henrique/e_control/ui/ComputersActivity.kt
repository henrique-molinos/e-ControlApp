package com.henrique.e_control.ui

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrique.e_control.R
import com.henrique.e_control.data.ComputerFactory
import com.henrique.e_control.domain.Computador
import com.henrique.e_control.ui.adapter.ComputerAdapter

class ComputersActivity : AppCompatActivity() {
    private lateinit var compRecyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.computers_activity)

        setupViews()
        setupList(ComputerFactory.list)
        // TODO -> Fazer com que os dados recebidos do Firebase sejam passados no setupList()
    }

    fun setupViews() {
        compRecyclerView = findViewById(R.id.rv_lista_computadores)
        compRecyclerView.layoutManager = LinearLayoutManager(this)
        compRecyclerView.setHasFixedSize(true)

        progressBar = findViewById(R.id.pb_loader)
    }

    fun setupList(lista: List<Computador>) {
        val computerAdapter = ComputerAdapter(lista)
        compRecyclerView.apply {
            adapter = computerAdapter
            isVisible = true
        }
    }

}
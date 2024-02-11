package com.henrique.e_control.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrique.e_control.R
import com.henrique.e_control.data.CustomerFactory
import com.henrique.e_control.domain.Cliente
import com.henrique.e_control.ui.adapter.ComputerAdapter
import com.henrique.e_control.ui.adapter.CustomerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var customerRecyclerView: RecyclerView
    private lateinit var customerList: List<Cliente>
    private lateinit var progressBar: ProgressBar
    private lateinit var btnCadastrar: Button
    private lateinit var btnConsultar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customerList = CustomerFactory.list

        setupView()
        setupFactory()
        setupListeners()
    }

    private fun setupView() {
        customerRecyclerView = findViewById(R.id.rv_lista_clientes)
        customerRecyclerView.layoutManager = GridLayoutManager(this, 2)

        progressBar = findViewById(R.id.pb_main_loader)
        btnCadastrar = findViewById(R.id.btn_act_cadastrar)
        btnConsultar = findViewById(R.id.btn_act_consultar)
    }

    private fun setupFactory() {
        val mAdapter =  CustomerAdapter(customerList)
        customerRecyclerView.adapter = mAdapter

        customerRecyclerView.visibility = View.VISIBLE
    }

    private fun setupListeners() {
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, NewRegisterActivity::class.java)
            startActivity(intent)
        }

        btnConsultar.setOnClickListener {
            val intent = Intent(this, ComputersActivity::class.java)
            startActivity(intent)
        }


//        mAdapter.setOnClickListener(object : CustomerAdapter.OnItemClickListener {
//            override fun onItemClick(position: Int) {
//                // Colocar dados extas
//                intent.putExtra("idComp", customerList[position].idCliente)
//                intent.putExtra("nomeComp", customerList[position].nomeCliente)
//                intent.putExtra("ipComp", customerList[position].logo)
//            }
//        })
    }

    fun getCustomersData() {
        customerRecyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE


    }

}
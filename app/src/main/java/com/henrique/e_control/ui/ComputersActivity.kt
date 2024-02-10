package com.henrique.e_control.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.henrique.e_control.R
import com.henrique.e_control.data.ComputerFactory
import com.henrique.e_control.domain.Computador
import com.henrique.e_control.ui.adapter.ComputerAdapter

class ComputersActivity : AppCompatActivity() {
    private lateinit var compRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var compList: ArrayList<Computador>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computers)

        setupViews()
    }

    private fun setupViews() {
        compRecyclerView = findViewById(R.id.rv_lista_computadores)
        compRecyclerView.layoutManager = GridLayoutManager(this, 3)
        compRecyclerView.setHasFixedSize(true)

        compRecyclerView.setOnClickListener {

        }

        progressBar = findViewById(R.id.pb_loader)

        compList = arrayListOf<Computador>()

        getComputersData()
    }

    private fun getComputersData() {
        // Alterando visibilidade das Views
        compRecyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        // Instanciando referência no BD
        dbRef = FirebaseDatabase.getInstance().getReference("Computadores")

        // Criando um listener para o evento de valor
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                compList.clear()
                // Se os dados existirem
                if (snapshot.exists()) {
                    for (compSnap in snapshot.children) {
                        val compData = compSnap.getValue(Computador::class.java)
                        compList.add(compData!!)
                    }
                    // Preenchimento dos dados na RV
                    val mAdapter = ComputerAdapter(compList)
                    compRecyclerView.adapter = mAdapter

                    // Implementando o ClickListener dos itens da RV
                    mAdapter.setOnClickListener(object : ComputerAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@ComputersActivity, ComputerDetailsActivity::class.java)

                            // Colocar dados extas
//                            intent.putExtra("idComp", compList[position].idComp)
                            intent.putExtra("nomeComp", compList[position].nomeComp)
                            intent.putExtra("ipComp", compList[position].ipComp)
                            intent.putExtra("versaoEconect", compList[position].versaoEconect)
                            // Iniciando a Activity
                            startActivity(intent)
                        }

                    })

                    compRecyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
package com.henrique.e_control.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.henrique.e_control.R
import com.henrique.e_control.domain.Computador

class ComputerAdapter(private val compList: List<Computador>) : RecyclerView.Adapter<ComputerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.computer_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = compList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nome.text = compList[position].nomeComp
        holder.ip.text = compList[position].ipComp
        holder.versaoEconect.text = compList[position].versaoEconect
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView
        val ip: TextView
        val versaoEconect: TextView

        init {
            view.apply {
                nome = findViewById(R.id.tv_nome_computador)
                ip = findViewById(R.id.tv_ip_computador)
                versaoEconect = findViewById(R.id.tv_versao_econect)
            }
        }
    }

}
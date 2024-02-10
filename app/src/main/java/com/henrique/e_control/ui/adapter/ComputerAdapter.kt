package com.henrique.e_control.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.henrique.e_control.R
import com.henrique.e_control.domain.Computador

class ComputerAdapter(private val compList: ArrayList<Computador>) : RecyclerView.Adapter<ComputerAdapter.ViewHolder>() {

    // Criação de variável do tipo da interface criada abaixo
    private lateinit var mListener: OnItemClickListener

    // Criação da interface que será utilizada para o Listener do clique
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Criação da função que gerará o Listener do clique
    fun setOnClickListener(clickListener: OnItemClickListener) {
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.computer_item, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNomeComp.text = compList[position].nomeComp
        holder.tvIpComp.text = compList[position].ipComp
        holder.tvVersaoEconect.text = compList[position].versaoEconect
    }

    override fun getItemCount(): Int = compList.size

    class ViewHolder(itemView: View, clickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val tvNomeComp: TextView
        val tvIpComp: TextView
        val tvVersaoEconect: TextView

        init {
            itemView.apply {
                tvNomeComp = findViewById(R.id.tv_nome_computador)
                tvIpComp = findViewById(R.id.tv_ip_computador)
                tvVersaoEconect = findViewById(R.id.tv_versao_econect)
            }
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

}
package com.henrique.e_control.ui.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.henrique.e_control.R
import com.henrique.e_control.domain.Cliente

class CustomerAdapter(private val customerList: List<Cliente>) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    // Criação de variável do tipo da interface criada abaixo
//    private lateinit var mListener: OnItemClickListener

    // Criação da interface que será utilizada para o Listener do clique
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Criação da função que gerará o Listener do clique
    fun setOnClickListener(clickListener: OnItemClickListener) {
//        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.customer_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = customerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nomeCliente.text = customerList[position].nomeCliente
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeCliente: TextView

        init {
            itemView.apply {
                nomeCliente = findViewById(R.id.tv_nome_cliente)
            }
            itemView.setOnClickListener {
//                TODO -> Implementar listener do cliente
            }
        }
    }
}
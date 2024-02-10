package com.henrique.e_control.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.henrique.e_control.R

class ComputerDetailsActivity : AppCompatActivity() {

    private lateinit var tvCompName: TextView
    private lateinit var tvCompIp: TextView
    private lateinit var tvEconectVersion: TextView
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_details)

        setupView()
        setupValues()
    }

    private fun setupView() {
        tvCompName = findViewById(R.id.tv_det_nome_computador)
        tvCompIp = findViewById(R.id.tv_det_ip_computador)
        tvEconectVersion = findViewById(R.id.tv_det_versao_econect)
        btnUpdate = findViewById(R.id.btn_atualizar)

    }

    private fun setupValues() {
        tvCompName.text = intent.getStringExtra("nomeComp")
        tvCompIp.text = intent.getStringExtra("ipComp")
        tvEconectVersion.text = intent.getStringExtra("versaoEconect")
    }

}
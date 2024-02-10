package com.henrique.e_control.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.henrique.e_control.R
import com.henrique.e_control.domain.Computador

class ComputerDetailsActivity : AppCompatActivity() {

    // Declaração de variáveis
    private lateinit var tvCompName: TextView
    private lateinit var tvCompIp: TextView
    private lateinit var tvEconectVersion: TextView
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_details)

        setupView()
        setupValues()

        // Criação do ClickListener do botão "Atualizar dados"
        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("idComp").toString(),
                intent.getStringExtra("nomeComp").toString()
            )
        }
    }

    // Função que localiza as Views
    private fun setupView() {
        tvCompName = findViewById(R.id.tv_det_nome_computador)
        tvCompIp = findViewById(R.id.tv_det_ip_computador)
        tvEconectVersion = findViewById(R.id.tv_det_versao_econect)
        btnUpdate = findViewById(R.id.btn_det_atualizar)

    }

    // Função que preenche os valores das EditTexts
    private fun setupValues() {
        tvCompName.text = intent.getStringExtra("nomeComp")
        tvCompIp.text = intent.getStringExtra("ipComp")
        tvEconectVersion.text = intent.getStringExtra("versaoEconect")
    }

    // Criando função que infla um layout no formato de diálogo pop-up "update_dialog"
    private fun openUpdateDialog(idComp: String, nomeComp: String) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_dialog, null)

        mDialog.setView(mDialogView)

        // Identificando Views
        val etCompName = mDialogView.findViewById<EditText>(R.id.et_upd_nome_computador)
        val etCompIp = mDialogView.findViewById<EditText>(R.id.et_upd_ip_computador)
        val etEconectVersion = mDialogView.findViewById<EditText>(R.id.et_upd_versao_econect)
        val btnUpdAtualizar = mDialogView.findViewById<Button>(R.id.btn_upd_atualizar)

        // Populando as informações atuais nas EditTexts
        etCompName.setText(intent.getStringExtra("nomeComp").toString())
        etCompIp.setText(intent.getStringExtra("ipComp").toString())
        etEconectVersion.setText(intent.getStringExtra("versaoEconect").toString())

        // Informando o usuário sobre a atualização
        mDialog.setTitle("Atualizando $nomeComp")

        val alertDialog = mDialog.create()
        alertDialog.show()

        // Criando o ClickListener do botão "Atualizar"
        btnUpdAtualizar.setOnClickListener {
            updateCompData(
                idComp,
                etCompName.text.toString(),
                etCompIp.text.toString(),
                etEconectVersion.text.toString()
            )

            // Notificando o usuário sobre a atualização dos dados
            Toast.makeText(
                applicationContext,
                "Dados atualizados",
                Toast.LENGTH_LONG).show()

            // Aplicando os valores atualizados para as TVs
            tvCompName.text = etCompName.text.toString()
            tvCompIp.text = etCompIp.text.toString()
            tvEconectVersion.text = etEconectVersion.text.toString()

            alertDialog.dismiss()
        }
    }

    // Criação da função que realiza a atualização dos dados no RTDB
    private fun updateCompData(id: String, name: String, ip: String, econectVersion: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Computadores").child(id)
        val compInfo = Computador(id, name, ip, econectVersion)
        dbRef.setValue(compInfo)
    }

}
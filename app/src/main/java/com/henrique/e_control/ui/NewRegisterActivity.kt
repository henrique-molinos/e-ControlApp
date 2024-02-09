package com.henrique.e_control.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.henrique.e_control.R
import com.henrique.e_control.domain.Computador

class NewRegisterActivity : AppCompatActivity() {

    // Declaração de variáveis

    private lateinit var etNomeComputador: EditText
    private lateinit var etIpComputador: EditText
    private lateinit var etVersaoAplicacao: EditText
    private lateinit var btnCadastrar: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_register)  // Chamada do layout da activity

        // Atribuição das Views
        etNomeComputador = findViewById(R.id.et_nome_computador)
        etIpComputador = findViewById(R.id.et_ip_computador)
        etVersaoAplicacao = findViewById(R.id.et_versao_econect)
        btnCadastrar = findViewById(R.id.btn_cadastrar)

        // Criando referência do banco de dados, indicando o caminho "Computadores"
        dbRef = FirebaseDatabase.getInstance().getReference("Computadores")

        // Criando listener do botão "Cadastrar"
        btnCadastrar.setOnClickListener {
            saveComputerData()
        }

    }

    private fun saveComputerData() {
        // Pegando valores
        val nomeComputador = etNomeComputador.text.toString()
        val ipComputador = etIpComputador.text.toString()
        val versaoAplicacao = etVersaoAplicacao.text.toString()

        // Validação de campos vazios
        if (nomeComputador.isEmpty()) {
            etNomeComputador.error = "Nome não informado."
        }
        if (ipComputador.isEmpty()) {
            etIpComputador.error = "IP não informado."
        }
        if (versaoAplicacao.isEmpty()) {
            etVersaoAplicacao.error = "Versão não informada."
        }

        val idComputador = dbRef.push().key!!

        // Criando um objeto do tipo computador com os dados coletados
        val computador = Computador(
            idComputador,
            nomeComputador,
            ipComputador,
            versaoAplicacao)

        // Criando um filho (nó) no banco de dados, indicado pelo Id
        dbRef.child(idComputador).setValue(computador)
            .addOnCompleteListener {    // Criando um listener de êxito de inserção
                Toast.makeText( // Gerando um aviso Toast na tela
                    this,
                    "Dados inseridos com sucesso!",
                    Toast.LENGTH_LONG).show()
                // Limpando campos no caso de sucesso
                etNomeComputador.text.clear()
                etIpComputador.text.clear()
                etVersaoAplicacao.text.clear()
            }.addOnFailureListener {    // Criando um listener para o caso de erro de inserção
                err -> Toast.makeText( // Gerando um aviso Toast na tela
                this,
                "Erro ${err.message}",
                Toast.LENGTH_LONG).show()}
    }

}
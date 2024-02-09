package com.henrique.e_control.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.henrique.e_control.R

class MainActivity : AppCompatActivity() {

    lateinit var btnInserir: Button
    lateinit var btnConsultar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInserir = findViewById(R.id.btn_act_inserir)
        btnConsultar = findViewById(R.id.btn_act_consultar)

        btnInserir.setOnClickListener {
            val intent = Intent(this, NewRegisterActivity::class.java)
            startActivity(intent)
        }

        btnConsultar.setOnClickListener {
            val intent = Intent(this, ComputersActivity::class.java)
            startActivity(intent)
        }

//        messageDatabase()

    }

    fun messageDatabase() {
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This methos is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d("Firebase", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.d("Firebase", "Failed to read value.", error.toException())
            }
            })
    }
}
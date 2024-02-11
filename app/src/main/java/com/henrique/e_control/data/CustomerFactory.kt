package com.henrique.e_control.data

import com.henrique.e_control.domain.Cliente

object CustomerFactory {
    val list = listOf(
        Cliente(
            idCliente = "1",
            nomeCliente = "Beltrame",
            logo = "@drawable/beltrame.png"
        ),
        Cliente(
            idCliente = "2",
            nomeCliente = "Lima",
            logo = "@drawable/lima.jpg"
        ),
        Cliente(
            idCliente = "3",
            nomeCliente = "Pazini",
            logo = "@draweable/pazini"
        ),
        Cliente(
            idCliente = "4",
            nomeCliente = "Único",
            logo = "@drawable/unico.png"
        )
    )
}
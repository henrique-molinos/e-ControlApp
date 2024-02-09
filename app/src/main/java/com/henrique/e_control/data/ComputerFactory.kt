package com.henrique.e_control.data

import com.henrique.e_control.domain.Computador

object ComputerFactory {
    val list = listOf(
        Computador(
            idComp = "1",
            nomeComp = "PDV 01",
            ipComp = "10.130.5.201",
            versaoEconect = "13.47.1-0"
        ),
        Computador(
            idComp = "2",
            nomeComp = "PDV 02",
            ipComp = "10.130.5.202",
            versaoEconect = "13.47.1-0"
        ),
        Computador(
            idComp = "3",
            nomeComp = "PDV 03",
            ipComp = "10.130.5.203",
            versaoEconect = "13.47.1-0"
        ),
        Computador(
            idComp = "4",
            nomeComp = "PDV 04",
            ipComp = "10.130.5.204",
            versaoEconect = "13.47.1-0"
        ),
        Computador(
            idComp = "5",
            nomeComp = "PDV 05",
            ipComp = "10.130.1.205",
            versaoEconect = "13.47.1-0"
        )
    )
}
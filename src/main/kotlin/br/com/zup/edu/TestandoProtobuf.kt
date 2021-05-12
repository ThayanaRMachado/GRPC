package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setIdade(22)
        .setSalario(2020.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(Endereco.newBuilder()
            .setLogradouro("Rua dos Tabajaras, 123")
            .setCep("00000-00")
            .setComplemento("Atrás do shopping")
            .build()
        )
        .build()
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val r2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    r2.setCargo(Cargo.GERENTE).build()

    println(r2)
}
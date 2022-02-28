package org.senai.devinhouse.m1s09.model;


import org.senai.devinhouse.m1s09.validation.Cpf;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Cliente {
    @NotNull
    private int id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Cpf
    private String cpf;

//    private List<String> nomesClientes;

    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public List<String> getNomesClientes() { return nomesClientes; }

//    public void setNomesClientes(List<String> nomesClientes) {this.nomesClientes = nomesClientes;}
}

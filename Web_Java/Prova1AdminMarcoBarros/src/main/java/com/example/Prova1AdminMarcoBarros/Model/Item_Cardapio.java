package com.example.Prova1AdminMarcoBarros.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
public class Item_Cardapio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
//    @NotBlank(message = "O preço é obrigatório")
    private double preco;
    private String descricao;
    private int id_restaurante;

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

    public double getPreco() { return preco; }

    public void setPreco(double preco) { this.preco = preco; }

    public String getDescricao() {return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
}

package com.example.Prova1ConsumidorMarcoBarros.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Item_Pedido implements Serializable {
    private Item_Cardapio itemCardapioPedido;
    private int quantidade;
    private String nomeRestaurante;

    public Item_Pedido(Item_Cardapio item, String nomeRestaurante) {
        this.itemCardapioPedido = item;
        this.nomeRestaurante = nomeRestaurante;
        this.quantidade = 0;
    }

    public Item_Cardapio getItemCardapioPedido() {
        return this.itemCardapioPedido;
    }

    public void setItemCardapioPedido(Item_Cardapio item) {
        this.itemCardapioPedido = item;
    }

    public String getNomeRestaurante() { return this.nomeRestaurante; }

    public void setNomeRestaurante(String nomeRestaurante) { this.nomeRestaurante = nomeRestaurante; }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

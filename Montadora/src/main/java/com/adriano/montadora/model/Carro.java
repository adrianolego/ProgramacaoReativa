package com.adriano.montadora.model;

import com.adriano.montadora.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    private String id;
    TipoVeiculo tipo;
    private Integer rodas;
    private String marca;
    private Integer qtdePessoas;
    private Long potencia;


    public com.adriano.montadora.document.Carro modelToDocument(com.adriano.montadora.model.Carro mod) {
        return new com.adriano.montadora.document.Carro(mod.getId(), mod.getTipo(), mod.getRodas(), mod.getMarca(), mod.getQtdePessoas(), mod.getPotencia());
    }
}
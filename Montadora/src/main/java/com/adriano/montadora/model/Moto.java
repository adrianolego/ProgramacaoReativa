package com.adriano.montadora.model;

import com.adriano.montadora.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto {

    private String id;
    TipoVeiculo tipo;
    private Integer rodas = 0;
    private String marca = "";
    private Integer qtdePessoas = 0;
    private Long cilindrada = 0L;

    public com.adriano.montadora.document.Moto modelToDocument(com.adriano.montadora.model.Moto mod) {
        return new com.adriano.montadora.document.Moto(mod.getId(), mod.getTipo(), mod.getRodas(), mod.getMarca(), mod.getCilindrada(), mod.getQtdePessoas());
    }
}

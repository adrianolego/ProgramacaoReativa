package com.adriano.montadora.document;

import com.adriano.montadora.enums.TipoVeiculo;
import com.adriano.montadora.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "veiculos")
public class Carro implements Veiculo {

    @Id
    private String id;
    TipoVeiculo tipo;
    private Integer rodas;
    private String marca;
    private Integer qtdePessoas;
    private Long potencia;
}

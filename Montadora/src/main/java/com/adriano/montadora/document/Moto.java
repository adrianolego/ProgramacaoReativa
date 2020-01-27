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
public class Moto implements Veiculo {

    @Id
    private String id;
    TipoVeiculo tipo;
    private Integer rodas = 0;
    private String marca = "";
    private Long cilindrada = 0L;
    private Integer qtdePessoas = 0;
}

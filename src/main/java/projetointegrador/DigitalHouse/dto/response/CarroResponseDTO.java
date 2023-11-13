package projetointegrador.DigitalHouse.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import projetointegrador.DigitalHouse.model.*;

import java.util.List;

// CarroResponseDTO contém os dados que serão
// retornados em uma operação de leitura.
// Dados retornados ao cliente (response).

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private boolean status;
    private String cor;
    private String placa;
    private String urlImagem;
    private String categoriaResponse;
    private String locadoraResponse;
    private List<String> caracteristicasResponse;
}

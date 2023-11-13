package projetointegrador.DigitalHouse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

// Anotação para garantir que a classe seja serializável/desserializável (por exemplo, para JSON)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroRequestDTO {
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private String placa;
    private Long categoriaId;
    private Long locadoraId;
    private List<Long> caracteristicasIds;
}


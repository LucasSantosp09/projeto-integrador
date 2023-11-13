package projetointegrador.DigitalHouse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import projetointegrador.DigitalHouse.model.Reserva;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

// DTO para Request (Create/Update):
// Aqui, o CarroRequestDTO contém os dados necessários
// para criar ou atualizar um carro.
// dados enviados pelo cliente (request)

// Anotação para garantir que a classe seja serializável/desserializável (por exemplo, para JSON)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroRequestDTO {
    private String marca;
    private String modelo;
    private Integer ano;
    private boolean status;
    private String cor;
    private String placa;
    private String urlImagem;
    private Long categoriaId;
    private Long locadoraId;
    private List<Long> caracteristicaCarroIds;
}


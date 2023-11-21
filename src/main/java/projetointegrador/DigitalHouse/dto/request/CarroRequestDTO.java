package projetointegrador.DigitalHouse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

//Os DTOs de request são usados para criar ou atualizar instâncias da entidade.
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroRequestDTO {
    private String marca;
    private String modelo;
    private Integer carroAno;
    private Boolean isDisponivel;
    private Float precoPorDia;
    private String urlImagem;
    private Long categoriaCarroId;
    private Long locadoraCarroId;
    private List<Long> caracteristicasCarroIds;
}



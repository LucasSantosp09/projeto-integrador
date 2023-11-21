package projetointegrador.DigitalHouse.dto.response;

import lombok.Data;

import java.util.List;

//Os DTOs de response são usados para enviar dados da entidade para fora da aplicação.
@Data
public class CarroResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer carroAno;
    private Boolean isDisponivel;
    private Float precoPorDia;
    private String urlImagem;
    private Long categoriaCarroId;
    private Long locadoraCarroId;
    private List<Long> caracteristicasCarroIds;
    private Long reservaId;
    private List<AvaliacaoResponseDTO> avaliacoes;
    private List<CaracteristicaCarroResponseDTO> caracteristicasCarro;
}

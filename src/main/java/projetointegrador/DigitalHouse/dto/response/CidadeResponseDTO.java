package projetointegrador.DigitalHouse.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CidadeResponseDTO {
    private Long id;
    private String nomeCidade;
    private List<LocadoraResponseDTO> locadoras;
}

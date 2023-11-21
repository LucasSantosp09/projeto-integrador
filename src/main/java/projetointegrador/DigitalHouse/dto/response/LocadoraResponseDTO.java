package projetointegrador.DigitalHouse.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class LocadoraResponseDTO {
    private Long id;
    private String nome;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private List<CidadeResponseDTO> cidades;
}

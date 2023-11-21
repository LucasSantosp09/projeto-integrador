package projetointegrador.DigitalHouse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocadoraRequestDTO {
    private String nome;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private List<CidadeRequestDTO> cidades;
}

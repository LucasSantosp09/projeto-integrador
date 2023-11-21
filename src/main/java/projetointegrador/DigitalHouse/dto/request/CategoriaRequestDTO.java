package projetointegrador.DigitalHouse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaRequestDTO {
    private String nome;
    private String descricao;
    private String imagem;
}

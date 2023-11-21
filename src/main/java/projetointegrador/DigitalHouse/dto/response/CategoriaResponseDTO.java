package projetointegrador.DigitalHouse.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CategoriaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private List<Long> carrosIds;
}

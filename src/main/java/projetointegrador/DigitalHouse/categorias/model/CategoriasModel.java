package projetointegrador.DigitalHouse.categorias.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "categorias")
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qualificacao;
    private String descricao;
    private String urlImagem;


}

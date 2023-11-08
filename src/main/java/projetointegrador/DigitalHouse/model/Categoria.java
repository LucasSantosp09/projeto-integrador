package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String UrlImagem;

}

package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String imagem;

    @OneToMany(mappedBy = "categoriaCarro")
    private List<Carro> carros;

}

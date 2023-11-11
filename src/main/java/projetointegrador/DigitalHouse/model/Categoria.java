package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String UrlImagem;

    @OneToMany(mappedBy = "categoria")
    private List<Carro> carro;

}

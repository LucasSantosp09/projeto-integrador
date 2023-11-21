package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

@Entity
@Data
@Table(name = "TB_CIDADE")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCidade;

    @ManyToMany(mappedBy = "cidade")
    private List<Locadora> locadora;
}

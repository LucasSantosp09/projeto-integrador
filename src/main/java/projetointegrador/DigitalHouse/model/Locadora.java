package projetointegrador.DigitalHouse.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "locadora")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLocadora;

    private String logradouro;

    private String bairro;

    private String numero;

    private String complemento;

    private String cep;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "locadora_cidade",
            joinColumns = @JoinColumn(name = "locadora_id"),
            inverseJoinColumns = @JoinColumn(name = "cidade_id")
    )
    private Set<Cidade> cidade = new HashSet<>();

    @OneToOne(mappedBy = "locadora")
    private Carro carro;
}

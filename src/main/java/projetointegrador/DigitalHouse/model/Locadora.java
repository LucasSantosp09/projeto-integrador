package projetointegrador.DigitalHouse.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "TB_LOCADORA")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "locadora_cidade",
            joinColumns = @JoinColumn(name = "locadora_id"),
            inverseJoinColumns = @JoinColumn(name = "cidade_id")
    )
    private List<Cidade> cidade;

    @OneToOne(mappedBy = "locadoraCarro")
    private Carro carro;
}

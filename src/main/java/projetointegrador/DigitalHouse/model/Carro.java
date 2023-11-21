package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private Integer ano;

    private boolean isDisponivel;

    private Float precoPorDia;

    private String urlImagem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaCarro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locadora_id")
    private Locadora locadoraCarro;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carro_caracteristica",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<CaracteristicaCarro> caracteristicaCarro;


    @OneToOne(mappedBy = "carro")
    private Reserva reserva;

    @OneToMany(mappedBy = "carro")
    private List<Avaliacao> avaliacoes;

}

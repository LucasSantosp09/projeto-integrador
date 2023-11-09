package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private Integer ano;

    private String cor;

    private String placa;

    private String urlImagem;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "locadora_id")
    private Locadora locadora;

    @ManyToMany
    @JoinTable(name = "carro_caracteristica",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<CaracteristicaCarro> caracteristicaCarro;

    private boolean status;

    @OneToOne(mappedBy = "carro")
    private Reserva reserva;

    @OneToMany(mappedBy = "carro")
    private List<Avaliacao> avaliacao;
}

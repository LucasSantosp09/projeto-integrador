package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "carros")
public class Carros {

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
    @JoinTable(name = "carros_caracteristicas",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<CaracteristicasCarro> caracteristicasCarros;

    private boolean status;

    @OneToOne(mappedBy = "carros")
    private Reservas reservas;

    @OneToMany(mappedBy = "carros")
    private List<Avaliacoes> avaliacoes;
}

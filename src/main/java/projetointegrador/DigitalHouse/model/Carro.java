package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "carro")
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private Integer ano;

    private boolean status;

    private String cor;

    private String placa;

    private String urlImagem;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaCarro;

    @OneToOne
    @JoinColumn(name = "locadora_id")
    private Locadora locadoraCarro;

    @ManyToMany
    @JoinTable(name = "carro_caracteristica",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<CaracteristicaCarro> caracteristicaCarro;


    @OneToOne(mappedBy = "carro")
    private Reserva reserva;

    @OneToMany(mappedBy = "carro")
    private List<Avaliacao> avaliacoes;

}

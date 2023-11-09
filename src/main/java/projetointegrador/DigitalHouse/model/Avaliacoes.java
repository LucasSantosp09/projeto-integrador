package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "avaliacoes")
public class Avaliacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Clientes clientes;

    @ManyToOne
    private Carros carros;

    private Integer pontuacao;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    private Date DataAvaliacao;
}

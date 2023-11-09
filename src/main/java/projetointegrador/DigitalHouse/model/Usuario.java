package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String logradouro;

    private String bairro;

    private String numero;

    private String complemento;

    private String cep;

    @OneToOne(mappedBy = "usuario")
    private Reserva reserva;

    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacao;

}

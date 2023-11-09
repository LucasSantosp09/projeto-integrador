package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Clientes {

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

    @OneToOne(mappedBy = "clientes")
    private Reservas reservas;



}

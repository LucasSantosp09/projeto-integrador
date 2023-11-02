package projetointegrador.DigitalHouse.imagens.model;

import jakarta.persistence.*;
import lombok.Data;
import projetointegrador.DigitalHouse.produtos.model.ProdutosModel;

@Entity
@Data
@Table(name = "imagens")
public class ImagensModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String url;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutosModel produto;

}

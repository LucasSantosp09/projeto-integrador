package projetointegrador.DigitalHouse.produtos.model;

import jakarta.persistence.*;
import lombok.Data;
import projetointegrador.DigitalHouse.carros.model.CarroModel;
import projetointegrador.DigitalHouse.categorias.model.CategoriasModel;
import projetointegrador.DigitalHouse.imagens.model.ImagensModel;

import java.util.List;

@Entity
@Data
@Table(name = "produtos")
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriasModel> categorias;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagensModel> imagens;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriasModel categoria;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private CarroModel carro;

}

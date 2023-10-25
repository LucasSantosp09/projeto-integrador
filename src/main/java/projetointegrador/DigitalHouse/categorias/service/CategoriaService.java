package projetointegrador.DigitalHouse.categorias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.categorias.exception.CategoriaNaoEncontradaException;
import projetointegrador.DigitalHouse.categorias.model.CategoriasModel;
import projetointegrador.DigitalHouse.categorias.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;


    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriasModel salvarCategoria(CategoriasModel categoria) {
        categoriaRepository.save(categoria);
        return categoria;
    }
    public List<CategoriasModel> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    public CategoriasModel editarCategoria(Long categoriaId, CategoriasModel novaCategoria) {
        CategoriasModel categoriaExistente = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria não encontrada com ID: " + categoriaId));

        categoriaExistente.setQualificacao(novaCategoria.getQualificacao());
        categoriaExistente.setDescricao(novaCategoria.getDescricao());
        categoriaExistente.setUrlImagem(novaCategoria.getUrlImagem());

        return categoriaRepository.save(categoriaExistente);
    }



}

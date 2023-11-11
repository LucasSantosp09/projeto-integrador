package projetointegrador.DigitalHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> ListarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria SalvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void DeletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

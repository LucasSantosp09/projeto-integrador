package projetointegrador.DigitalHouse.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria obterCategoria(Long id) throws ResourceNotFoundException {
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + id));
    }
}

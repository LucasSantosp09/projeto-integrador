package projetointegrador.DigitalHouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.CategoriaRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CategoriaResponseDTO;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Categoria> getAllCategorias() throws ResourceNotFoundException {
        try{
            return categoriaRepository.findAll();
        }catch (Exception ex) {
            throw new ResourceNotFoundException("Recursos não encontrados!");
        }
    }

    public CategoriaResponseDTO criarCategoria(CategoriaRequestDTO newRequestDTO) throws InvalidDataException{
        try{
            Categoria categoria = modelMapper.map(newRequestDTO, Categoria.class);
            Categoria categoriaSalva = categoriaRepository.save(categoria);
            return modelMapper.map(categoriaSalva, CategoriaResponseDTO.class);
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos para criar Categoria");
        }
    }
}

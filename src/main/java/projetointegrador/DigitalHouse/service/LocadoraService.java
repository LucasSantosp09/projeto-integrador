package projetointegrador.DigitalHouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.LocadoraRequestDTO;
import projetointegrador.DigitalHouse.dto.response.LocadoraResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Locadora;
import projetointegrador.DigitalHouse.repository.LocadoraRepository;

import java.util.List;

@Service
public class LocadoraService {

    @Autowired
    private LocadoraRepository locadoraRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Locadora> getAllLocadora() throws ResourceNotFoundException {
        try {
            return locadoraRepository.findAll();
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Recursos não encontrados!");
        }
    }

    public LocadoraResponseDTO criarLocadora(LocadoraRequestDTO newRequestDTO) throws InvalidDataException {
        try {
            Locadora locadora = modelMapper.map(newRequestDTO, Locadora.class);
            Locadora locadoraSalva = locadoraRepository.save(locadora);
            return modelMapper.map(locadoraSalva, LocadoraResponseDTO.class);

        } catch (Exception ex) {
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }

}

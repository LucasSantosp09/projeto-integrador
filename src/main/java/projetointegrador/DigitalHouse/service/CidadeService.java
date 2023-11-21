package projetointegrador.DigitalHouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.CidadeRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CidadeResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Cidade;
import projetointegrador.DigitalHouse.repository.CidadeRepository;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Cidade> getAllCidades() throws ResourceNotFoundException {
        try {
            return cidadeRepository.findAll();
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Recursos não encontrados!");
        }
    }

    public CidadeResponseDTO criarCidade(CidadeRequestDTO newRequestDTO) throws InvalidDataException {
        try {
            Cidade cidade = modelMapper.map(newRequestDTO, Cidade.class);
            Cidade cidadeSalvo = cidadeRepository.save(cidade);
            return modelMapper.map(cidadeSalvo, CidadeResponseDTO.class);
        } catch (Exception ex) {
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }

}

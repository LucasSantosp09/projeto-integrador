package projetointegrador.DigitalHouse.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.repository.CarroRepository;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

//Service (CarroService):
// Lida com a lógica de negócios,
// neste caso, a criação de um novo carro.

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper modelMapper;


    public CarroResponseDTO criarCarro(Carro carro) throws SQLDataException {
        Carro carroSalvo = carroRepository.save(carro);
        return modelMapper.map(carroSalvo, CarroResponseDTO.class);
    }


    public List<Carro> obterCarros() throws SQLException {
        return carroRepository.findAll();
    }

    public CarroResponseDTO obterCarroPorId(Long id) throws ResourceNotFoundException {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com o ID: " + id));

        return modelMapper.map(carro, CarroResponseDTO.class);
    }
}

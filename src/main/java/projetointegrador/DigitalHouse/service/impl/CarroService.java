package projetointegrador.DigitalHouse.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.repository.CarroRepository;
import projetointegrador.DigitalHouse.service.ICarro;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService implements ICarro<Carro, CarroRequestDTO, CarroResponseDTO> {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarroResponseDTO createCarro(CarroRequestDTO carroRequestDTO) throws SQLDataException {
        Carro carro = modelMapper.map(carroRequestDTO, Carro.class);
        Carro carroSalvo = carroRepository.save(carro);

        return modelMapper.map(carroSalvo, CarroResponseDTO.class);
    }

    @Override
    public List<Carro> getAllCarros() throws SQLException {
        return carroRepository.findAll();
    }
}

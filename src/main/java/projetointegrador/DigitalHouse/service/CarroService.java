package projetointegrador.DigitalHouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.repository.CarroRepository;

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

    public List<Carro> getAllCarros() throws ResourceNotFoundException {
        try {
            return carroRepository.findAll();
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Recursos não encontrados!");
        }
    }

    public CarroResponseDTO criarCarro(CarroRequestDTO newRequestDTO) throws InvalidDataException {
        try {
            Carro carro = modelMapper.map(newRequestDTO, Carro.class);
            Carro carroSalvo = carroRepository.save(carro);
            return modelMapper.map(carroSalvo, CarroResponseDTO.class);
        } catch (Exception ex) {
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }

}

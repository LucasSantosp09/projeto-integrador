package projetointegrador.DigitalHouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.repository.CarroRepository;
import projetointegrador.DigitalHouse.repository.CategoriaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

//Service (CarroService):
// Lida com a lógica de negócios,
// neste caso, a criação de um novo carro.

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CarroResponseDTO criarCarro(CarroRequestDTO carroRequestDTO) throws SQLException, InvalidDataException {
        try {
            Carro carro = convertToEntity(carroRequestDTO);
            Carro carroSalvo = carroRepository.save(carro);
            return convertToDTO(carroSalvo);
        } catch (Exception e) {
            throw new InvalidDataException("Não foi possivel executar essa ação");
        }
    }

    public List<CarroResponseDTO> obterCarros() throws SQLException, ResourceNotFoundException {
        try {
            List<Carro> carroList = carroRepository.findAll();
            return carroList.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não existe");
        }
    }

    public CarroResponseDTO obterCarroPorId(Long id) throws ResourceNotFoundException {
        Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + id));
        return convertToDTO(carro);
    }

    private CarroResponseDTO convertToDTO(Carro carro) {
        return modelMapper.map(carro, CarroResponseDTO.class);
    }

    private Carro convertToEntity(CarroRequestDTO carroRequestDTO) {
        return modelMapper.map(carroRequestDTO, Carro.class);
    }

}

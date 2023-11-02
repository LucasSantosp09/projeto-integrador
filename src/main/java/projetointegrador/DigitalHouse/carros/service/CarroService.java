package projetointegrador.DigitalHouse.carros.service;

import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.carros.model.CarroModel;
import projetointegrador.DigitalHouse.carros.repository.CarroRepository;
import projetointegrador.DigitalHouse.categorias.model.CategoriasModel;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public CarroModel salvarCarro(CarroModel carro){
        carroRepository.save(carro);
        return carro;
    }

    public List<CarroModel> listarCarro(){
        return carroRepository.findAll();
    }

}

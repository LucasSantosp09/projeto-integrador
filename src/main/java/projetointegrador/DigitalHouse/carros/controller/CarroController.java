package projetointegrador.DigitalHouse.carros.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.carros.model.CarroModel;
import projetointegrador.DigitalHouse.carros.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService carroService;;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<CarroModel> listarCarros() {
        return carroService.listarCarro();
    }

    @PostMapping
    public CarroModel criarCarro(@RequestBody CarroModel carro) {
        return carroService.salvarCarro(carro);
    }

}

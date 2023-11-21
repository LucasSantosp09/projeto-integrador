package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.service.CarroService;

import java.util.List;

//Controller (CarroController):
// Atua como intermediário, recebendo a entrada do cliente,
// interagindo com o serviço e retornando a resposta ao cliente.
@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> obterTodosCarros() throws ResourceNotFoundException {
        List<Carro> carroList = carroService.getAllCarros();

        if (!carroList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(carroList);
        } else {
            throw new ResourceNotFoundException("Registros não encontrados");
        }
    }

    @PostMapping
    public ResponseEntity<CarroResponseDTO> criarCarro(@Validated @RequestBody CarroRequestDTO newRequestDTO) throws InvalidDataException {
        try {
            CarroResponseDTO response = carroService.criarCarro(newRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e) {
            throw new InvalidDataException("Ocorreu algum problema, carro não foi salvo!");
        }
    }
}


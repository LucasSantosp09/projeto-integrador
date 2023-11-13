package projetointegrador.DigitalHouse.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;

import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.exception.handler.GlobalException;

import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.service.impl.CarroService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> salvar(@RequestBody CarroRequestDTO carro) throws SQLException, InvalidDataException{
        try {
           CarroResponseDTO response = carroService.createCarro(carro);
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e) {
            throw new InvalidDataException("Ocorreu algum poblema, carro não foi salvo!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos() throws SQLException, InvalidDataException {
        List<Carro> carroList = carroService.getAllCarros();
        if (!carroList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(carroList);
        } else {
            throw new InvalidDataException("Nenhum registro encontrado");
        }
    }
    // Exception handling methods
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarErroBadRequest(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<String> processarNotFound(InvalidDataException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}


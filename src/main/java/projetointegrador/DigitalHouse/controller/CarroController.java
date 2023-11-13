package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.dto.request.CarroRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.service.CarroService;
import projetointegrador.DigitalHouse.service.CategoriaService;

import java.sql.SQLException;
import java.util.List;

//Controller (CarroController):
// Atua como intermediário, recebendo a entrada do cliente,
// interagindo com o serviço e retornando a resposta ao cliente.
@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> criarCarro(@RequestBody CarroRequestDTO carroRequestDTO) throws SQLException, InvalidDataException {
        try {
            CarroResponseDTO carroResponseDTO = carroService.criarCarro(carroRequestDTO);
            return new ResponseEntity<>(carroResponseDTO, HttpStatus.CREATED);
        }catch (Exception e) {
            throw new InvalidDataException("Ocorreu algum poblema, carro não foi salvo!");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CarroResponseDTO>> obterTodosCarros() throws SQLException, ResourceNotFoundException {
        List<CarroResponseDTO> carroList = carroService.obterCarros();
        if (!carroList.isEmpty()){
            return new ResponseEntity<>(carroList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Nenhum registro de carros encontrados");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CarroResponseDTO> obterCarroPorId(@PathVariable Long id) throws SQLException, ResourceNotFoundException {
        try {
            CarroResponseDTO carro = carroService.obterCarroPorId(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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


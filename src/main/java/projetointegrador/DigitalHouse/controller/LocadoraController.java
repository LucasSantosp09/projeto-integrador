package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.dto.request.LocadoraRequestDTO;
import projetointegrador.DigitalHouse.dto.response.LocadoraResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Locadora;
import projetointegrador.DigitalHouse.service.LocadoraService;

import java.util.List;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

    @Autowired
    private LocadoraService locadoraService;

    @GetMapping
    public ResponseEntity<List<Locadora>> obterTodasLocadoras() throws ResourceNotFoundException{
        List<Locadora> locadoraList = locadoraService.getAllLocadora();

        if (!locadoraList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(locadoraList);
        } else {
            throw new ResourceNotFoundException("Registros não encontrados");
        }
    }

    @PostMapping
    public ResponseEntity<LocadoraResponseDTO> criarLocadora(@Validated @RequestBody LocadoraRequestDTO newRequestDTO) throws InvalidDataException{
        try{
            LocadoraResponseDTO responseDTO = locadoraService.criarLocadora(newRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception ex){
            throw new InvalidDataException("Ocorreu algum problema, carro não foi salvo!");
        }
    }


}

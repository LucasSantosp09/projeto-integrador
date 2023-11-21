package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.dto.request.CidadeRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CidadeResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Cidade;
import projetointegrador.DigitalHouse.service.CidadeService;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;


    @GetMapping
    public ResponseEntity<List<Cidade>> obterTodasCidades() throws ResourceNotFoundException{
        List<Cidade> cidadeList = cidadeService.getAllCidades();

        if (!cidadeList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(cidadeList);
        } else{
            throw new ResourceNotFoundException("Registros não encontrados");
        }
    }

    @PostMapping
    public ResponseEntity<CidadeResponseDTO> criarCidade(@Validated @RequestBody CidadeRequestDTO newRequestDTO) throws InvalidDataException{
        try{
            CidadeResponseDTO response = cidadeService.criarCidade(newRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception ex){
            throw new InvalidDataException("Ocorreu algum problema, carro não foi salvo!");
        }
    }

}

package projetointegrador.DigitalHouse.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.dto.request.CategoriaRequestDTO;
import projetointegrador.DigitalHouse.dto.response.CategoriaResponseDTO;
import projetointegrador.DigitalHouse.exception.InvalidDataException;
import projetointegrador.DigitalHouse.exception.ResourceNotFoundException;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obterTodasCategorias() throws ResourceNotFoundException{
        List<Categoria> categoriaList = categoriaService.getAllCategorias();

        if(!categoriaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(categoriaList);
        }else{
            throw new ResourceNotFoundException("Registros não encontrados");
        }

    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> criarCategoria(@Validated @RequestBody CategoriaRequestDTO newRequestDTO) throws InvalidDataException{
        try{
            CategoriaResponseDTO response = categoriaService.criarCategoria(newRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception ex) {
            throw new InvalidDataException("Ocorreu algum problema, carro não foi salvo!");
        }
    }

}


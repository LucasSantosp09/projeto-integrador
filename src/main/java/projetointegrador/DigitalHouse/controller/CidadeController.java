package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.model.Cidade;
import projetointegrador.DigitalHouse.service.CategoriaService;
import projetointegrador.DigitalHouse.service.CidadeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public List<Cidade> ListarCidades() {
        return cidadeService.ListarCidade();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> ListarCidadePorId(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeService.ListarCidadePorId(id);
        return cidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cidade> SalvarCidade(@RequestBody Cidade cidade) {
        Cidade salvarCidade = cidadeService.SalvarCidade(cidade);
        return ResponseEntity.ok(salvarCidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarCidade(@PathVariable Long id) {
        cidadeService.DeletarCidade(id);
        return ResponseEntity.noContent().build();
    }
}

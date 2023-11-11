package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.model.Locadora;
import projetointegrador.DigitalHouse.service.LocadoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locadoras")
public class LocadoraController {

    private final LocadoraService locadoraService;

    @Autowired
    public LocadoraController(LocadoraService locadoraService) {
        this.locadoraService = locadoraService;
    }

    @GetMapping
    public List<Locadora> ListarLocadoras(){
        return locadoraService.ListarLocadoras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locadora> ListarLocadoraPorId(@PathVariable Long id){
        Optional<Locadora> locadora = locadoraService.ListarLocadoraPorId(id);
        return locadora.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Locadora> SalvarLocadora(@RequestBody Locadora locadora){
        Locadora salvarLocadora = locadoraService.SalvarLocadora(locadora);
        return ResponseEntity.ok(salvarLocadora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarLocadora(@PathVariable Long id){
        locadoraService.DeletarLocadora(id);
        return ResponseEntity.noContent().build();
    }

}

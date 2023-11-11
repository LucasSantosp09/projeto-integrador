package projetointegrador.DigitalHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.model.Categoria;
import projetointegrador.DigitalHouse.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {


    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> ListarCategorias() {
        return categoriaService.ListarCategorias();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> ListarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.ListarCategoriaPorId(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> SalvarCategoria(@RequestBody Categoria categoria) {
        Categoria salvarCategoria = categoriaService.SalvarCategoria(categoria);
        return ResponseEntity.ok(salvarCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarCategoria(@PathVariable Long id) {
        categoriaService.DeletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}

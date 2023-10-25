package projetointegrador.DigitalHouse.categorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetointegrador.DigitalHouse.categorias.model.CategoriasModel;
import projetointegrador.DigitalHouse.categorias.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
private final CategoriaService categoriaService;

@Autowired
   public CategoriaController(CategoriaService categoriaService) {
    this.categoriaService = categoriaService;
}

    @PostMapping
    public CategoriasModel adicionarCategoria(@RequestBody CategoriasModel categoria){
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping
    public List<CategoriasModel> listarCategorias() {
    return categoriaService.listarCategorias();
    }

    @PutMapping("/{categoriaId}")
    public CategoriasModel editarCategoria(@PathVariable Long categoriaId, @RequestBody CategoriasModel novaCategoria) {
        return categoriaService.editarCategoria(categoriaId, novaCategoria);
    }
    @DeleteMapping("/{categoriaId}")
    public void deletarCategoria(@PathVariable Long categoriaId) {
        categoriaService.deletarCategoria(categoriaId);
    }


}

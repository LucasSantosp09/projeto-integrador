package projetointegrador.DigitalHouse.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetointegrador.DigitalHouse.categorias.model.CategoriasModel;

public interface CategoriaRepository  extends JpaRepository <CategoriasModel, Long> {
}

package projetointegrador.DigitalHouse.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface ICarro<TYPE, REQ, RES> {
    RES criarCarro(REQ carroRequestDTO) throws SQLDataException;

    List<TYPE> obterCarros() throws SQLException;

//    Optional<TYPE> obterCarro(Long id);
//
//    void DeleteCarro(Long id) throws SQLException;
}

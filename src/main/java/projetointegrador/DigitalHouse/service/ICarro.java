package projetointegrador.DigitalHouse.service;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.sql.SQLDataException;
import java.util.List;
import java.sql.SQLException;
import java.util.Optional;

public interface ICarro<TYPE, REQ, RES> {
    RES createCarro(REQ carroRequestDTO) throws SQLDataException;

    List<TYPE> getAllCarros() throws SQLException;

//    Optional<TYPE> findByIdCar(Long id);
//
//    void DeleteCarro(Long id) throws SQLException;
}

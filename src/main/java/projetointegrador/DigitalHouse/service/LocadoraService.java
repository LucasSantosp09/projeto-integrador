package projetointegrador.DigitalHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.model.Locadora;
import projetointegrador.DigitalHouse.repository.LocadoraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocadoraService {

    private LocadoraRepository locadoraRepository;
    @Autowired
    public LocadoraService(LocadoraRepository locadoraRepository){
        this.locadoraRepository = locadoraRepository;
    }

    public List<Locadora> ListarLocadoras (){
        return locadoraRepository.findAll();
    }

    public Optional<Locadora> ListarLocadoraPorId(Long id){
        return locadoraRepository.findById(id);
    }

    public Locadora SalvarLocadora(Locadora locadora){
        return locadoraRepository.save(locadora);
    }

    public void DeletarLocadora(Long id){
        locadoraRepository.deleteById(id);
    }


}

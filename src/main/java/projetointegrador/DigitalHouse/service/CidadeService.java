package projetointegrador.DigitalHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetointegrador.DigitalHouse.model.Cidade;
import projetointegrador.DigitalHouse.repository.CidadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> ListarCidade(){
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> ListarCidadePorId(Long id){
        return cidadeRepository.findById(id);
    }

    public Cidade SalvarCidade(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public void DeletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
}

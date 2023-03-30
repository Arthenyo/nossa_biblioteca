package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Devolucao;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.DevolucaoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevolucaoService {

    private final DevolucaoRepository devolucaoRepository;

    public Devolucao save(Devolucao devolucao){
        return devolucaoRepository.save(devolucao);
    }

    public List<Devolucao> findAll(){
        return devolucaoRepository.findAll();
    }

    public Devolucao findById(Long id){
        return devolucaoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteDevolucao(Long id) {
        devolucaoRepository.deleteById(id);
    }
}

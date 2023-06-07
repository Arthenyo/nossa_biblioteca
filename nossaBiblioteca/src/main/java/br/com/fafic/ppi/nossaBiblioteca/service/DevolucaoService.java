package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Devolucao;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.AlunoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.DevolucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevolucaoService {

    private final DevolucaoRepository devolucaoRepository;
    private final EmprestimoService emprestimoService;

    public List<Devolucao> findAll() {
        return devolucaoRepository.findAll();
    }

    public Devolucao findByID(Long id) {
        return devolucaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao emcontrado" + id));
    }

    public Devolucao save(Long id,Devolucao devolucao){
        LocalDate dataempretimo = emprestimoService.findById(id).getDataDoEmprestimo();
        LocalDate datadadevolucao = LocalDate.now();
        long days = dataempretimo.until(datadadevolucao, ChronoUnit.DAYS);
        if(days > 3){
            for(int i = 0; i <= days ; i++){
                Double valor = emprestimoService.findById(id).getValorempretimo() + 2;
            }
        }
        return devolucaoRepository.save(devolucao);
    }

    public Devolucao update(Long id, Devolucao devolucao) {
        Devolucao devolucao1 = devolucaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao encontrado" + id));
        return devolucaoRepository.save(devolucao);
    }

    public void delete(Long id) {
        Devolucao devolucao = devolucaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao encontrado" + id));

        devolucaoRepository.delete(devolucao);
    }
}

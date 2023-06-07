package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private Livro livro;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Emprestimmo nao encontrado" + id));
    }

    public Emprestimo save(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo update(Long id, Emprestimo emprestimo) {
        Emprestimo emprestimo1 = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Emprestimo nao encontrado" + id));
        return emprestimoRepository.save(emprestimo);
    }

    public void delete(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Emprestimo nao encontrado" + id));

        emprestimoRepository.delete(emprestimo);
    }
}

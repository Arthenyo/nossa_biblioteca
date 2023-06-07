package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EmprestimoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro nao encontrado" + id));
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro update(Long id, Livro livro) {
        Livro livro1 = livroRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro nao encontrado" + id));
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro nao encontrado" + id));

        livroRepository.delete(livro);
    }




}

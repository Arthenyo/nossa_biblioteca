package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Biblioteca;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.AlunoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findByID(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao emcontrado" + id));
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        Aluno aluno1 = alunoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao encontrado" + id));
        return alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno nao encontrado" + id));

        alunoRepository.delete(aluno);
    }
}

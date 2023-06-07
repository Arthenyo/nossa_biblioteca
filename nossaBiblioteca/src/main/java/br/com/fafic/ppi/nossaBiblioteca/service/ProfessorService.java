package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Biblioteca;
import br.com.fafic.ppi.nossaBiblioteca.domain.Professor;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecaRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findByID(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Professor nao encontrado" + id));
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Long id, Professor professor) {
        Professor professor1 = professorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Professor nao encontrado" + id));
        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Professor nao encontrado" + id));

        professorRepository.delete(professor);
    }
}

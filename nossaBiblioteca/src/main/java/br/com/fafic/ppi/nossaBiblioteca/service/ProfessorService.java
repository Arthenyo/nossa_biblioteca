package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Professor;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
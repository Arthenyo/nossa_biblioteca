package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Biblioteca;
import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecaRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> findAll() {
        return bibliotecarioRepository.findAll();
    }

    public Bibliotecario findByID(Long id) {
        return bibliotecarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Bibliotecario nao encontado" + id));
    }

    public Bibliotecario save(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Bibliotecario update(Long id, Bibliotecario bibliotecario) {
        bibliotecarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Bibliotecario nao encontrado" + id));
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void delete(Long id) {
        Bibliotecario bibliotecario = bibliotecarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Comment not found with id " + id));

        bibliotecarioRepository.delete(bibliotecario);
    }
}

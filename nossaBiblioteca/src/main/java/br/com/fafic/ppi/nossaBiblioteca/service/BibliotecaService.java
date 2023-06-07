package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Biblioteca;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> getAllBiblioteca() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca getBibliotecaById(Long id) {
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Biblioteca Nao Encontrada" + id));
    }

    public Biblioteca createBiblioteca(Biblioteca post) {
        return bibliotecaRepository.save(post);
    }

    public Biblioteca updateBiblioteca(Long id, Biblioteca bibliotecadetalhes) {
        Biblioteca biblioteca = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Biblioteca Nao Encontrada" + id));
        return bibliotecaRepository.save(biblioteca);
    }

    public void deleteBiblioteca(Long id) {
        Biblioteca post = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Biblioteca Nao Encontrada" + id));

        bibliotecaRepository.delete(post);
    }
}

package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public List<Contato> getAllContato() {
        return contatoRepository.findAll();
    }

    public Contato getContatoById(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Contato nao encontrado" + id));
    }

    public Contato createContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato updateContato(Long id, Contato contato) {
        Contato contato1 = contatoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Contato nao encontrado" + id));
        return contatoRepository.save(contato);
    }

    public void deleteContato(Long id) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Contato nao encontrado" + id));

        contatoRepository.delete(contato);
    }
}

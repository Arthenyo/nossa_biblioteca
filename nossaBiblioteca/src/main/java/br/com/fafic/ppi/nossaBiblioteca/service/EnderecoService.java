package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Endereco nao encontrado" + id));
    }

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateContato(Long id, Endereco endereco) {
        Endereco endereco1 = enderecoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Endereco nao encontrado" + id));
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Endereco nao encontrado" + id));
        enderecoRepository.delete(endereco);
    }
}

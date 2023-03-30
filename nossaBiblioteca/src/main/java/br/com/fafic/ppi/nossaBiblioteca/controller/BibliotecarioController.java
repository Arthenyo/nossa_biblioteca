package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.service.BibliotecarioService;
import br.com.fafic.ppi.nossaBiblioteca.service.ContatoService;
import br.com.fafic.ppi.nossaBiblioteca.service.EnderecoService;
import br.com.fafic.ppi.nossaBiblioteca.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotecario")
@RequiredArgsConstructor
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Bibliotecario bibliotecario){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecario));
    }

    @GetMapping
    public List<Bibliotecario> findAll(){
        return bibliotecarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bibliotecarioService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Bibliotecario bibliotecario){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecario));
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<Bibliotecario> adicionarendereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setEndereco(endereco);
            enderecoService.save(endereco);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/contato")
    public ResponseEntity<Bibliotecario> adicionarcontato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setContato(contato);
            contatoService.save(contato);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/login")
    public ResponseEntity<Bibliotecario> adicionarlogin(@PathVariable Long id, @RequestBody Login login) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setLogin(login);
            loginService.save(login);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        bibliotecarioService.deleteBibliotecario(id);
    }
}

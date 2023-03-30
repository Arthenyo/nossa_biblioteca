package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.service.ContatoService;
import br.com.fafic.ppi.nossaBiblioteca.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Contato contato){
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }

    @GetMapping
    public List<Contato> findAll(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(contatoService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Contato contato){
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        contatoService.deleteContato(id);
    }
}

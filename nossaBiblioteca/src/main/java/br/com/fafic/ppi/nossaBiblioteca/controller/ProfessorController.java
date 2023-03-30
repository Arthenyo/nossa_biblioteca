package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Professor professor){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @GetMapping
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(professorService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Professor professor){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<Professor> adicionarendereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setEndereco(endereco);
            enderecoService.save(endereco);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/contato")
    public ResponseEntity<Professor> adicionarcontato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setContato(contato);
            contatoService.save(contato);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/login")
    public ResponseEntity<Professor> adicionarlogin(@PathVariable Long id, @RequestBody Login login) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setLogin(login);
            loginService.save(login);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        professorService.deleteProfessor(id);
    }
}

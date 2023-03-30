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
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @GetMapping
    public List<Aluno> findAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(alunoService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<Aluno> adicionarendereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setEndereco(endereco);
            enderecoService.save(endereco);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/contato")
    public ResponseEntity<Aluno> adicionarcontato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setContato(contato);
            contatoService.save(contato);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/login")
    public ResponseEntity<Aluno> adicionarlogin(@PathVariable Long id, @RequestBody Login login) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setLogin(login);
            loginService.save(login);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
    }
}

package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.service.*;
import javax.validation.Valid;
import javax.validation.Validator;

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
    private final BibliotecaService bibliotecaService;

    private Validator validator;
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> get() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@Valid @RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.update(id,aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

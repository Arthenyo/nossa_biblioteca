package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Devolucao;
import br.com.fafic.ppi.nossaBiblioteca.service.AlunoService;
import br.com.fafic.ppi.nossaBiblioteca.service.BibliotecaService;
import br.com.fafic.ppi.nossaBiblioteca.service.DevolucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@RestController
@RequestMapping("/devolucao")
@RequiredArgsConstructor
public class DevolucaoController {

    private final DevolucaoService devolucaoService;

    private Validator validator;
    @GetMapping("/{id}")
    public ResponseEntity<Devolucao> getAluno(@PathVariable Long id) {
        return ResponseEntity.ok(devolucaoService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<Devolucao>> get() {
        return ResponseEntity.ok(devolucaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Devolucao> createAluno(@Valid @PathVariable Long id, @RequestBody Devolucao devolucao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucaoService.save(id,devolucao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devolucao> updateAluno(@PathVariable Long id, @Valid @RequestBody Devolucao devolucao) {
        return ResponseEntity.ok(devolucaoService.update(id,devolucao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        devolucaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

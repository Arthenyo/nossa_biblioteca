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
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Emprestimo emprestimo){
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimo));
    }

    @GetMapping
    public List<Emprestimo> findAll(){
        return emprestimoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(emprestimoService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Emprestimo emprestimo){
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimo));
    }

    @PostMapping("/{id}/livros")
    public ResponseEntity<Emprestimo> adicionarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Optional<Emprestimo> optionalEmprestimo = Optional.ofNullable(emprestimoService.findById(id));
        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            livro.setEmprestimo(emprestimo);
            livroService.findById(id);
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmprestimo(@PathVariable("id") Long id) {
        emprestimoService.deleteEmprestimo(id);
    }
}

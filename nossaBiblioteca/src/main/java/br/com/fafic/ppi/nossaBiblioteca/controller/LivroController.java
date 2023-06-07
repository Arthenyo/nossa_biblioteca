package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.service.EmprestimoService;
import br.com.fafic.ppi.nossaBiblioteca.service.LivroService;
import javax.validation.Valid;
import javax.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;
    private Validator validator;



    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.update(id,livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

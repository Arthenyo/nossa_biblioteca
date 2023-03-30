package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.service.EmprestimoService;
import br.com.fafic.ppi.nossaBiblioteca.service.LivroService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
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
    private final EmprestimoService emprestimoService;
    private Validator validator;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(livroService.findById(id));
    }

    @PutMapping
    public ResponseEntity update (@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

    @PutMapping("/{id}/emprestimo")
    public ResponseEntity<Livro> adicionarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        Optional<Livro> optionalLivro = Optional.ofNullable(livroService.findById(id));
        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            livro.setEmprestimo(emprestimoService.findById(emprestimo.getId()));
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        livroService.deleteLivro(id);
    }

}

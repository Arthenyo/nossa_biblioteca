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
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;
    private final BibliotecarioService bibliotecarioService;
    private final LivroService livroService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Biblioteca biblioteca){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(biblioteca));
    }

    @GetMapping
    public List<Biblioteca> findAll(){
        return bibliotecaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bibliotecaService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody Biblioteca biblioteca){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(biblioteca));
    }

    @PostMapping("/{id}/bibliotecario")
    public ResponseEntity adicionarBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecario) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setBibliotecario(bibliotecarioService.findById(bibliotecario.getId()));
            bibliotecaService.save(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/livros")
    public ResponseEntity<Biblioteca> adicionarLivros(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setLivros(livroService.findAll());
            bibliotecaService.save(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/alunos")
    public ResponseEntity<Biblioteca> adicionarAlunos(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setAlunos(alunoService.findAll());
            bibliotecaService.save(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/professor")
    public ResponseEntity<Biblioteca> adicionarProfessor(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setProfessores(professorService.findAll());
            bibliotecaService.save(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        bibliotecarioService.deleteBibliotecario(id);
    }
}

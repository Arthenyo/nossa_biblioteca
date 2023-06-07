package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.service.*;
import javax.validation.Valid;
import javax.validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    private Validator validator;

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> getBiblioteca(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecaService.getBibliotecaById(id));
    }

    @PostMapping
    public ResponseEntity<Biblioteca> createBiblioteca(@Valid @RequestBody Biblioteca biblioteca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.createBiblioteca(biblioteca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> updateBiblioteca(@PathVariable Long id, @Valid @RequestBody Biblioteca biblioteca) {
        return ResponseEntity.ok(bibliotecaService.updateBiblioteca(id,biblioteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id) {
        bibliotecaService.deleteBiblioteca(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/bibliotecario")
    public ResponseEntity adicionarBibliotecario(@PathVariable Long id, Long bibliotecario) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.getBibliotecaById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setBibliotecario(bibliotecarioService.findByID(bibliotecario));
            bibliotecaService.createBiblioteca(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

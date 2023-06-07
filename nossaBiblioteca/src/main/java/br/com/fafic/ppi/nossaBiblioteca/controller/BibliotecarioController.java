package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bibliotecario")
@RequiredArgsConstructor
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;
    private final BibliotecaService bibliotecaService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final LivroService livroService;
    private Validator validator;
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> getBibliotecario(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecarioService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<Bibliotecario>> get() {
        return ResponseEntity.ok(bibliotecarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> createBibliotecario(@Valid @RequestBody Bibliotecario bibliotecario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> updateBibliotecario(@PathVariable Long id, @Valid @RequestBody Bibliotecario bibliotecario) {
        return ResponseEntity.ok(bibliotecarioService.update(id,bibliotecario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id) {
        bibliotecarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/aluno")
    public ResponseEntity adicionarAlunoBiblioteca(@PathVariable Long id, Long aluno) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.getBibliotecaById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            Aluno obj = alunoService.findByID(aluno);
            for(Aluno aluno1 : alunoService.findAll()){
                if(obj == aluno1){
                    biblioteca.getAlunos().add(aluno1);
                }
            }
            bibliotecaService.createBiblioteca(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{id}/professor")
    public ResponseEntity adicionarProfessorBiblioteca(@PathVariable Long id, Long professor) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.getBibliotecaById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            Professor obj = professorService.findByID(professor);
            for(Professor professor1 : professorService.findAll()){
                if(obj == professor1){
                    biblioteca.getProfessores().add(professor1);
                }
            }
            bibliotecaService.createBiblioteca(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{id}/livro")
    public ResponseEntity adicionarlivroBiblioteca(@PathVariable Long id, Long livro) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.getBibliotecaById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            Livro obj = livroService.findById(livro);
            for(Livro livro1 : livroService.findAll()){
                if(obj == livro1){
                    biblioteca.getLivros().add(livro1);
                }
            }
            bibliotecaService.createBiblioteca(biblioteca);
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

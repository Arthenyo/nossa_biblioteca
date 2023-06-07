package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(professorService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<Professor> createBibliotecario(@Valid @RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateBibliotecario(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.update(id,professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

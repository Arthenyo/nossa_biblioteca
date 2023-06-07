package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
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
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final LivroService livroService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;


    @GetMapping
    public List<Emprestimo> findAll(){
        return emprestimoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(emprestimoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Emprestimo> save(@Valid @RequestBody Emprestimo emprestimo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Long id, @Valid @RequestBody Emprestimo emprestimo) {
        return ResponseEntity.ok(emprestimoService.update(id,emprestimo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emprestimoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/livro")
    public ResponseEntity adicionarlivroEmprestimo(@PathVariable Long id, Long livro) {
        Optional<Emprestimo> optionalEmprestimo = Optional.ofNullable(emprestimoService.findById(id));
        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            Livro obj = livroService.findById(livro);
            for(Livro livro1 : livroService.findAll()){
                if(obj == livro1){
                    emprestimo.getLivro().add(livro1);
                }
            }
            emprestimoService.save(emprestimo);
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{id}/aluno")
    public ResponseEntity adicionarEmprestimoAluno(@PathVariable Long id, Long aluno) {
        Optional<Emprestimo> optionalEmprestimo = Optional.ofNullable(emprestimoService.findById(id));
        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            Aluno obj = alunoService.findByID(aluno);
            for(Aluno aluno1 : alunoService.findAll()){
                if(obj == aluno1){
                    aluno1.getEmprestimos().add(emprestimo);
                    alunoService.save(aluno1);
                }
            }
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/professor")
    public ResponseEntity adicionarEmprestimoProfessor(@PathVariable Long id, Long professor) {
        Optional<Emprestimo> optionalEmprestimo = Optional.ofNullable(emprestimoService.findById(id));
        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            Professor obj = professorService.findByID(professor);
            for(Professor professor1 : professorService.findAll()){
                if(obj == professor1){
                    professor1.getEmprestimos().add(emprestimo);
                    professorService.save(professor1);
                }
            }
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Login login){
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login));
    }

    @GetMapping
    public List<Login> findAll(){
        return loginService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(loginService.findById(id));
    }

    @PutMapping
    public ResponseEntity update (@RequestBody Login login){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.save(login));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        loginService.deleteLogin(id);
    }
}

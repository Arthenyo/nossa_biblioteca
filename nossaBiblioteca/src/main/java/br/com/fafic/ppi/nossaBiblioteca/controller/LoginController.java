package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.Pessoa;
import br.com.fafic.ppi.nossaBiblioteca.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity login (@RequestBody Login login ){
        try {
            Pessoa p = loginService.buscar(login.getUsuario(),login.getSenha());
            return ResponseEntity.ok(p);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }


    }
}

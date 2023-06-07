package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.Pessoa;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public Pessoa buscar(String usuario, String senha){
        return loginRepository.findByPessoa(usuario,senha)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario nao Localizado"));
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Login getLoginById(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Login nao encontrado" + id));
    }

    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    public Login updateLogin(Long id, Login login) {
        Login login1 = loginRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Login nao encontrado" + id));
        return loginRepository.save(login);
    }

    public void deleteLogin(Long id) {
        Login login = loginRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Login nao encontrado" + id));
        loginRepository.delete(login);
    }
}

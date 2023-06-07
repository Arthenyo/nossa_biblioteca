package br.com.fafic.ppi.nossaBiblioteca.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.login.usuario =:usuario and p.login.senha =:senha")
    Optional<Pessoa> findByPessoa(String usuario, String senha);
}

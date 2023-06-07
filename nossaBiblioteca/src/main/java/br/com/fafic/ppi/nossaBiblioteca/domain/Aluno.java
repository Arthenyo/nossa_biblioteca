package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;

import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("Aluno")
@NoArgsConstructor
public class Aluno extends Pessoa{

    private String curso;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Aluno_id")
    private List<Emprestimo> emprestimos;

    public Aluno(String nome, String cpf, String matricula, GeneroEnum genero, Endereco endereco, Contato contato, Login login, String curso, List<Emprestimo> emprestimos) {
        super(nome, cpf, matricula, genero, endereco, contato, login);
        this.curso = curso;
        this.emprestimos = emprestimos;
    }
}

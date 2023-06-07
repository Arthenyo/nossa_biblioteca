package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bibliotecario_id")
    private Bibliotecario bibliotecario;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "biblioteca_id")
    private List<Livro> livros;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "biblioteca_id")
    private List<Aluno> alunos;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "biblioteca_id")
    private List<Professor> professores;

    public Biblioteca(String nome, Bibliotecario bibliotecario, List<Livro> livros, List<Aluno> alunos, List<Professor> professores) {
        this.nome = nome;
        this.bibliotecario = bibliotecario;
        this.livros = livros;
        this.alunos = alunos;
        this.professores = professores;
    }
}

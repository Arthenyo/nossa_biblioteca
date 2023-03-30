package br.com.fafic.ppi.nossaBiblioteca.domain;

import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Bibliotecario bibliotecario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Livro> livros;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Aluno> alunos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Professor> professores;
}

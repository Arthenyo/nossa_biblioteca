package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorempretimo = 0.0;
    private LocalDate dataDoEmprestimo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emprestimo_id")
    private List<Livro> livro;

    public Emprestimo(Double valorempretimo, LocalDate dataDoEmprestimo, List<Livro> livro) {
        this.valorempretimo = valorempretimo;
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.livro = livro;
    }
}

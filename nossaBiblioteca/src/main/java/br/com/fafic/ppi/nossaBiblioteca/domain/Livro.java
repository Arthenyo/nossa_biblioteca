package br.com.fafic.ppi.nossaBiblioteca.domain;

import br.com.fafic.ppi.nossaBiblioteca.enums.AreaEnum;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank
        @Column(unique = true)
        private String isbn;
        @NotBlank
        @Size(min = 2, message = "Numero de caracteres invalido")
        private String nome;
        @Enumerated(EnumType.STRING)
        private AreaEnum area;
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "emprestimo_id")
        private Emprestimo emprestimo;
}

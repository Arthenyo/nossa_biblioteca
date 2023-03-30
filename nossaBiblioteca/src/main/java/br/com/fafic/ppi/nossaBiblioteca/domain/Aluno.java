package br.com.fafic.ppi.nossaBiblioteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("Aluno")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno extends Pessoa{

    private String curso;
}

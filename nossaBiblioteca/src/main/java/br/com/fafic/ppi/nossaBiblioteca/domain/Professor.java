package br.com.fafic.ppi.nossaBiblioteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Professor extends Pessoa{

    private String curso;
}

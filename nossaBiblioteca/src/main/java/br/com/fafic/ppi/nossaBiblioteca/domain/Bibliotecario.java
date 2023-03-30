package br.com.fafic.ppi.nossaBiblioteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("Bibliotecario")
@AllArgsConstructor
@Builder
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Bibliotecario extends Pessoa{

}

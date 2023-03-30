package br.com.fafic.ppi.nossaBiblioteca.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O campo rua nao pode estar em branco!!")
    private String rua;
    private Integer numero;
    @NotBlank(message = "O campo bairro nao pode estar em branco!!")
    private String bairro;
    @NotBlank(message = "O campo cidade nao pode estar em branco!!")
    private String cidade;
    @Size(max = 2,message = "numero maximo de caracteres é 2")
    @NotBlank(message = "O campo uf nao pode estar em branco!!")
    private String uf;

}

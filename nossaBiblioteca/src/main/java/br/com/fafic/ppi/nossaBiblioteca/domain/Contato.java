package br.com.fafic.ppi.nossaBiblioteca.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O campo email nao pode estar em branco!!")
    @Email(message = "Email incorreto")
    private String email;
    @NotBlank(message = "O campo numero nao pode estar em branco!!")
    @Size(max = 12,message = "Numero incorreto")
    private String numero;
}

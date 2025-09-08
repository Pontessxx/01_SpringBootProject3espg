package br.com.fiap3espg.spring_boot_project.aluno;

import br.com.fiap3espg.spring_boot_project.endereco.Endereco;
import br.com.fiap3espg.spring_boot_project.instrutor.Instrutor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Column(unique = true, nullable = false)
    private String cpf;

    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaCNH categoria;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor; // aluno vinculado a um instrutor
}

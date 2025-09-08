package br.com.fiap3espg.spring_boot_project.aluno;

import br.com.fiap3espg.spring_boot_project.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DadosCadastroAluno(
        @NotBlank String nome,
        @NotBlank String cpf,
        @Past LocalDate dataNascimento,
        @NotNull CategoriaCNH categoria,
        @NotNull Endereco endereco,
        @NotNull Long instrutorId
) {}
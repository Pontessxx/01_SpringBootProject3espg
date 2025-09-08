package br.com.fiap3espg.spring_boot_project.aluno;

import java.time.LocalDate;

public record DadosListagemAluno(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        CategoriaCNH categoria,
        String instrutorNome
) {
    public DadosListagemAluno(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataNascimento(),
                aluno.getCategoria(),
                aluno.getInstrutor() != null ? aluno.getInstrutor().getNome() : null
        );
    }
}

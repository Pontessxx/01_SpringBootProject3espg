package br.com.fiap3espg.spring_boot_project.aluno;

import br.com.fiap3espg.spring_boot_project.instrutor.Instrutor;
import br.com.fiap3espg.spring_boot_project.instrutor.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    // Cadastrar aluno
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        Instrutor instrutor = instrutorRepository.findById(dados.instrutorId())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));

        Aluno aluno = new Aluno(
                null,
                dados.nome(),
                dados.cpf(),
                dados.dataNascimento(),
                dados.categoria(),
                dados.endereco(),
                instrutor
        );
        alunoRepository.save(aluno);
    }

    // Listar alunos (com paginação)
    @GetMapping
    public Page<DadosListagemAluno> listar(Pageable paginacao) {
        return alunoRepository.findAll(paginacao).map(DadosListagemAluno::new);
    }
}
package com.americanas.testes.cobrerturatestes.services;

import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import com.americanas.testes.cobrerturatestes.services.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Marcus");
        pessoa.setDataNascimento("23/03/1987");
        pessoa.setCpf("124.998.954-20");
        pessoa.setEmail("mvoliveirajus@gmail.com");
        pessoa.setTelefone("21 96428-5551");
        pessoa.setSaldo(300.00);

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);

        assertEquals(pessoa, pessoaSalva);
    }

    @Test
    public void testBuscarPessoaPorId() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Marcus");
        pessoa.setDataNascimento("23/03/1987");
        pessoa.setCpf("124.998.954-20");
        pessoa.setEmail("mvoliveirajus@gmail.com");
        pessoa.setTelefone("21 96428-5551");
        pessoa.setSaldo(300.00);

        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> pessoaEncontrada = pessoaService.buscarPessoaPorId(id);

        assertEquals(pessoa, pessoaEncontrada.get());
    }

    @Test
    public void testAtualizarPessoa() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Marcus");
        pessoa.setDataNascimento("23/03/1987");
        pessoa.setCpf("124.998.954-20");
        pessoa.setEmail("mvoliveirajus@gmail.com");
        pessoa.setTelefone("21964285551");
        pessoa.setSaldo(300.00);

        Pessoa pessoaAtualizada = new Pessoa();
        pessoaAtualizada.setNome("João Silva");
        pessoa.setDataNascimento("03/05/1990");
        pessoaAtualizada.setCpf("124.111.547-08");
        pessoaAtualizada.setEmail("joao.silva@teste.com");
        pessoaAtualizada.setTelefone("21965998383");
        pessoaAtualizada.setSaldo(200.0);

        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        pessoaService.atualizarPessoa(id, pessoaAtualizada);

        assertEquals(pessoaAtualizada.getNome(), pessoa.getNome());
        assertEquals(pessoaAtualizada.getDataNascimento(), pessoa.getDataNascimento());
        assertEquals(pessoaAtualizada.getCpf(), pessoa.getCpf());
        assertEquals(pessoaAtualizada.getEmail(), pessoa.getEmail());
        assertEquals(pessoaAtualizada.getTelefone(), pessoa.getTelefone());
        assertEquals(pessoaAtualizada.getSaldo(), pessoa.getSaldo());
    }

    @Test
    public void testDeletarPessoa() {
        Long id = 1L;

        pessoaService.deletarPessoa(id);

        verify(pessoaRepository, times(1)).deleteById(id);
    }
}

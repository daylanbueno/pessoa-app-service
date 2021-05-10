package com.dev.bueno.pessoaapp.resource;

import com.dev.bueno.pessoaapp.entity.Pessoa;
import com.dev.bueno.pessoaapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.incluir(pessoa);
    }

    @PutMapping
    public Pessoa alterar(@RequestBody Pessoa pessoa) {
        return pessoaService.alterar(pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void deletar(@PathVariable Long idPessoa) {
        pessoaService.deletar(idPessoa);
    }

    @GetMapping
    public Collection<Pessoa> buscarTodas() {
        return pessoaService.buscaTodas();
    }

    @GetMapping("/{idPessoa}")
    public Pessoa buscarPessoaPorId(@PathVariable Long idPessoa) {
        return  pessoaService.buscarPessoaPorId(idPessoa);
    }

    @GetMapping("/nome")
    public List<Pessoa> buscarPessoasPorPorteDoNome(@RequestParam String nome) {
        return pessoaService.buscarPessoasPorPorteDoNome(nome);
    }
}

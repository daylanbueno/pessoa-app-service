package com.dev.bueno.pessoaapp.service;

import com.dev.bueno.pessoaapp.entity.Pessoa;
import com.dev.bueno.pessoaapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa incluir(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaPorId(Long idPessoa) {
       return pessoaRepository.findById(idPessoa).
               orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_GATEWAY,"Não encontrou uma pessoa para o id informado"));
    }

    public Collection<Pessoa> buscaTodas() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoa -> {
            pessoas.add(pessoa);
        });
        return pessoas;
    }

    public Pessoa alterar(Pessoa pessoa) {
       return pessoaRepository.save(pessoa);
    }

    public void deletar(Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
    }

    public List<Pessoa> buscarPessoasPorPorteDoNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }
}

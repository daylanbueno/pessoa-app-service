package com.dev.bueno.pessoaapp.repository;

import com.dev.bueno.pessoaapp.entity.Pessoa;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends ElasticsearchRepository<Pessoa, Long> {
    List<Pessoa> findByNome(@Param("nome") String nome);
}

package com.dev.bueno.pessoaapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeAlias("pessoa")
@Document(indexName = "pessoa")
public class Pessoa {
    @Id
    private Long id;
    private String nome;
}

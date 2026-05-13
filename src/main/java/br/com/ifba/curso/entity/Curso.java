package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cursos")
public class Curso extends PersistenceEntity implements Serializable {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_curso", nullable = false, unique = true)
    private String codigoCurso;

    @Column(name = "ativo")
    private boolean ativo;

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
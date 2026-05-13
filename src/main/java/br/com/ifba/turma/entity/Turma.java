package br.com.ifba.turma.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma extends PersistenceEntity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_turma", nullable = false, unique = true)
    private String codigoTurma;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "ativa")
    private boolean ativa;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
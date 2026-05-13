package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class PersistenceEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
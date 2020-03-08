package br.com.caelum.clines.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String identifier;

    @NotNull
    private String name;

    Airport() {
    }

    public Airport(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
}

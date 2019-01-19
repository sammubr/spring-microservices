package br.com.sammubr.entidades.estado;

import br.com.sammubr.entidades.pais.PaisEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estado", uniqueConstraints = {@UniqueConstraint(columnNames = {"descricao", "pais_id"}), @UniqueConstraint(columnNames = {"sigla", "pais_id"})})
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    @NotNull
    @Size(max = 2)
    @Column(name = "sigla", length = 2, nullable = false)
    private String sigla;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "pais_id", nullable = false)
    private PaisEntity pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
}

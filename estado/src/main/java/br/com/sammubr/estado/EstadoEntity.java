package br.com.sammubr.estado;

import br.com.sammubr.pais.PaisEntity;

public class EstadoEntity {

    private Long id;
    private String descricao;
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

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
}

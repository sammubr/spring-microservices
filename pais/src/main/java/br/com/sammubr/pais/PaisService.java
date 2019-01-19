package br.com.sammubr.pais;

import org.springframework.stereotype.Service;

@Service
public class PaisService {

    public PaisEntity teste() {

        PaisEntity pais = new PaisEntity();

        pais.setId(1L);
        pais.setDescricao("Brasil");

        return pais;
    }

}

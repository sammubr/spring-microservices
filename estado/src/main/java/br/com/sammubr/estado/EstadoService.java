package br.com.sammubr.estado;

import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    public EstadoEntity teste() {

        EstadoEntity pais = new EstadoEntity();

        pais.setId(1L);
        pais.setDescricao("Rio Grande do Sul");

        return pais;
    }

}

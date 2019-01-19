package br.com.sammubr.estado;

import br.com.sammubr.pais.PaisEntity;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    public EstadoEntity teste() {

        PaisEntity pais = new PaisEntity();
        pais.setId(1L);
        pais.setDescricao("Brasil");

        EstadoEntity estado = new EstadoEntity();

        estado.setId(1L);
        estado.setDescricao("Rio Grande do Sul");
        estado.setPais(pais);

        return estado;
    }

}

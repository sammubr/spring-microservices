package br.com.sammubr.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoResource {

    private EstadoService service;

    @Autowired
    public EstadoResource(EstadoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoEntity> teste() {

        EstadoEntity teste = service.teste();
        return ResponseEntity
                .ok()
                .body(teste);

    }


}

package br.com.sammubr.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisResource {

    private PaisService service;

    @Autowired
    public PaisResource(PaisService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaisEntity> teste() {

        PaisEntity teste = service.teste();
        return ResponseEntity
                .ok()
                .body(teste);

    }


}

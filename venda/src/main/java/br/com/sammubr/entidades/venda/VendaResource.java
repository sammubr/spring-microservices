package br.com.sammubr.entidades.venda;

import br.com.sammubr.entidades.venda.VendaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class VendaResource {

    private VendaService vendaService;

    @Autowired
    public VendaResource(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaEntity> create(@Valid @RequestBody VendaEntity entidade, HttpServletRequest request) throws URISyntaxException {

        VendaEntity entidadePersistida = vendaService.create(entidade);
        return ResponseEntity
                .created(new URI(request.getServletPath() + "/" + entidadePersistida.getId()))
                .body(entidadePersistida);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaEntity> update(@PathVariable Long id, @Valid @RequestBody VendaEntity entidade) {

        VendaEntity entidadePersistida = vendaService.update(id, entidade);
        return ResponseEntity
                .ok()
                .body(entidadePersistida);

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VendaEntity>> findAll(Pageable pageable) {

        Page<VendaEntity> page = vendaService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(page.getContent());

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<VendaEntity>> findOne(@PathVariable Long id) {

        Optional<VendaEntity> entidade = vendaService.findOne(id);
        return ResponseEntity
                .ok()
                .body(entidade);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        vendaService.deleteOne(id);
        return ResponseEntity
                .ok()
                .build();

    }
    
}

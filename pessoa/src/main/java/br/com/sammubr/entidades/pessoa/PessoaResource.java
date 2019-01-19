package br.com.sammubr.entidades.pessoa;

import br.com.sammubr.entidades.pessoa.PessoaEntity;
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
public class PessoaResource {

    private PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaEntity> create(@Valid @RequestBody PessoaEntity entidade, HttpServletRequest request) throws URISyntaxException {

        PessoaEntity entidadePersistida = pessoaService.create(entidade);
        return ResponseEntity
                .created(new URI(request.getServletPath() + "/" + entidadePersistida.getId()))
                .body(entidadePersistida);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaEntity> update(@PathVariable Long id, @Valid @RequestBody PessoaEntity entidade) {

        PessoaEntity entidadePersistida = pessoaService.update(id, entidade);
        return ResponseEntity
                .ok()
                .body(entidadePersistida);

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PessoaEntity>> findAll(Pageable pageable) {

        Page<PessoaEntity> page = pessoaService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(page.getContent());

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<PessoaEntity>> findOne(@PathVariable Long id) {

        Optional<PessoaEntity> entidade = pessoaService.findOne(id);
        return ResponseEntity
                .ok()
                .body(entidade);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        pessoaService.deleteOne(id);
        return ResponseEntity
                .ok()
                .build();

    }
    
}

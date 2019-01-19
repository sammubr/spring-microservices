package br.com.sammubr.entidades.produto;

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
public class ProdutoResource {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoEntity> create(@Valid @RequestBody ProdutoEntity entidade, HttpServletRequest request) throws URISyntaxException {

        ProdutoEntity entidadePersistida = produtoService.create(entidade);
        return ResponseEntity
                .created(new URI(request.getServletPath() + "/" + entidadePersistida.getId()))
                .body(entidadePersistida);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @Valid @RequestBody ProdutoEntity entidade) {

        ProdutoEntity entidadePersistida = produtoService.update(id, entidade);
        return ResponseEntity
                .ok()
                .body(entidadePersistida);

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoEntity>> findAll(Pageable pageable) {

        Page<ProdutoEntity> page = produtoService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(page.getContent());

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ProdutoEntity>> findOne(@PathVariable Long id) {

        Optional<ProdutoEntity> entidade = produtoService.findOne(id);
        return ResponseEntity
                .ok()
                .body(entidade);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        produtoService.deleteOne(id);
        return ResponseEntity
                .ok()
                .build();

    }
    
}

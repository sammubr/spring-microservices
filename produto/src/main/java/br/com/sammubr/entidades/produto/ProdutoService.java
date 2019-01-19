package br.com.sammubr.entidades.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity create(ProdutoEntity itemParaPersistir) {
        return produtoRepository.saveAndFlush(itemParaPersistir);
    }

    public ProdutoEntity update(Long id, ProdutoEntity itemParaPersistir) {
        return produtoRepository.saveAndFlush(itemParaPersistir);
    }

    public Page<ProdutoEntity> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Optional<ProdutoEntity> findOne(Long id) {
        return produtoRepository.findById(id);
    }

    public void deleteOne(Long id) {
        produtoRepository.deleteById(id);
    }
}

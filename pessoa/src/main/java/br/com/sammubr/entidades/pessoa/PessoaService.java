package br.com.sammubr.entidades.pessoa;

import br.com.sammubr.entidades.pessoa.PessoaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaEntity create(PessoaEntity itemParaPersistir) {
        return pessoaRepository.saveAndFlush(itemParaPersistir);
    }

    public PessoaEntity update(Long id, PessoaEntity itemParaPersistir) {
        return pessoaRepository.saveAndFlush(itemParaPersistir);
    }

    public Page<PessoaEntity> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public Optional<PessoaEntity> findOne(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deleteOne(Long id) {
        pessoaRepository.deleteById(id);
    }
}

package br.com.sammubr.entidades.venda;

import br.com.sammubr.entidades.venda.VendaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class VendaService {

    private VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public VendaEntity create(VendaEntity itemParaPersistir) {
        return vendaRepository.saveAndFlush(itemParaPersistir);
    }

    public VendaEntity update(Long id, VendaEntity itemParaPersistir) {
        return vendaRepository.saveAndFlush(itemParaPersistir);
    }

    public Page<VendaEntity> findAll(Pageable pageable) {
        return vendaRepository.findAll(pageable);
    }

    public Optional<VendaEntity> findOne(Long id) {
        return vendaRepository.findById(id);
    }

    public void deleteOne(Long id) {
        vendaRepository.deleteById(id);
    }
}

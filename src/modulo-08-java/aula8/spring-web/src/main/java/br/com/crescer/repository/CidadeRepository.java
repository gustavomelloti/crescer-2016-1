package br.com.crescer.repository;

import br.com.crescer.entity.Cidade;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    public List<Cidade> findAllByOrderByIdAsc();
    public Page<Cidade> findAll(Pageable pageable);
}


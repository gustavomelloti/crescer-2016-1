package br.com.crescer.repository;

import br.com.crescer.entity.Cidade;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    public List<Cidade> findAllByOrderByIdAsc();
}



package br.com.crescer.service;

import br.com.crescer.entity.Cidade;
import br.com.crescer.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository cidadeRepository;

    public void save(Cidade c) {
        cidadeRepository.save(c);
    }
    
    public void delete(long id) {
        cidadeRepository.delete(id);
    }
    
    public Iterable<Cidade> findAll() {
        return cidadeRepository.findAllByOrderByIdAsc();
    }
    
    public Page<Cidade> findAllPagined(int page, int size) {
        return cidadeRepository.findAll(new PageRequest(page, size));
    }
    
    public Cidade findById(long id) {
        return cidadeRepository.findOne(id);
    }
}

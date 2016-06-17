package br.com.crescer.service;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public void save(Pessoa p) {
        pessoaRepository.save(p);
    }
    
    public void delete(long id) {
        pessoaRepository.delete(id);
    }
}

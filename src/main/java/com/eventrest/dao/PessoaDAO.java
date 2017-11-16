package com.eventrest.dao;

import com.eventrest.model.Pessoa;
import java.util.List;


/**
 *
 * @author renanhr
 */

public interface PessoaDAO extends DAO<Pessoa, Long> {

    List<Pessoa> findByNome(String nome);
    
}

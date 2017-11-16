package com.eventrest.dao;

import com.eventrest.model.Atividade;
import java.util.List;


/**
 *
 * @author renanhr
 */

public interface AtividadeDAO extends DAO<Atividade, Long> {
    
    List<Atividade> findByNome(String nome);

}

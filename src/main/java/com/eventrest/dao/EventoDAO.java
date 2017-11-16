package com.eventrest.dao;

import com.eventrest.model.Evento;
import java.util.List;


/**
 *
 * @author renanhr
 */

public interface EventoDAO extends DAO<Evento, Long> {

    List<Evento> findByNome(String nome);
    
}

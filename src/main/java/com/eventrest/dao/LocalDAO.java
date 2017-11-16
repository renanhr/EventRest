package com.eventrest.dao;

import com.eventrest.model.Local;
import java.util.List;


/**
 *
 * @author renanhr
 */

public interface LocalDAO extends DAO<Local, Long> {

    List<Local> findByDescricao(String descricao);
    
    Local findByPoints(String latitude, String longitude);
}

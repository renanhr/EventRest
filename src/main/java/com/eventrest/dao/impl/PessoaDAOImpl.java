package com.eventrest.dao.impl;

import com.eventrest.dao.GenericDAO;
import com.eventrest.dao.PessoaDAO;
import com.eventrest.model.Pessoa;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author renanhr
 */
@ApplicationScoped
public class PessoaDAOImpl extends GenericDAO<Pessoa, Long> implements PessoaDAO {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaDAOImpl.class);

    public PessoaDAOImpl() {
        super(Pessoa.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Pessoa.findByNome", Pessoa.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}

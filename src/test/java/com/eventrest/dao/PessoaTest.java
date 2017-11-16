package com.eventrest.dao;

import com.eventrest.dao.impl.PessoaDAOImpl;
import com.eventrest.model.Pessoa;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author renan
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(PessoaDAOImpl.class)
public class PessoaTest {

    private static final Pessoa RENAN;

    static {
        RENAN = new Pessoa("Renan", "renan@renan.com.br", "98048682", "Bacharel em CC", new Date());
    }

    @Inject
    private PessoaDAO pessoaDAO;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(pessoaDAO);
    }

    @Test
    public void saveTest() {
        List<Pessoa> pessoas = pessoaDAO.findByNome(RENAN.getNome());
        if (pessoas == null || pessoas.isEmpty()) {
            pessoaDAO.save(RENAN);
        }

        pessoas = pessoaDAO.findByNome(RENAN.getNome());
        Assert.assertNotNull(pessoas);
        Assert.assertFalse(pessoas.isEmpty());
    }
}

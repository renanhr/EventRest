package com.eventrest.dao;

import com.eventrest.dao.impl.AtividadeDAOImpl;
import com.eventrest.dao.impl.EventoDAOImpl;
import com.eventrest.dao.impl.PessoaDAOImpl;
import com.eventrest.model.Atividade;
import com.eventrest.model.Evento;
import com.eventrest.model.Pessoa;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author renan
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({AtividadeDAOImpl.class, EventoDAOImpl.class, PessoaDAOImpl.class})
public class AtividadeTest {

    private static Atividade halloween;

    static {
        halloween = new Atividade("Halloween", "Halloween", "Praia", new Date(), new Date(), null, null);
    }

    @Inject
    private AtividadeDAO atividadeDAO;

    @Inject
    private EventoDAO eventoDAO;

    @Inject
    private PessoaDAO pessoaDAO;

    private List<Evento> eventos;
    private List<Pessoa> pessoas;

    @Before
    public void buscaObjetos() {
        eventos = eventoDAO.findAll();
        pessoas = pessoaDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(atividadeDAO);
    }

    @Test
    public void saveTest() {
        List<Atividade> atividades = atividadeDAO.findByNome(halloween.getNome());
        if (atividades == null || atividades.isEmpty()) {
            Assert.assertFalse(eventos.isEmpty());
            Assert.assertFalse(pessoas.isEmpty());

            halloween.setEvento(eventos.get(0));
            halloween.setPessoa(pessoas.get(0));
            atividadeDAO.save(halloween);
        }

        atividades = atividadeDAO.findByNome(halloween.getNome());
        Assert.assertNotNull(atividades);
        Assert.assertFalse(atividades.isEmpty());
    }
}

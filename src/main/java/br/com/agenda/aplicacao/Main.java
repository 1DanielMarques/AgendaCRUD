package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;
import java.util.Date;

/**
 *
 * @author mDanielSE
 */
public class Main {

    public static void main(String[] args) {
        ContatoDAO contatoDao = new ContatoDAO();
        
        Contato contato = new Contato();
        contato.setNome("MARIA");
        contato.setIdade(25);
        contato.setDataCadastro(new Date());
        
        contatoDao.save(contato);
                
        
        
        
    }
    
}

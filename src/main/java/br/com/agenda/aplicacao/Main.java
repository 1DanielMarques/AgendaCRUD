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

        /*Contato contato = new Contato();
        contato.setNome("Beatriz");
        contato.setIdade(35);
        contato.setSexo("F");
        contato.setProfissao("Software Engineer");
        contato.setDataCadastro(new Date());
        
        contatoDao.save(contato); */
        // Ler registros
        for (Contato c : contatoDao.getContatos()) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("Sexo: " + c.getSexo());
            System.out.println("Profissao: " + c.getProfissao());
            System.out.println("Data de Cadastro: " + c.getDataCadastro());
            System.out.println("----------------------------------------");
        }

    }

}

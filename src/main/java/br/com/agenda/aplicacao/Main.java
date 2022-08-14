package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mDanielSE
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ContatoDAO contatoDao = new ContatoDAO();
        Scanner sc = new Scanner(System.in);
        int opcao, idade, id;
        String nome, sexo, profissao, aux, opcaoDelete;
        Contato contato = new Contato();
        do {

            System.out.println("1 - Salvar contato");
            System.out.println("2 - Mostrar contatos");
            System.out.println("3 - Atualizar contato");
            System.out.println("4 - Excluir contato");
            System.out.println("9 - Finalizar");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("---SALVAR CONTATO---");
                    System.out.print("NOME: ");
                    aux = sc.nextLine();
                    nome = sc.nextLine();
                    System.out.print("IDADE: ");
                    idade = sc.nextInt();
                    System.out.print("SEXO F/M: ");
                    sexo = sc.next();
                    System.out.print("PROFISSÃO: ");
                    aux = sc.nextLine();
                    profissao = sc.nextLine();
                    contato.setNome(nome);
                    contato.setIdade(idade);
                    contato.setSexo(sexo);
                    contato.setProfissao(profissao);
                    contato.setDataCadastro(new Date());

                    contatoDao.create(contato);
                    break;
                case 2:
                    for (Contato c : contatoDao.read()) {
                        System.out.println("ID: " + c.getId());
                        System.out.println("NOME: " + c.getNome());
                        System.out.println("IDADE: " + c.getIdade());
                        System.out.println("SEXO: " + c.getSexo());
                        System.out.println("PROFISSÃO: " + c.getProfissao());
                        System.out.println("DATA DE CADASTRO: " + c.getDataCadastro());
                        System.out.println("------------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("---ATUALIZAR CONTATO---");
                    System.out.print("Informe o ID do Contato: ");
                    id = sc.nextInt();
                    System.out.print("NOME: ");
                    aux = sc.nextLine();
                    nome = sc.nextLine();
                    System.out.print("IDADE: ");
                    idade = sc.nextInt();
                    System.out.print("SEXO F/M: ");
                    sexo = sc.next();
                    System.out.print("PROFISSÃO: ");
                    aux = sc.nextLine();
                    profissao = sc.nextLine();
                    contato.setNome(nome);
                    contato.setIdade(idade);
                    contato.setSexo(sexo);
                    contato.setProfissao(profissao);
                    contato.setDataCadastro(new Date());
                    contato.setId(id);
                    contatoDao.update(contato);
                    break;
                case 4:
                    System.out.println("---EXCLUIR CONTATO---");
                    System.out.print("Informe o ID do Contato: ");
                    id = sc.nextInt();
                    System.out.println("TEM CERTEZA QUE DESJA EXCLUIR O CONTATO? S/N");
                    opcaoDelete = sc.next();
                    if (opcaoDelete.equals("S") || opcaoDelete.equals("s")) {
                        contatoDao.delete(id);
                    } else {
                        System.out.println("---OPERAÇÃO CANCELADA---");
                    }
                    break;
            }
        } while (opcao != 9);
    }

}

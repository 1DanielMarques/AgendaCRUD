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

    public static void main(String[] args) {
        ContatoDAO contatoDao = new ContatoDAO();
        Scanner sc = new Scanner(System.in);
        int opcao, idade;
        String nome, sexo, profissao, aux;

        do {
            System.out.println("1 - Salvar contato");
            System.out.println("2 - Ler contatos");
            System.out.println("3 - Atualizar contato");
            System.out.println("4 - Excluir contato");
            System.out.println("9 - Finalizar");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    Contato contato = new Contato();
                    System.out.print("Informe o nome: ");
                    aux = sc.nextLine();
                    nome = sc.nextLine();

                    System.out.print("Idade: ");
                    idade = sc.nextInt();
                    System.out.print("Sexo F/M: ");
                    sexo = sc.next();
                    System.out.print("Profissao: ");
                    aux = sc.nextLine();
                    profissao = sc.nextLine();
                    contato.setNome(nome);
                    contato.setIdade(idade);
                    contato.setSexo(sexo);
                    contato.setProfissao(profissao);
                    contato.setDataCadastro(new Date());

                    contatoDao.save(contato);
                    break;
                case 2:
                    for (Contato c : contatoDao.getContatos()) {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Idade: " + c.getIdade());
                        System.out.println("Sexo: " + c.getSexo());
                        System.out.println("Profissao: " + c.getProfissao());
                        System.out.println("Data de Cadastro: " + c.getDataCadastro());
                        System.out.println("----------------------------------------");
                    }

                    break;
                case 3:

                    break;
                case 4:

                    break;

            }

        } while (opcao != 9);
    }

}

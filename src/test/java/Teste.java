import dao.UsuarioDao;
import model.Usuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {

        System.out.println("==== LISTA DE TAREFAS ====\n1 - CADASTRO DE USUARIOS\n2 - LISTA DE USUARIOS\n3 - ALTERAR USUARIO\n4 - DELETAR USUARIO\n5 - SAIR");
        int opcao = scan.nextInt();
        scan.nextLine();

            switch (opcao) {

                case 1:

                    UsuarioDao usd1 = new UsuarioDao();
                    Usuario us = new Usuario();

                    System.out.println("EMAIL: ");
                    String email1 = scan.nextLine();

                    System.out.println("SENHA: ");
                    String senha1 = scan.nextLine();

                    us.setEmail(email1);
                    us.setSenha(senha1);

                    usd1.salvar(us);

                    break;

                case 2:

                    UsuarioDao dao2 = new UsuarioDao();

                    for (Usuario listus : dao2.findAll()) {
                        System.out.println(listus);
                    }

                    break;

                case 3:

                    UsuarioDao usd3 = new UsuarioDao();
                    Usuario us3 = new Usuario();

                    System.out.println("INFORME O ID REFERENTE AO USUARIO QUE DESEJA ALTERAR");
                    int id3 = scan.nextInt();
                    scan.nextLine();

                    System.out.println("NOVO EMAIL");
                    String email3 = scan.nextLine();

                    System.out.println("NOVO EMAIL");
                    String senha3 = scan.nextLine();

                    us3.setId(id3);
                    us3.setEmail(email3);
                    us3.setSenha(senha3);

                    usd3.update(us3);

                    break;

                case 4:

                    UsuarioDao usd4 = new UsuarioDao();

                    System.out.println("INFORME O ID REFERENTE AO USUARIO QUE DESEJA REMOVER");
                    int id4 = scan.nextInt();

                    usd4.delete(id4);

                    break;

                case 5 :
                    System.out.println("SAINDO...");
                    rodando = false;

                    break;
            }
        }
    }
}

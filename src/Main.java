import DAO.TarefasDAO;
import Model.Tarefas;

import java.util.Scanner;
import java.util.List;

public class Main{
    public static void main(String[] args){

        //RELEMBRANDO:
        //INSTANCIAR UM OBJETO --> CRIAR UM OBJETO REAL NA MEMÓRIA A PARTIR DE UMA CLASSE
        //ESSA LINHA ESTÁ CRIANDO O OBJETO E DEPOIS USAMOS ESSE OBJETO PARA CHAMAR OS MÉTODOS
        TarefasDAO dao = new TarefasDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     BEM-VINDOS AO TO-DO!     ║");
        System.out.println("╚══════════════════════════════╝");

        while (opcao != 0){
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Buscar tarefa por ID");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); //LIMPA O BUFFER DO ENTER --> DEIXAR MENOS POLUÍDO

            switch (opcao){
                case 1:
                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    Tarefas nova = new Tarefas(titulo, descricao);
                    dao.inserir(nova);
                    break;

                case 2:
                    List<Tarefas> tarefas = dao.listarTodas();
                    if(tarefas.isEmpty()){
                        System.out.println("Nenhuma tarefa encontrada.");
                    } else{
                        System.out.println("\n Lista de tarefas: ");
                        for(Tarefas t : tarefas){
                            System.out.println(t);
                        }
                      }
                    break;

                case 3:
                    System.out.print("ID da tarefa a concluir: ");
                    int idConcluir = scanner.nextInt();
                    dao.marcaConcluida(idConcluir);
                    break;

                case 4:
                    System.out.print("ID da tarefa a excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir);
                    break;

                case 5:
                    System.out.print("ID da tarefa a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Tarefas encontrada = dao.buscarPorId(idBuscar);
                    if(encontrada != null){
                        System.out.println("\n Tarefa encontrada: ");
                        System.out.println(encontrada);
                    } else{
                        System.out.println("Nenhuma tarefa com esse ID foi encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("\nAté logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    }
            }
        scanner.close();
        }
    }

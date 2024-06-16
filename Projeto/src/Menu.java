import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	ArrayList<Funcionario> funcionarios = new ArrayList<>();
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Produto> produtos = new ArrayList<>();
    Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Visualizar Pessoa");
            System.out.println("4. Excluir Pessoa");
            System.out.println("5. Editar Pessoa");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    listarPessoas();
                    break;
                case 3:
                	System.out.println("Digite o nome que queira buscar: ");
                	String nome = leitor.next();
                	
                	visualizarPessoa(nome);	
                    break;
                case 4:
                    excluirPessoa();
                    break;
                case 5:
                    editarPessoa();
                    break;
                case 6:
                    cadastrarProduto();
                    break;
                case 7:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarPessoa() {
        System.out.println("1. Funcionario\n 2. Cliente");
        System.out.println("Escolha o tipo de pessoa: ");
        int tipo = leitor.nextInt();

        if (tipo == 1) {
        	Funcionario funcionario1 = new Funcionario();
        	System.out.print("Nome: ");
            funcionario1.setNome(leitor.next());
            System.out.print("Idade: ");
            funcionario1.setIdade(leitor.nextInt());
            System.out.print("ID: ");
            funcionario1.setId(leitor.nextInt());
            System.out.print("Cargo: ");
            funcionario1.setCargo(leitor.next());
            System.out.print("Salário: ");
            funcionario1.setSalario(leitor.nextDouble());
            
            funcionarios.add(funcionario1);
        } else if (tipo == 2) {
        	Cliente cliente1 = new Cliente();
        	System.out.print("Nome: ");
            cliente1.setNome(leitor.next());
            System.out.print("Idade: ");
            cliente1.setIdade(leitor.nextInt());
            System.out.print("Cliente ID: ");
            cliente1.setClienteId(leitor.nextInt());
            System.out.print("Email: ");
            cliente1.setEmail(leitor.next());
            
            clientes.add(cliente1);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    public void listarPessoas() {
    	System.out.println("Deseja listar 1- Funcionario\n2- Cliente");
    	int escolha = leitor.nextInt();
    	if(escolha == 1) {
    		for (Funcionario f : funcionarios) {
                System.out.println(f.informacoes());
            }
    	}else if(escolha == 2) {
    		for (Cliente c : clientes) {
                System.out.println(c.informacoes());
            }
    	}
    }

    public void visualizarPessoa(String nomePessoa) {
        boolean repetido = true;
        System.out.println("Esse nome é de 1- Funcionario\n2- Cliente");
        int escolha = leitor.nextInt();
        if(escolha == 1) {
        	for(Funcionario f : funcionarios) {
                if(f.getNome().equalsIgnoreCase(nomePessoa)) {
                    System.out.println(f.informacoes());
                    repetido = false;
                }
            }
        }else if(escolha == 2) {
        	for(Cliente c : clientes) {
                if(c.getNome().equalsIgnoreCase(nomePessoa)) {
                	System.out.println(c.informacoes());
                    repetido = false;
                }
            }
        }
        
        if(repetido) {
            System.out.println("Nome digitado não encontrado!\n");
        }
    }

    public void excluirPessoa() {
    	System.out.println("1- Funcionario\t 2- Cliente");
        int escolha = leitor.nextInt();
        System.out.print("Digite o ID da pessoa a ser excluída: ");
        int id = leitor.nextInt();
        
        if(escolha == 1) {
        	for(int i = 0; i < funcionarios.size(); i++) {
                Funcionario f = funcionarios.get(i);
                if(f.getId() == id) {
                    funcionarios.remove(i);
                }
            }
        }else if(escolha == 2) {
        	for(int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                if(c.getClienteId() == id) {
                    clientes.remove(i);
                }
            }
        }
        
    }

    public void editarPessoa() {
    	System.out.println("1. Funcionario\t 2. Cliente");
        System.out.print("Escolha o tipo de pessoa: ");
        int tipo = leitor.nextInt();

        System.out.print("Digite o ID da pessoa a ser editada: ");
        int id = leitor.nextInt();

        if (tipo == 1) {
            Funcionario editarFuncionario = null;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getId() == id) {
                    editarFuncionario = funcionario;
                    break;
                }
            }
            if (editarFuncionario != null) {
                System.out.print("Nome: ");
                editarFuncionario.setNome(leitor.next());
                System.out.print("Idade: ");
                editarFuncionario.setIdade(leitor.nextInt());
                System.out.print("Cargo: ");
                editarFuncionario.setCargo(leitor.next());
                System.out.print("Salário: ");
                editarFuncionario.setSalario(leitor.nextDouble());
               
                
                System.out.println("Funcionario editado!");
                
            } else {
                System.out.println("ID inválido!");
            }
        	}if (tipo == 2) {
	            Cliente editarCliente = null;
	            for (Cliente cliente : clientes) {
	                if (cliente.getClienteId() == id) {
	                	editarCliente = cliente;
	                    break;
                }
            }
            if (editarCliente != null) {
                System.out.print("Nome: ");
                editarCliente.setNome(leitor.next());
                System.out.print("Idade: ");
                editarCliente.setIdade(leitor.nextInt());
                System.out.print("Cliente ID: ");
                editarCliente.setClienteId(leitor.nextInt());
                System.out.print("Email: ");
                editarCliente.setEmail(leitor.next());
                
                System.out.println("Cliente editado!");
            } else {
                System.out.println("ID inválido!");
            }
        }
    }

    public void cadastrarProduto() {
    	Produto produto1 = new Produto();
        System.out.print("Código: ");
        produto1.setCodigo(leitor.nextInt());
        
        System.out.print("Descrição: ");
        produto1.setDescricao(leitor.next());
        
        System.out.print("Preço: ");
        produto1.setPreco(leitor.nextDouble());
        
        produtos.add(produto1);
    }
    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p.informacoes());
        }
    }
}

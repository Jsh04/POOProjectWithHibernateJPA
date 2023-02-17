package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Exception.LojaFerramentasException;
import controller.ClienteController;
import controller.FuncionarioController;
import controller.NotaFiscalController;
import controller.ProdutoController;
import modelo.categoria.Categoria;
import modelo.cliente.Cliente;
import modelo.cliente.ClienteFisico;
import modelo.cliente.ClienteJuridico;
import modelo.funcionario.Funcionario;
import modelo.funcionario.Gerente;
import modelo.funcionario.Vendedor;
import modelo.itensprodutos.ItensProduto;
import modelo.notafiscal.NotaFiscal;
import modelo.produto.Produto;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	private static ClienteController cController = new ClienteController();
	private static FuncionarioController fController = new FuncionarioController();
	private static NotaFiscalController nController = new NotaFiscalController();
	private static ProdutoController pController = new ProdutoController();


	public static void MenuView() {

			boolean sair = true;
			
			do {
				System.out.println("----------------------------------");
				System.out.println("---------------MENU---------------");
				System.out.println("----------------------------------");
				System.out.println("Qual entidade vocÃª quer manipular: ");
				System.out.println("1 - Produto");
				System.out.println("2 - Cliente");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Fazer Pedido");
				System.out.println("5 - Notas Fiscais");
				int opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
					GerenciarProduto();
					break;
				case 2:
					GerenciarCliente();
					break;
				case 3: 
					GerenciarFuncionario();
					break;
				case 4: 
					FazerPedido();
					break;
				case 5:
					GerenciarNotasFiscais();
					break;
					default:
						System.out.println("NÃºmero InvÃ¡lido");
				}
				System.out.println("VocÃª quer sair do programa? (s/n)");
				char sairPrograma = sc.next().toLowerCase().charAt(0);
				if(sairPrograma == 's') {
					sair = false;
				}
			}while(sair);
		}

	private static void GerenciarProduto() {
		
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Listar Produtos");
		System.out.println("3 - Editar Produto");
		System.out.println("4 - Deletar Produto");
		int opcaoProduto = sc.nextInt();
		switch (opcaoProduto) {
		case 1:
			System.out.println("Digite o nome do Produto: ");
			String nome = sc.next();
			System.out.println("Digite o preco do Produto: ");
			Double preco = Double.parseDouble(sc.next());
			System.out.println("Selecione a categoria: ");

			String categoria = sc.next();
			Categoria cat = null;
			try {
				cat = Categoria.valueOf(categoria);
			}catch (Exception e) {
				System.out.println("Erro ao escrever a categoria");
				return;
			}
			pController.CadastrarProduto(new Produto(nome, preco, cat));
			break;
		case 2: 
			pController.ListarProduto();
			break;
		case 3:
			System.out.println("Digite o código do produto que você quer alterar: ");
			int id = sc.nextInt();
			System.out.println("Digite o novo nome do Produto: ");
			String nomeEditado = sc.next();
			System.out.println("Digite o novo preco do Produto: ");
			Double precoEditado = Double.parseDouble(sc.next());
			pController.AlterarProduto(id, nomeEditado, precoEditado);
			break;
			
		case 4:
			System.out.println("Digite o código do produto que você quer deletar: ");
			int idDeletar = sc.nextInt();
			pController.DeletarProduto(idDeletar);
			break;
			default:
				break;
	}
}

	private static void GerenciarCliente() {
	
	System.out.println("1 - Cadastrar Cliente");
	System.out.println("2 - Listar Clientes");
	System.out.println("3 - ALterar Clientes");
	System.out.println("4 - Deletar Clientes");
	int opcao = sc.nextInt();
	switch (opcao) {
		case 1:
			System.out.println("Digite o tipo de conta do Cliente (F/J): ");
			char escolha = sc.next().toLowerCase().charAt(0);
			
			System.out.println("Digite o nome do Cliente: ");
			String nomeCliente = sc.next();
			
			System.out.println("Digite o email: ");
			String email = sc.next();
			
			System.out.println("Digite sua data de nascimento(dd/MM/yyyy): ");
			String data = sc.next();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataNascimento = LocalDate.parse(data, formato);
			
			System.out.println("Digite o endereço: ");
			String endereco = sc.next();
			
			System.out.println("Digite a cidade: ");
			String cidade = sc.next();
			
			System.out.println("Digite o bairro: ");
			String bairro = sc.next();
			
			System.out.println("Digite o Estado: ");
			String estado = sc.next();
			if(escolha == 'f') {
				System.out.println("Digite seu CPF: ");
				String cpf = sc.next();
				System.out.println("Digite seu telefone pessoal: ");
				String telefone = sc.next();
				cController.CadastrarCliente(new ClienteFisico(nomeCliente, email, dataNascimento, endereco, bairro, estado, cidade, cpf, telefone));
			}else {
				System.out.println("Digite o seu CNPJ: ");
				String cnpj = sc.next();
				System.out.println("Digite seu telegone empresarial: ");
				String telefone = sc.next();
				cController.CadastrarCliente(new ClienteJuridico(nomeCliente, email, dataNascimento, endereco, bairro, estado, cidade, cnpj, telefone ));
			}
			break;
		case 2:
			cController.ListarCliente();
			break;
		case 3: 
			System.out.println("Digite o tipo de conta do Cliente (F/J): ");
			char escolhaEdita = sc.next().toLowerCase().charAt(0);
			
			System.out.println("Digite o número da conta: ");
			int idCliente = sc.nextInt();
			
			System.out.println("Digite o novo nome do Cliente: ");
			String nomeClienteEditado = sc.next();
			
			System.out.println("Digiteo o novo email: ");
			String emailEditado = sc.next();
			
			System.out.println("Digite o novo endereço: ");
			String enderecoEditado = sc.nextLine();
			
			System.out.println("Digite o novo bairro: ");
			String bairroEditado = sc.next();
			
			System.out.println("Digite o novo Estado: ");
			String estadoEditado = sc.next();
			
			System.out.println("Digite o número de telefone: ");
			String telefone = sc.next();
			cController.AlterarCliente(idCliente, escolhaEdita, nomeClienteEditado, emailEditado, enderecoEditado, bairroEditado, estadoEditado, telefone);
			break;
		case 4:
			System.out.println("Digite o número que você quer deletar: ");
			int idDelela = sc.nextInt();
			cController.DeletarCliente(idDelela);
			break;
			default:
				break;
		
		}
	}

	
	private static void FazerPedido() {
		try {
			fController.ListaVaziaFuncionario();
		}catch (LojaFerramentasException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		fController.ListarFuncionario();
			Funcionario f = null;
			System.out.println("Digite o código do funcionario: ");
			int matricula = sc.nextInt();
			try {
				f = fController.pegaFuncionario(matricula);
			}catch(LojaFerramentasException | NullPointerException e) {
				if(f == null) {
					System.out.println("Não existe funcionario Cadastrado!");
					return;
				}
			}
			
			NotaFiscal nf = null;
			boolean sairDoPedido = false;	
				System.out.println("Você está cadastrado (y/n): ");
				char cadastrado = sc.next().toLowerCase().charAt(0);
				if(cadastrado == 'y') {
					System.out.println("Cliente Jurídico ou Físico (f/j): ");
					char tipo = sc.next().toLowerCase().charAt(0);
					try {
						if(tipo == 'f') {
							System.out.println("Digite o número do seu CPF: ");
							String cpf = sc.next();
							Cliente clienteFisico = cController.ProcuraCPF(cpf);
							nf = new NotaFiscal(clienteFisico, f);
						}
						else {
							System.out.println("Digite o número do seu CNPJ: ");
							String cnpj = sc.next();
							Cliente clienteJuridico = cController.ProcuraCNPJ(cnpj);
							nf = new NotaFiscal(clienteJuridico, f);
						}
					}catch (LojaFerramentasException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					nf = new NotaFiscal(f);
				}

			do {
				pController.ListarProduto();
				System.out.println("Digite o código do produto: ");
				int codProduto = sc.nextInt();
				System.out.println("Digite a quantidade: ");
				int qtd = sc.nextInt();
				Produto produto = pController.pegaProduto(codProduto);
				System.out.println("Terá Desconto? ");
				char escolha = sc.next().toLowerCase().charAt(0);
				if(escolha == 's') {
					System.out.println("Quantos procento ?");
					Double porcento = sc.nextDouble();
					produto.DescontoAplicado(porcento);
				}
				ItensProduto it = new ItensProduto(qtd, produto, nf);
				nf.CadastrarItensProdutos(it);
				System.out.println("Quer encerrar o pedido? (s/n)");
				char encerrar = sc.next().toLowerCase().charAt(0);
				if(encerrar == 's' ) {
					nController.CadastrarNotaFiscal(nf);
					System.out.println(nf.toString());
					sairDoPedido = true;
				}
			}while(!sairDoPedido);

	}
	
	private static void GerenciarFuncionario() {
		System.out.println("1 - Cadastrar Funcionario");
		System.out.println("2 - Listar Funcionarios");
		System.out.println("3 - Editar Funcionario");
		System.out.println("4 - Deletar Funcionario");
		int opcao = sc.nextInt();
		switch (opcao) {
		
		case 1: 
			System.out.println("Digite o nome do Funcionário: ");
			String nome = sc.next();
			
			System.out.println("Digite o salário: ");
			Double salario = sc.nextDouble();
			
			System.out.println("Que tipo de funcionario (v/g): ");
			char tipo = sc.next().toLowerCase().charAt(0);
			
			if(tipo == 'g') {
				fController.CadastrarFuncionario(new Gerente(nome, salario));
			}else {
				fController.CadastrarFuncionario(new Vendedor(nome, salario));
			}
			break;
		case 2:
			fController.ListarFuncionario();
			break;
		case 3:
			System.out.println("Digite a matricula do Funcionario para editar: ");
			int matricula = sc.nextInt();
			System.out.println("Digite o novo nome do Funcionario: ");
			String nomeEditado = sc.next();
			System.out.println("Digite o novo salario: ");
			Double salarioEditado = sc.nextDouble();
			fController.AlterarFuncionario(matricula, nomeEditado, salarioEditado);
			break;
		case 4:
			System.out.println("Digite a matrícula para deletar: ");
			int matriculaDeletar = sc.nextInt();
			fController.DeletarFuncionario(matriculaDeletar);
		default:
			System.out.println("Número Inválido");
			break;
			
		}	
}

	private static void GerenciarNotasFiscais() {
		System.out.println("1 - Listar Notas Fiscais");
		System.out.println("2 - Deletar Notas Fiscais");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1: 
			nController.ListarNotaFiscal();
		break;
		case 2:
			System.out.println("Digite o número da Nota Fiscal que quer deletar: ");
			int numero = sc.nextInt();
			nController.DeletarNotaFiscal(numero);
			break;
		default:
			System.out.println("Número inválido");
		}
		
	}
	
}
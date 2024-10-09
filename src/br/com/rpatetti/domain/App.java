package br.com.rpatetti.domain;

import javax.swing.JOptionPane;

import br.com.rpatetti.dao.ClienteMapDAO;
import br.com.rpatetti.dao.IClienteDAO;

public class App {
	
private static IClienteDAO iClienteDAO;
	
	public static void main(String[] args) {
		iClienteDAO = new ClienteMapDAO();
		
		String opcao = JOptionPane.showInputDialog(null, "Digite:" + "\n" + "1 para cadastro" + "\n" +  "2 para consultar" + "\n" + "3 para exclusão"
		+ "\n" + "4 para alteração" + "\n" + "5 para sair", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
		
		while (!isOpcaoValida(opcao)) {
			if ("".equals(opcao)) {
				sair();
			}
			opcao = JOptionPane.showInputDialog(null, "Digite:" + "\n" + "1 para cadastro" + "\n" +  "2 para consultar" + "\n" + "3 para exclusão"
					+ "\n" + "4 para alteração" + "\n" + "5 para sair", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					
		}
		
		while (isOpcaoValida(opcao)) {
			if(isOpcaoSair(opcao) ) {
				sair();
			}else if (isCadastro(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por virgula" + "\n"+ "(Nome, CPF, Tel, End, Numero, Cidade, Estado",
						"Cadastro", JOptionPane.INFORMATION_MESSAGE);	
				cadastrar(dados);
			}else if (isConsultar(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o CPF", "Consultar", JOptionPane.INFORMATION_MESSAGE);	
				consultar(dados);
			} else if (isExclusao(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Consultar", JOptionPane.INFORMATION_MESSAGE);
				excluir(dados);
			} else {
				String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por virgula" + "\n"+ "(Nome, CPF, Tel, End, Numero, Cidade, Estado", "Atualizar", JOptionPane.INFORMATION_MESSAGE);
				atualizar(dados);
			}
			opcao = JOptionPane.showInputDialog(null, "Digite:" + "\n" + "1 para cadastro" + "\n" +  "2 para consultar" + "\n" + "3 para exclusão"
					+ "\n" + "4 para alteração" + "\n" + "5 para sair", "Cadastro", JOptionPane.INFORMATION_MESSAGE);			
		}
	}
	
	private static void atualizar(String dados) {
		// TODO Auto-generated method stub
		
	}

	private static void excluir(String dados) {
		iClienteDAO.excluir(Long.parseLong(dados));
		JOptionPane.showMessageDialog(null, "Cliente excluido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);	
	}

	private static boolean isExclusao(String opcao) {
		if ("3".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void consultar(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if (cliente != null) {
			JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), dados, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", dados, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static boolean isConsultar(String opcao) {
		if ("2".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void cadastrar(String dados) {
		String[] dadosSeparados = dados.split(",");
		Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
		Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
		if (isCadastrado) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Cliente ja cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static boolean isCadastro(String opcao) {
		if ("1".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoSair(String opcao) {
		if ("5".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void sair() {
		JOptionPane.showMessageDialog(null, "Até logo ", "Sair", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private static boolean isOpcaoValida(String opcao) {
		if ("1".equals(opcao) || "2".equals(opcao)
			|| "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
				return true;
			}
		return false;
	}

}



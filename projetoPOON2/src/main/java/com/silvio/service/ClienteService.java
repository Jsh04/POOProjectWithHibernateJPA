package com.silvio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.silvio.Exception.LojaFerramentasException;
import com.silvio.modelo.cliente.Cliente;
import com.silvio.modelo.cliente.ClienteFisico;
import com.silvio.modelo.cliente.ClienteJuridico;
import com.silvio.repository.clienterepository.ClienteFisicoRepository;
import com.silvio.repository.clienterepository.ClienteJuridicoRepository;
import com.silvio.repository.clienterepository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired ClienteFisicoRepository clienteFisicoRepository;

	@Autowired ClienteJuridicoRepository clienteJuridicoRepository;

	public void CadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public void ListarCliente(Integer pagina) {
		Pageable paginas = PageRequest.of(pagina, 10, Sort.unsorted());
		Page<Cliente> clientes = clienteRepository.findAll(paginas);
		clientes.forEach(System.out::println);
	}

	public void AlterarCliente(int id, char escolha, String nomeCliente, String email, String endereco, String bairro,
			String estado, String telefone) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isEmpty()) {
			throw new LojaFerramentasException("Não existe o cliente especificado");
		}
		
		if (escolha == 'f') {
			ClienteFisico clienteFisico = (ClienteFisico) cliente.get();
			clienteFisico.setNome(nomeCliente);
			clienteFisico.setEmail(email);
			clienteFisico.setEndereco(endereco);
			clienteFisico.setBairro(bairro);
			clienteFisico.setEstado(estado);
			clienteFisico.setTelefonePessoal(telefone);
			clienteFisicoRepository.save(clienteFisico);
		}else{
			ClienteJuridico clienteJuridico = (ClienteJuridico) cliente.get();
			clienteJuridico.setNome(nomeCliente);
			clienteJuridico.setEndereco(endereco);
			clienteJuridico.setEmail(email);
			clienteJuridico.setBairro(bairro);
			clienteJuridico.setEstado(estado);
			clienteJuridico.setTelefoneComecial(telefone);
			clienteJuridicoRepository.save(clienteJuridico);
		}

	}

	public void DeletarCliente(int id) {
		clienteRepository.deleteById(id);
	}

	public Cliente ProcuraCPF(String cpf) {
		return clienteFisicoRepository.findByCpf(cpf);
	}

	public Cliente ProcuraCNPJ(String cnpj) {
		return clienteJuridicoRepository.findByCnpj(cnpj);
	}

}

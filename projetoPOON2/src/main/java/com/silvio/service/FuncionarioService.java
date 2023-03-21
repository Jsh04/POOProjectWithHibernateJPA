package com.silvio.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.silvio.Exception.LojaFerramentasException;
import com.silvio.modelo.funcionario.Funcionario;
import com.silvio.repository.funcionariorepository.FuncionarioRepository;



@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public void CadastrarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	public void ListarFuncionario(Integer pagina) {
		Pageable pageble = PageRequest.of(pagina, 10, Sort.unsorted());
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll(pageble);
		funcionarios.forEach(System.out::println);
	}
	
	public boolean ListaVaziaFuncionario() {
		if(funcionarioRepository.findAll().isEmpty()) {
			throw new LojaFerramentasException("� necess�rio cadastrar Funcion�rio para fazer pedido");
		}
		return true;
	}
	
	public void AlterarFuncionario(int matricula, String nome , Double salario) {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(matricula);
		if (optionalFuncionario.isEmpty()) {
			throw new LojaFerramentasException("Funcionário não encontrado");
		}

		Funcionario funcionario = optionalFuncionario.get();
		funcionario.setNome(nome);
		funcionario.setSalario(salario);
	}
	public void DeletarFuncionario(int id) {
		funcionarioRepository.deleteById(id);
	}
	
	public Funcionario pegaFuncionario(int numero) {
		return funcionarioRepository.findById(numero).get();
	}
	
}

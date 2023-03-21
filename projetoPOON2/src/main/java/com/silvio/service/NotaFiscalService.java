package com.silvio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.silvio.modelo.notafiscal.NotaFiscal;
import com.silvio.repository.notafiscalrepository.NotaFiscalRepository;



@Service
public class NotaFiscalService {
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	public void CadastrarNotaFiscal(NotaFiscal nf) {
		notaFiscalRepository.save(nf);
	}
	
	public void ListarNotaFiscal() {
		List<NotaFiscal> notas = notaFiscalRepository.findAll();
		notas.forEach(System.out::println);
	}
	
	public void DeletarNotaFiscal(int numero) {
		notaFiscalRepository.deleteById(numero);
	}
	
	
}

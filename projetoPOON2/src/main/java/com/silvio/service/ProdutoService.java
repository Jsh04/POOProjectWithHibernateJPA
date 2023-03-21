package com.silvio.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.silvio.Exception.LojaFerramentasException;
import com.silvio.modelo.produto.Produto;
import com.silvio.repository.produtorepository.ProdutoRepository;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	

	public void CadastrarProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	public void ListarProduto(Integer pagina) {
		Pageable paginacao = PageRequest.of(pagina, 10, Sort.unsorted());
		Page<Produto> notasFiscais = produtoRepository.findAll(paginacao);
		List<Produto> lista = notasFiscais.toList();
		lista.forEach(System.out::println);
	}

	public void AlterarProduto(int id, String nomeEditado, Double precoEditado) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if(optionalProduto.isEmpty()){
			throw new LojaFerramentasException("Não existe o produto procurado!");
		}
		Produto produto = optionalProduto.get();
		produto.setNomeFerramenta(nomeEditado);
		produto.setPreco(precoEditado);
		produtoRepository.save(produto);
	}
	public void DeletarProduto(int id) {
		produtoRepository.deleteById(id);
	}

	public Produto pegaProduto(int codProduto) {
		return produtoRepository.findById(codProduto).get();
	}
}

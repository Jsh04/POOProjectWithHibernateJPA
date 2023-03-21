package com.silvio.repository.produtorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.modelo.produto.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

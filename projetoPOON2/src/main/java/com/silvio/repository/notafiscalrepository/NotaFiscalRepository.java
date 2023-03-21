package com.silvio.repository.notafiscalrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.modelo.notafiscal.NotaFiscal;



@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer>{

}

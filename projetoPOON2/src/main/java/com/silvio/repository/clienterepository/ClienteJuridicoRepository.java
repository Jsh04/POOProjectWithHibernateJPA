package com.silvio.repository.clienterepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.silvio.modelo.cliente.ClienteJuridico;

@Repository
public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico, Integer> {

    ClienteJuridico findByCnpj(String cnpj);
}

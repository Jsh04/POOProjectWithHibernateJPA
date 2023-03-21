package com.silvio.repository.clienterepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.modelo.cliente.ClienteFisico;

@Repository
public interface ClienteFisicoRepository extends JpaRepository<ClienteFisico, Integer> {

    ClienteFisico findByCpf(String cpf);
}

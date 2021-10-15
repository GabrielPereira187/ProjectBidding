package br.com.ProjectLicitation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjectLicitation.model.Vendedor;


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

}

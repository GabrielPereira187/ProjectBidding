package br.com.ProjectLicitation.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.ProjectLicitation.model.Empresa;
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	
	
	

}

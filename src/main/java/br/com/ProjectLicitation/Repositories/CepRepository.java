package br.com.ProjectLicitation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjectLicitation.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Integer> {

}

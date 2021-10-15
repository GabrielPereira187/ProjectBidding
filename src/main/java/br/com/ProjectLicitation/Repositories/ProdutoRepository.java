package br.com.ProjectLicitation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjectLicitation.model.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

package br.com.ProjectLicitation.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import br.com.ProjectLicitation.model.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query(value = "select * from product where item = :item", nativeQuery = true)
	Produto findByitem(int item);
	

	

}

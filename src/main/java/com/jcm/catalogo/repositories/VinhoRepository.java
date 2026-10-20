package com.jcm.catalogo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jcm.catalogo.entities.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Long> {
	
	   @Query("""
		       SELECT v FROM Vinho v 
		       WHERE (:tipo IS NULL OR :tipo = '' OR LOWER(v.tipo) LIKE LOWER(CONCAT('%', :tipo, '%')))
		         AND (:uva IS NULL OR :uva = '' OR LOWER(v.uva) LIKE LOWER(CONCAT('%', :uva, '%')))
		         AND (:origem IS NULL OR :origem = '' OR LOWER(v.origem) LIKE LOWER(CONCAT('%', :origem, '%')))
		    """)
		    List<Vinho> buscarPorFiltrosOpcionais(
		        @Param("tipo") String tipo, 
		        @Param("uva") String uva, 
		        @Param("origem") String origem
		    );
}

package com.cupom.infrastructure.adapters.repository;

import com.cupom.infrastructure.entities.CupomFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomFiscalRepository extends JpaRepository<CupomFiscalEntity,Long> {

    @Query("SELECT c FROM CupomFiscalEntity c WHERE c.id = :id")
    CupomFiscalEntity findCupomById(@Param("id") Long id);

}

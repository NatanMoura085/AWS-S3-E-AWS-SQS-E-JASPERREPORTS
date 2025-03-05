package com.cupom.infrastructure.adapters.repository;

import com.cupom.infrastructure.entities.CupomFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomFiscalRepository extends JpaRepository<CupomFiscalEntity,Long> {
}

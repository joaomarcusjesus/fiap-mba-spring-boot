package br.com.fiap.avctechapi.repository;

import br.com.fiap.avctechapi.model.Assistance;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance,Long> {
}
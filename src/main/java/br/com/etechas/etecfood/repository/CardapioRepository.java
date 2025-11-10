package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Cardapio;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, long> {

}

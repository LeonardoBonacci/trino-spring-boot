package guru.bonacci.trino.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlaRepository extends CrudRepository<Bla, Long>{
	
	@Query(value = "select bla.blaname, transfers.poolid from mysql.heroes.bla as bla join kafka.tpch.transfers as transfers on transfers._from = bla.blaname", nativeQuery = true)
  List<UserBla> all();
	
	@Query(value = "WITH debit AS (SELECT sum(amount) AS SMILE FROM kafka.tpch.transfers where to = 'bar'), credit AS (SELECT sum(amount) AS CRY FROM kafka.tpch.transfers where _from = 'bar') SELECT coalesce(SMILE, 0) - coalesce(CRY, 0) AS balance FROM debit, credit", nativeQuery = true)
  BigDecimal balance();
}

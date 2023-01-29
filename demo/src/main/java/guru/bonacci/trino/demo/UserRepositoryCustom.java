package guru.bonacci.trino.demo;

import java.math.BigDecimal;

public interface UserRepositoryCustom {

	BigDecimal findBalance(String name, String topic);
}

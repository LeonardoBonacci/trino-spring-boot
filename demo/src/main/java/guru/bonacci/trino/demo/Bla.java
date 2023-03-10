package guru.bonacci.trino.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bla", catalog = "mysql", schema = "heroes")
@NoArgsConstructor
@AllArgsConstructor
public class Bla {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blakey;
    private String blaname;
}
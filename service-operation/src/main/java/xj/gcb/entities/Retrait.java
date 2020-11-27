package xj.gcb.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Retrait extends Operation{
    public Retrait(Long numero, Date date, double nomtant) {
        super(numero, date, nomtant);
    }
    @Override
    public Type getType() {
        return Type.Retrait;
    }
}

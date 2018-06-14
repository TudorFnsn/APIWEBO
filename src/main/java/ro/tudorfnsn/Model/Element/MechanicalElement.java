package ro.tudorfnsn.Model.Element;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class MechanicalElement extends Element
{
    @Column
    protected String series;



    public MechanicalElement(String picture, String name, String series)
    {
        super(picture,name);
        this.series = series;

    }
}

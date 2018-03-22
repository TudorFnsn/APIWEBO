package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Model.Element.MechanicalElement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sparePart")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class SparePart extends MechanicalElement
{
    @Column
    private Float price;

    @Column
    private Integer quantity;

    @Column
    private String origin;

    public SparePart(String picture, String name, String series, Float price, Integer quantity, String origin)
    {
        super(picture,name,series);
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

}

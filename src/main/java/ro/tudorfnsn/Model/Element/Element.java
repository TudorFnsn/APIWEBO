package ro.tudorfnsn.Model.Element;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Element
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Type(type = "text")
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 3000)
    private String picture;

    @Column
    private String name;


    public Element(String picture, String name)
    {
        this.picture = picture;
        this.name = name;
    }




}

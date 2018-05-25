package ro.tudorfnsn.Model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name="news")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Lob
    @Type(type = "text")
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 3000)
    protected String picture;

    @Column
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    //private TextArea description;

    public News(String title, Date startDate, Date endDate)
    {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

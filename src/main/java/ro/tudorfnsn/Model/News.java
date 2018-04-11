package ro.tudorfnsn.Model;

import lombok.*;

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

    @Column
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column
    private String description;
    //private TextArea description;

    public News(String title, Date startDate, Date endDate, String description)
    {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}

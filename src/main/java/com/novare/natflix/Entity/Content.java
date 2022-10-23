package com.novare.natflix.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {
    @Id
    @SequenceGenerator(
            name = "content_sequence",
            sequenceName = "content_sequence",
            allocationSize = 1)
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,
                    generator = "content_sequence"

            )
    private Long id;
    private String title;
    private String summary;
    private String logo_url;
    private String banner_url;
    private String thumbnail_url;
    private Long category_id;
    private Long type_id;
}

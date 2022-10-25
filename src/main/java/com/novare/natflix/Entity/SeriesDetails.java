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
public class SeriesDetails {
    @Id
    @SequenceGenerator(
            name = "seriesDetail_sequence",
            sequenceName = "seriesDetail_sequence",
            allocationSize = 1)
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,
                    generator = "seriesDetail_sequence"

            )
    private Long id;
    private Integer contentID;
    private Integer seasonNumber;
    private Integer episodeNumber;
    private String title;
    private String summary;
    private String thumbnail_url;
    private String videoCode;


}

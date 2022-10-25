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
public class ContentDetails {
    @Id
    @SequenceGenerator(
            name = "contentDetail_sequence",
            sequenceName = "contentDetail_sequence",
            allocationSize = 1)
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,
                    generator = "contentDetail_sequence"

            )

    private Long content_id;
    private Long id;
    private String video_code;

}

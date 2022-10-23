package com.novare.natflix.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentCategory {
    @Id
    private Long id;
    private String category;
}


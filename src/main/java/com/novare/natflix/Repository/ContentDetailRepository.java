package com.novare.natflix.Repository;

import com.novare.natflix.Entity.Content;
import com.novare.natflix.Entity.ContentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDetailRepository extends JpaRepository<ContentDetails, Long> {
}

package com.dcorp.artgallery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dcorp.artgallery.model.ArtPiece;

@Repository
public interface ArtPieceRepository extends JpaRepository<ArtPiece, Long> {
	List<ArtPiece> findArtByMedium(String medium);
}
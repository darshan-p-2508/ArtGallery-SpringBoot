package com.dcorp.artgallery.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcorp.artgallery.exceptions.EntriesNotFoundException;
import com.dcorp.artgallery.exceptions.ResourceNotFoundException;
import com.dcorp.artgallery.model.ArtPiece;
import com.dcorp.artgallery.repository.ArtPieceRepository;

@Service
public class ArtPieceService {

	private final ArtPieceRepository artPieceRepository;

	@Autowired
	public ArtPieceService(ArtPieceRepository artPieceRepository) {
		this.artPieceRepository = artPieceRepository;
	}

	public List<ArtPiece> getAllArtPieces() {
		if (artPieceRepository.count() >= 1) {
			return artPieceRepository.findAll();
		} else {
			throw new EntriesNotFoundException(
					"There are no Art Pieces to be displayed. Make sure to add some using POST method");
		}
	}

	public Optional<ArtPiece> getArtPieceById(Long id) {
		return Optional.ofNullable(artPieceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"The Art Piece you are trying to find with id: " + id + ", does not exist.")));
	}

	public ArtPiece createArtPiece(ArtPiece artPiece) {
		return artPieceRepository.save(artPiece);
	}

	public ArtPiece updateArtPiece(Long id, ArtPiece artPiece) {
		return artPieceRepository.findById(id).map(existingArtPiece -> {
			artPiece.setId(id);
			return artPieceRepository.save(artPiece);
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Couldn't update the data as the entry with id: " + id + ", was not found."));
	}

	public void deleteArtPiece(Long id) {
		if (!artPieceRepository.existsById(id)) {
			throw new ResourceNotFoundException(
					"The Art Piece with id: " + id + ", you are trying to delete, does not exist.");
		}
		artPieceRepository.deleteById(id);
	}

	public List<ArtPiece> getArtPieceByMedium(String medium) {
		if ((artPieceRepository.findArtByMedium(medium)).size() >= 1) {
			return artPieceRepository.findArtByMedium(medium);
		} else {
			throw new EntriesNotFoundException("There are no Art Pieces that match the 'art medium' described.");
		}
	}
}

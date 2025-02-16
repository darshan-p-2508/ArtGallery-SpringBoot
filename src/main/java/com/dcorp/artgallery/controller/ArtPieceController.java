package com.dcorp.artgallery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dcorp.artgallery.model.ArtPiece;
import com.dcorp.artgallery.service.ArtPieceService;

@RestController
@RequestMapping("/artgallery")
public class ArtPieceController {

	private final ArtPieceService artPieceService;

	@Autowired
	public ArtPieceController(ArtPieceService artPieceService) {
		this.artPieceService = artPieceService;
	}

	// Get all art pieces
	@GetMapping("/displayAllArts")
	public ResponseEntity<List<ArtPiece>> getAllArtPieces() {
		List<ArtPiece> artPieces = artPieceService.getAllArtPieces();
		return new ResponseEntity<>(artPieces, HttpStatus.OK);
	}

	// Get an art piece by ID
	@GetMapping("/displayArtWithID/{id}")
	public ResponseEntity<ArtPiece> getArtPieceById(@PathVariable Long id) {
		ArtPiece artPiece = artPieceService.getArtPieceById(id).orElse(null);
		return new ResponseEntity<>(artPiece, HttpStatus.OK);
	}

	@GetMapping("/displayArtWithMedium/{medium}")
	public ResponseEntity<List<ArtPiece>> getArtPieceByMedium(@PathVariable String medium) {
		List<ArtPiece> artPiece = artPieceService.getArtPieceByMedium(medium);
		return new ResponseEntity<>(artPiece, HttpStatus.OK);
	}

	// Create a new art piece
	@PostMapping("/addArt")
	public ResponseEntity<ArtPiece> createArtPiece(@RequestBody ArtPiece artPiece) {
		ArtPiece createdArtPiece = artPieceService.createArtPiece(artPiece);
		return new ResponseEntity<>(createdArtPiece, HttpStatus.CREATED);
	}

	// Update an existing art piece
	@PutMapping("/updateArtWithId/{id}")
	public ResponseEntity<ArtPiece> updateArtPiece(@PathVariable Long id, @RequestBody ArtPiece artPiece) {
		ArtPiece updatedArtPiece = artPieceService.updateArtPiece(id, artPiece);
		return new ResponseEntity<>(updatedArtPiece, HttpStatus.OK);
	}

	// Delete an art piece
	@DeleteMapping("/deleteArtWithId/{id}")
	public ResponseEntity<String> deleteArtPiece(@PathVariable Long id) {
		artPieceService.deleteArtPiece(id);
		// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return ResponseEntity.status(HttpStatus.OK).body("Art Piece with ID: " + id + ", deleted successfully");
	}
}
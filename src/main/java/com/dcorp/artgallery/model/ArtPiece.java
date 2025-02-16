package com.dcorp.artgallery.model;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ArtPiece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Unique identifier for the art piece
	private String title; // Title of the artwork
	private String artist; // Artist's name
	private int year; // Year of creation
	private String medium; // Medium used (e.g., oil, watercolor)
	private String description; // Description of the artwork

	// Default constructor
	public ArtPiece() {
	}

	// Parameterized constructor
	public ArtPiece(Long id, String title, String artist, int year, String medium, String description) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.medium = medium;
		this.description = description;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Override equals and hashCode for proper comparison and storage in collections
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ArtPiece))
			return false;
		ArtPiece artPiece = (ArtPiece) o;
		return year == artPiece.year && Objects.equals(id, artPiece.id) && Objects.equals(title, artPiece.title)
				&& Objects.equals(artist, artPiece.artist) && Objects.equals(medium, artPiece.medium)
				&& Objects.equals(description, artPiece.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, artist, year, medium, description);
	}

	// Override toString for easy debugging and logging
	@Override
	public String toString() {
		return "ArtPiece{" + "id=" + id + ", title='" + title + '\'' + ", artist='" + artist + '\'' + ", year=" + year
				+ ", medium='" + medium + '\'' + ", description='" + description + '\'' + '}';
	}
}

package com.simple.hibernate.app.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movie_id;
	
	@Column(name="movie_name")
	private String movie_name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="movies_actors_relation",
			joinColumns = @JoinColumn(name="movie_id"),
			inverseJoinColumns = @JoinColumn(name="actor_id")
			)
	private
	List<Actor> actors;
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
}

package com.simple.hibernate.app.ManyToMany;

import java.util.ArrayList;
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
@Table(name="actors")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id")
	private int actor_id;
	
	@Column(name="actor_name")
	private String actor_name;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="movies_actors_relation",
			joinColumns = @JoinColumn(name="actor_id"),
			inverseJoinColumns = @JoinColumn(name="movie_id")
			)
	private List<Movie> movies;

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getActor_name() {
		return actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public void add(Movie movie) {
		if(movies==null) {
			movies = new ArrayList<Movie>();
		}
		movies.add(movie);
	}


}

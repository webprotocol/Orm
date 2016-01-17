package com.hybrid.orm.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the countrylanguage database table.
 * 
 */
@Entity
@NamedQuery(name="Countrylanguage.findAll", query="SELECT c FROM Countrylanguage c")
public class Countrylanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountrylanguagePK id;

	private String isOfficial;

	private float percentage;

	public Countrylanguage() {
	}

	public CountrylanguagePK getId() {
		return this.id;
	}

	public void setId(CountrylanguagePK id) {
		this.id = id;
	}

	public String getIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
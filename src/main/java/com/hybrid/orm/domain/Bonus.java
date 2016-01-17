package com.hybrid.orm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BONUS database table.
 * 
 */
@Entity
@NamedQuery(name="Bonus.findAll", query="SELECT b FROM Bonus b")
public class Bonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal comm;

	private String ename;

	private String job;

	private BigDecimal sal;

	public Bonus() {
	}

	public BigDecimal getComm() {
		return this.comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

}
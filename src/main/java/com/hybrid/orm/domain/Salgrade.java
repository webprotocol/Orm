package com.hybrid.orm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SALGRADE database table.
 * 
 */
@Entity
@NamedQuery(name="Salgrade.findAll", query="SELECT s FROM Salgrade s")
public class Salgrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal grade;

	private BigDecimal hisal;

	private BigDecimal losal;

	public Salgrade() {
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public BigDecimal getHisal() {
		return this.hisal;
	}

	public void setHisal(BigDecimal hisal) {
		this.hisal = hisal;
	}

	public BigDecimal getLosal() {
		return this.losal;
	}

	public void setLosal(BigDecimal losal) {
		this.losal = losal;
	}

}
package cn.itcast.jpa.demo03.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IDCard {

	private Integer id;
	private String cardno;
	private Personal personal;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 18, nullable = false)
	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	@OneToOne( cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE },mappedBy="idcard")
	//optional = false,
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public IDCard() {

	}

	public IDCard(String cardno) {
		this.cardno = cardno;
	}

}

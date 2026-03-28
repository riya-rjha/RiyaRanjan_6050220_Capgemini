package cg.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


//OWNING SIDE- UNIDIRECTIONAL 1 TO 1 MAPPING
//by default association is lazy (not default, only on demand) so specify cascading
//we need to make this association eager (cascade)

@Entity
public class IndianPassport {
	
	@Id
	private int passportNo;
	
	private LocalDate passportExpiracyDate;

    public IndianPassport() {}
	
	
	@OneToOne(cascade= CascadeType.ALL)
	private Citizen citizen;
	
	
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public LocalDate getPassportExpiracyDate() {
		return passportExpiracyDate;
	}
	public void setPassportExpiracyDate(LocalDate passportExpiracyDate) {
		this.passportExpiracyDate = passportExpiracyDate;
	}

}
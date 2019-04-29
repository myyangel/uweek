package com.uweek.entity;

import java.io.Serializable;


import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@Column(name = "address", length = 30, nullable = false)
	private String address;

	@Column(name = "birth", nullable = false)
        @Temporal (TemporalType.DATE)
	private Date birth;
        
        @Column (name= "password", length=20, nullable=false)
        private String password;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
        public String getPassword(){
                    return password;
        }
        
        public void setPassword(String password){
                this.password = password;
        }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "ADDRESSES")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")
	, @NamedQuery(name = "Addresses.findById", query = "SELECT a FROM Addresses a WHERE a.id = :id")
	, @NamedQuery(name = "Addresses.findByAddressline1", query = "SELECT a FROM Addresses a WHERE a.addressline1 = :addressline1")
	, @NamedQuery(name = "Addresses.findByAddressline2", query = "SELECT a FROM Addresses a WHERE a.addressline2 = :addressline2")
	, @NamedQuery(name = "Addresses.findByCity", query = "SELECT a FROM Addresses a WHERE a.city = :city")
	, @NamedQuery(name = "Addresses.findByState", query = "SELECT a FROM Addresses a WHERE a.state = :state")
	, @NamedQuery(name = "Addresses.findByZipcode", query = "SELECT a FROM Addresses a WHERE a.zipcode = :zipcode")
	, @NamedQuery(name = "Addresses.findByCountry", query = "SELECT a FROM Addresses a WHERE a.country = :country")})
public class Addresses implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "ID")
	private Integer id;
	@Size(max = 255)
        @Column(name = "ADDRESSLINE1")
	private String addressline1;
	@Size(max = 255)
        @Column(name = "ADDRESSLINE2")
	private String addressline2;
	@Size(max = 255)
        @Column(name = "CITY")
	private String city;
	@Size(max = 255)
        @Column(name = "STATE")
	private String state;
	@Size(max = 255)
        @Column(name = "ZIPCODE")
	private String zipcode;
	@Size(max = 255)
        @Column(name = "COUNTRY")
	private String country;
	@OneToMany(mappedBy = "billingAddrId")
	private Collection<Orders> ordersCollection;
	@OneToMany(mappedBy = "deliveryAddrId")
	private Collection<Orders> ordersCollection1;

	public Addresses() {
	}

	public Addresses(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlTransient
	public Collection<Orders> getOrdersCollection() {
		return ordersCollection;
	}

	public void setOrdersCollection(Collection<Orders> ordersCollection) {
		this.ordersCollection = ordersCollection;
	}

	@XmlTransient
	public Collection<Orders> getOrdersCollection1() {
		return ordersCollection1;
	}

	public void setOrdersCollection1(Collection<Orders> ordersCollection1) {
		this.ordersCollection1 = ordersCollection1;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Addresses)) {
			return false;
		}
		Addresses other = (Addresses) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Addresses[ id=" + id + " ]";
	}
	
}

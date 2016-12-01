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
@Table(name = "CATEGORIES")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
	, @NamedQuery(name = "Categories.findById", query = "SELECT c FROM Categories c WHERE c.id = :id")
	, @NamedQuery(name = "Categories.findByName", query = "SELECT c FROM Categories c WHERE c.name = :name")
	, @NamedQuery(name = "Categories.findByDispOrder", query = "SELECT c FROM Categories c WHERE c.dispOrder = :dispOrder")
	, @NamedQuery(name = "Categories.findByDescription", query = "SELECT c FROM Categories c WHERE c.description = :description")})
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 255)
        @Column(name = "NAME")
	private String name;
	@Column(name = "DISP_ORDER")
	private Integer dispOrder;
	@Size(max = 1024)
        @Column(name = "DESCRIPTION")
	private String description;
	@OneToMany(mappedBy = "catId")
	private Collection<Products> productsCollection;

	public Categories() {
	}

	public Categories(Integer id) {
		this.id = id;
	}

	public Categories(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public Collection<Products> getProductsCollection() {
		return productsCollection;
	}

	public void setProductsCollection(Collection<Products> productsCollection) {
		this.productsCollection = productsCollection;
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
		if (!(object instanceof Categories)) {
			return false;
		}
		Categories other = (Categories) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Categories[ id=" + id + " ]";
	}
	
}

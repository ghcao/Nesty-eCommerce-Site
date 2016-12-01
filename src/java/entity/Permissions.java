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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PERMISSIONS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p")
	, @NamedQuery(name = "Permissions.findById", query = "SELECT p FROM Permissions p WHERE p.id = :id")
	, @NamedQuery(name = "Permissions.findByName", query = "SELECT p FROM Permissions p WHERE p.name = :name")
	, @NamedQuery(name = "Permissions.findByDescription", query = "SELECT p FROM Permissions p WHERE p.description = :description")})
public class Permissions implements Serializable {

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
	@Size(max = 1024)
        @Column(name = "DESCRIPTION")
	private String description;
	@JoinTable(name = "ROLE_PERMISSION", joinColumns = {
        	@JoinColumn(name = "PERM_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
        @ManyToMany
	private Collection<Roles> rolesCollection;

	public Permissions() {
	}

	public Permissions(Integer id) {
		this.id = id;
	}

	public Permissions(Integer id, String name) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public Collection<Roles> getRolesCollection() {
		return rolesCollection;
	}

	public void setRolesCollection(Collection<Roles> rolesCollection) {
		this.rolesCollection = rolesCollection;
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
		if (!(object instanceof Permissions)) {
			return false;
		}
		Permissions other = (Permissions) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Permissions[ id=" + id + " ]";
	}
	
}

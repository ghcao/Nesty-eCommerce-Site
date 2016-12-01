/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
	, @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id")
	, @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
	, @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description")
	, @NamedQuery(name = "Products.findBySku", query = "SELECT p FROM Products p WHERE p.sku = :sku")
	, @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")
	, @NamedQuery(name = "Products.findByImageurl", query = "SELECT p FROM Products p WHERE p.imageurl = :imageurl")
	, @NamedQuery(name = "Products.findByCreatedOn", query = "SELECT p FROM Products p WHERE p.createdOn = :createdOn")})
public class Products implements Serializable {

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
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 255)
        @Column(name = "SKU")
	private String sku;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
        @NotNull
        @Column(name = "PRICE")
	private BigDecimal price;
	@Size(max = 255)
        @Column(name = "IMAGEURL")
	private String imageurl;
	@Column(name = "CREATED_ON")
        @Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	@OneToMany(mappedBy = "productId")
	private Collection<OrderItems> orderItemsCollection;
	@JoinColumn(name = "CAT_ID", referencedColumnName = "ID")
        @ManyToOne
	private Categories catId;

	public Products() {
	}

	public Products(Integer id) {
		this.id = id;
	}

	public Products(Integer id, String name, String sku, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.price = price;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@XmlTransient
	public Collection<OrderItems> getOrderItemsCollection() {
		return orderItemsCollection;
	}

	public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
		this.orderItemsCollection = orderItemsCollection;
	}

	public Categories getCatId() {
		return catId;
	}

	public void setCatId(Categories catId) {
		this.catId = catId;
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
		if (!(object instanceof Products)) {
			return false;
		}
		Products other = (Products) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Products[ id=" + id + " ]";
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "ORDER_ITEMS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "OrderItems.findAll", query = "SELECT o FROM OrderItems o")
	, @NamedQuery(name = "OrderItems.findById", query = "SELECT o FROM OrderItems o WHERE o.id = :id")
	, @NamedQuery(name = "OrderItems.findByQuantity", query = "SELECT o FROM OrderItems o WHERE o.quantity = :quantity")
	, @NamedQuery(name = "OrderItems.findByPrice", query = "SELECT o FROM OrderItems o WHERE o.price = :price")})
public class OrderItems implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Column(name = "QUANTITY")
	private int quantity;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PRICE")
	private BigDecimal price;
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
        @ManyToOne
	private Orders orderId;
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
        @ManyToOne
	private Products productId;

	public OrderItems() {
	}

	public OrderItems(Integer id) {
		this.id = id;
	}

	public OrderItems(Integer id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
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
		if (!(object instanceof OrderItems)) {
			return false;
		}
		OrderItems other = (OrderItems) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.OrderItems[ id=" + id + " ]";
	}
	
}

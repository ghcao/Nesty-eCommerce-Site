/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
	, @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
	, @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")
	, @NamedQuery(name = "Orders.findByCreatedOn", query = "SELECT o FROM Orders o WHERE o.createdOn = :createdOn")})
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
	private Integer id;
	@Size(max = 255)
	private String status;
	@Column(name = "CREATED_ON")
        @Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	@OneToMany(mappedBy = "orderId")
	private Collection<OrderItems> orderItemsCollection;
	@JoinColumn(name = "BILLING_ADDR_ID", referencedColumnName = "ID")
        @ManyToOne
	private Addresses billingAddrId;
	@JoinColumn(name = "DELIVERY_ADDR_ID", referencedColumnName = "ID")
        @ManyToOne
	private Addresses deliveryAddrId;
	@JoinColumn(name = "CUST_ID", referencedColumnName = "ID")
        @ManyToOne
	private Customers custId;
	@JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
        @ManyToOne
	private Payment paymentId;

	public Orders() {
	}

	public Orders(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Addresses getBillingAddrId() {
		return billingAddrId;
	}

	public void setBillingAddrId(Addresses billingAddrId) {
		this.billingAddrId = billingAddrId;
	}

	public Addresses getDeliveryAddrId() {
		return deliveryAddrId;
	}

	public void setDeliveryAddrId(Addresses deliveryAddrId) {
		this.deliveryAddrId = deliveryAddrId;
	}

	public Customers getCustId() {
		return custId;
	}

	public void setCustId(Customers custId) {
		this.custId = custId;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
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
		if (!(object instanceof Orders)) {
			return false;
		}
		Orders other = (Orders) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Orders[ id=" + id + " ]";
	}
	
}

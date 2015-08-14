/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author COMP
 */
@Entity
@Table(name = "client", catalog = "appdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByBirthDay", query = "SELECT c FROM Client c WHERE c.birthDay = :birthDay"),
    @NamedQuery(name = "Client.findByGender", query = "SELECT c FROM Client c WHERE c.gender = :gender")})
public class Client implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CLIENT_ID")
    private String clientId;
    @Lob
    @Column(name = "LAST_NAME")
    private String lastName;
    @Lob
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Lob
    @Column(name = "MI")
    private String mi;
    @Column(name = "BIRTH_DAY")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Column(name = "GENDER")
    private String gender;
    @Lob
    @Column(name = "ADDRESS")
    private String address;
    @Lob
    @Column(name = "PHONE_NO")
    private String phoneNo;
    @Lob
    @Column(name = "CELL_NO")
    private String cellNo;
    @Lob
    @Column(name = "EMAIL")
    private String email;

    public Client() {
    }

    public Client(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        String oldClientId = this.clientId;
        this.clientId = clientId;
        changeSupport.firePropertyChange("clientId", oldClientId, clientId);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        String oldMi = this.mi;
        this.mi = mi;
        changeSupport.firePropertyChange("mi", oldMi, mi);
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        Date oldBirthDay = this.birthDay;
        this.birthDay = birthDay;
        changeSupport.firePropertyChange("birthDay", oldBirthDay, birthDay);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        String oldPhoneNo = this.phoneNo;
        this.phoneNo = phoneNo;
        changeSupport.firePropertyChange("phoneNo", oldPhoneNo, phoneNo);
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        String oldCellNo = this.cellNo;
        this.cellNo = cellNo;
        changeSupport.firePropertyChange("cellNo", oldCellNo, cellNo);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Client[ clientId=" + clientId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

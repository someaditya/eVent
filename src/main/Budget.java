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
@Table(name = "budget", catalog = "appdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"),
    @NamedQuery(name = "Budget.findByClient", query = "SELECT b FROM Budget b WHERE b.client = :client"),
    @NamedQuery(name = "Budget.findByEvent", query = "SELECT b FROM Budget b WHERE b.event = :event"),
    @NamedQuery(name = "Budget.findByDate", query = "SELECT b FROM Budget b WHERE b.date = :date")})
public class Budget implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CLIENT")
    private String client;
    @Column(name = "EVENT")
    private String event;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Column(name = "EXPENSE")
    private String expense;
    @Lob
    @Column(name = "PROFIT")
    private String profit;

    public Budget() {
    }

    public Budget(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        String oldClient = this.client;
        this.client = client;
        changeSupport.firePropertyChange("client", oldClient, client);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        String oldEvent = this.event;
        this.event = event;
        changeSupport.firePropertyChange("event", oldEvent, event);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        String oldExpense = this.expense;
        this.expense = expense;
        changeSupport.firePropertyChange("expense", oldExpense, expense);
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        String oldProfit = this.profit;
        this.profit = profit;
        changeSupport.firePropertyChange("profit", oldProfit, profit);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (client != null ? client.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.client == null && other.client != null) || (this.client != null && !this.client.equals(other.client))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Budget[ client=" + client + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

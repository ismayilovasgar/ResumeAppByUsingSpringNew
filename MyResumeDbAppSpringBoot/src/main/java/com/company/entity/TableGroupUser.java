/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author asgar
 */
@Entity
@Table(name = "table_group_user")
//@NamedQueries({
//    @NamedQuery(name = "TableGroupUser.findAll", query = "SELECT t FROM TableGroupUser t"),
//    @NamedQuery(name = "TableGroupUser.findById", query = "SELECT t FROM TableGroupUser t WHERE t.id = :id")
//})
public class TableGroupUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableGroup group;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public TableGroupUser() {
    }

    public TableGroupUser(Integer id, TableGroup tableGroup, User user) {
        this.id = id;
        this.group = tableGroup;
        this.user = user;
    }


    public TableGroupUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableGroup getGroup() {
        return group;
    }

    public void setGroup(TableGroup group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof TableGroupUser)) {
            return false;
        }
        TableGroupUser other = (TableGroupUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.TableGroupUser[ id=" + id + " ]";
    }

}

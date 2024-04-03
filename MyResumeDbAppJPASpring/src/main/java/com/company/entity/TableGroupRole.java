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
@Table(name = "table_group_role")
//@NamedQueries({
//    @NamedQuery(name = "TableGroupRole.findAll", query = "SELECT t FROM TableGroupRole t"),
//    @NamedQuery(name = "TableGroupRole.findById", query = "SELECT t FROM TableGroupRole t WHERE t.id = :id")
//})
public class TableGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableGroup group;

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableRole role;

    public TableGroupRole() {
    }

    public TableGroupRole(Integer id) {
        this.id = id;
    }

    public TableGroupRole(Integer id, TableGroup tableGroup, TableRole tableRole) {
        this.id = id;
        this.group = tableGroup;
        this.role = tableRole;
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

    public TableRole getRole() {
        return role;
    }

    public void setRole(TableRole role) {
        this.role = role;
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
        if (!(object instanceof TableGroupRole)) {
            return false;
        }
        TableGroupRole other = (TableGroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.TableGroupRole[ id=" + id + " ]";
    }

}

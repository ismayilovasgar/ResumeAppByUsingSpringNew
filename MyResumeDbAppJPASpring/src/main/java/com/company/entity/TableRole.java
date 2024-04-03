/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author asgar
 */
@Entity
@Table(name = "table_role")
//@NamedQueries({
//    @NamedQuery(name = "TableRole.findAll", query = "SELECT t FROM TableRole t"),
//    @NamedQuery(name = "TableRole.findById", query = "SELECT t FROM TableRole t WHERE t.id = :id"),
//    @NamedQuery(name = "TableRole.findByName", query = "SELECT t FROM TableRole t WHERE t.name = :name")
//})
public class TableRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<TableGroupRole> tableGroupRoleList;

    public TableRole() {
    }

    public TableRole(Integer id) {
        this.id = id;
    }

    public TableRole(Integer id, String name) {
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

    public List<TableGroupRole> getTableGroupRoleList() {
        return tableGroupRoleList;
    }

    public void setTableGroupRoleList(List<TableGroupRole> tableGroupRoleList) {
        this.tableGroupRoleList = tableGroupRoleList;
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
        if (!(object instanceof TableRole)) {
            return false;
        }
        TableRole other = (TableRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.TableRole[ id=" + id + " ]";
    }

}

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
@Table(name = "table_group")
//@NamedQueries({
//    @NamedQuery(name = "TableGroup.findAll", query = "SELECT t FROM TableGroup t"),
//    @NamedQuery(name = "TableGroup.findById", query = "SELECT t FROM TableGroup t WHERE t.id = :id"),
//    @NamedQuery(name = "TableGroup.findByName", query = "SELECT t FROM TableGroup t WHERE t.name = :name")
//})
public class TableGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<TableGroupRole> tableGroupRoleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<TableGroupUser> tableGroupUserList;

    public TableGroup() {
    }

    public TableGroup(Integer id) {
        this.id = id;
    }

    public TableGroup(Integer id, String name) {
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


    public List<TableGroupUser> getTableGroupUserList() {
        return tableGroupUserList;
    }

    public void setTableGroupUserList(List<TableGroupUser> tableGroupUserList) {
        this.tableGroupUserList = tableGroupUserList;
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
        if (!(object instanceof TableGroup)) {
            return false;
        }
        TableGroup other = (TableGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.TableGroup[ id=" + id + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Perpustakaan;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByIdEmployee", query = "SELECT e FROM Employee e WHERE e.idEmployee = :idEmployee"),
    @NamedQuery(name = "Employee.findByNamaEmployee", query = "SELECT e FROM Employee e WHERE e.namaEmployee = :namaEmployee")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee")
    private String idEmployee;
    @Basic(optional = false)
    @Column(name = "nama_employee")
    private String namaEmployee;

    public Employee() {
    }

    public Employee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Employee(String idEmployee, String namaEmployee) {
        this.idEmployee = idEmployee;
        this.namaEmployee = namaEmployee;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNamaEmployee() {
        return namaEmployee;
    }

    public void setNamaEmployee(String namaEmployee) {
        this.namaEmployee = namaEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.idEmployee == null && other.idEmployee != null) || (this.idEmployee != null && !this.idEmployee.equals(other.idEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PWS.Perpustakaan.Employee[ idEmployee=" + idEmployee + " ]";
    }
    
}

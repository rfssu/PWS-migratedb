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
@Table(name = "pinjam")
@NamedQueries({
    @NamedQuery(name = "Pinjam.findAll", query = "SELECT p FROM Pinjam p"),
    @NamedQuery(name = "Pinjam.findByIdPeminjaman", query = "SELECT p FROM Pinjam p WHERE p.idPeminjaman = :idPeminjaman")})
public class Pinjam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_peminjaman")
    private String idPeminjaman;

    public Pinjam() {
    }

    public Pinjam(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeminjaman != null ? idPeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pinjam)) {
            return false;
        }
        Pinjam other = (Pinjam) object;
        if ((this.idPeminjaman == null && other.idPeminjaman != null) || (this.idPeminjaman != null && !this.idPeminjaman.equals(other.idPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PWS.Perpustakaan.Pinjam[ idPeminjaman=" + idPeminjaman + " ]";
    }
    
}

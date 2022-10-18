/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Perpustakaan;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "buku")
@NamedQueries({
    @NamedQuery(name = "Buku.findAll", query = "SELECT b FROM Buku b"),
    @NamedQuery(name = "Buku.findByIdBuku", query = "SELECT b FROM Buku b WHERE b.idBuku = :idBuku"),
    @NamedQuery(name = "Buku.findByJudul", query = "SELECT b FROM Buku b WHERE b.judul = :judul"),
    @NamedQuery(name = "Buku.findByPenulis", query = "SELECT b FROM Buku b WHERE b.penulis = :penulis"),
    @NamedQuery(name = "Buku.findByPenerbit", query = "SELECT b FROM Buku b WHERE b.penerbit = :penerbit"),
    @NamedQuery(name = "Buku.findByTahun", query = "SELECT b FROM Buku b WHERE b.tahun = :tahun"),
    @NamedQuery(name = "Buku.findByCetakan", query = "SELECT b FROM Buku b WHERE b.cetakan = :cetakan")})
public class Buku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_buku")
    private Integer idBuku;
    @Basic(optional = false)
    @Column(name = "judul")
    private String judul;
    @Basic(optional = false)
    @Column(name = "penulis")
    private String penulis;
    @Basic(optional = false)
    @Column(name = "penerbit")
    private String penerbit;
    @Basic(optional = false)
    @Column(name = "tahun")
    @Temporal(TemporalType.DATE)
    private Date tahun;
    @Basic(optional = false)
    @Column(name = "cetakan")
    private String cetakan;

    public Buku() {
    }

    public Buku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Buku(Integer idBuku, String judul, String penulis, String penerbit, Date tahun, String cetakan) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.cetakan = cetakan;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public Date getTahun() {
        return tahun;
    }

    public void setTahun(Date tahun) {
        this.tahun = tahun;
    }

    public String getCetakan() {
        return cetakan;
    }

    public void setCetakan(String cetakan) {
        this.cetakan = cetakan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku)) {
            return false;
        }
        Buku other = (Buku) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PWS.Perpustakaan.Buku[ idBuku=" + idBuku + " ]";
    }
    
}

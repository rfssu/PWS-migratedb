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
@Table(name = "member")
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByIdMember", query = "SELECT m FROM Member1 m WHERE m.idMember = :idMember"),
    @NamedQuery(name = "Member1.findByNamaMember", query = "SELECT m FROM Member1 m WHERE m.namaMember = :namaMember"),
    @NamedQuery(name = "Member1.findByAlmtMember", query = "SELECT m FROM Member1 m WHERE m.almtMember = :almtMember"),
    @NamedQuery(name = "Member1.findByTelpMember", query = "SELECT m FROM Member1 m WHERE m.telpMember = :telpMember"),
    @NamedQuery(name = "Member1.findByPassMember", query = "SELECT m FROM Member1 m WHERE m.passMember = :passMember")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_member")
    private String idMember;
    @Basic(optional = false)
    @Column(name = "nama_member")
    private String namaMember;
    @Basic(optional = false)
    @Column(name = "almt_member")
    private String almtMember;
    @Basic(optional = false)
    @Column(name = "telp_member")
    private int telpMember;
    @Basic(optional = false)
    @Column(name = "pass_member")
    private String passMember;

    public Member1() {
    }

    public Member1(String idMember) {
        this.idMember = idMember;
    }

    public Member1(String idMember, String namaMember, String almtMember, int telpMember, String passMember) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.almtMember = almtMember;
        this.telpMember = telpMember;
        this.passMember = passMember;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public String getAlmtMember() {
        return almtMember;
    }

    public void setAlmtMember(String almtMember) {
        this.almtMember = almtMember;
    }

    public int getTelpMember() {
        return telpMember;
    }

    public void setTelpMember(int telpMember) {
        this.telpMember = telpMember;
    }

    public String getPassMember() {
        return passMember;
    }

    public void setPassMember(String passMember) {
        this.passMember = passMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMember != null ? idMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PWS.Perpustakaan.Member1[ idMember=" + idMember + " ]";
    }
    
}

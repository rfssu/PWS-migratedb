/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Perpustakaan;

import PWS.Perpustakaan.exceptions.NonexistentEntityException;
import PWS.Perpustakaan.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Lenovo
 */
public class PinjamJpaController implements Serializable {

    public PinjamJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWS_Perpustakaan_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PinjamJpaController() {
    }
    

    public void create(Pinjam pinjam) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pinjam);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPinjam(pinjam.getIdPeminjaman()) != null) {
                throw new PreexistingEntityException("Pinjam " + pinjam + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pinjam pinjam) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pinjam = em.merge(pinjam);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pinjam.getIdPeminjaman();
                if (findPinjam(id) == null) {
                    throw new NonexistentEntityException("The pinjam with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pinjam pinjam;
            try {
                pinjam = em.getReference(Pinjam.class, id);
                pinjam.getIdPeminjaman();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pinjam with id " + id + " no longer exists.", enfe);
            }
            em.remove(pinjam);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pinjam> findPinjamEntities() {
        return findPinjamEntities(true, -1, -1);
    }

    public List<Pinjam> findPinjamEntities(int maxResults, int firstResult) {
        return findPinjamEntities(false, maxResults, firstResult);
    }

    private List<Pinjam> findPinjamEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pinjam.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pinjam findPinjam(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pinjam.class, id);
        } finally {
            em.close();
        }
    }

    public int getPinjamCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pinjam> rt = cq.from(Pinjam.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

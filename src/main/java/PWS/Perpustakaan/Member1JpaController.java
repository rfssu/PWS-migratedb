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
public class Member1JpaController implements Serializable {

    public Member1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWS_Perpustakaan_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Member1JpaController() {
    }
    
    

    public void create(Member1 member1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(member1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMember1(member1.getIdMember()) != null) {
                throw new PreexistingEntityException("Member1 " + member1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Member1 member1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            member1 = em.merge(member1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = member1.getIdMember();
                if (findMember1(id) == null) {
                    throw new NonexistentEntityException("The member1 with id " + id + " no longer exists.");
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
            Member1 member1;
            try {
                member1 = em.getReference(Member1.class, id);
                member1.getIdMember();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The member1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(member1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Member1> findMember1Entities() {
        return findMember1Entities(true, -1, -1);
    }

    public List<Member1> findMember1Entities(int maxResults, int firstResult) {
        return findMember1Entities(false, maxResults, firstResult);
    }

    private List<Member1> findMember1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Member1.class));
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

    public Member1 findMember1(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Member1.class, id);
        } finally {
            em.close();
        }
    }

    public int getMember1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Member1> rt = cq.from(Member1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

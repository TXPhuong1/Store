package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.DongSP;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    public List<DongSP> getAll() {
        List<DongSP> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongSP order by ma asc");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(DongSP dongSP) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(DongSP dongSP, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            DongSP dsp = session.get(DongSP.class, id);
            dsp.setMa(dongSP.getMa());
            dsp.setTen(dongSP.getTen());
            session.update(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean delete(UUID id) {
        boolean check = false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            DongSP ms = session.get(DongSP.class, id);
            session.delete(ms);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public DongSP getById(UUID id) {
        DongSP dongSP = new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSP where id =: id");
            query.setParameter("id", id);
            dongSP = (DongSP) query.getSingleResult();
            dongSP = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }
}

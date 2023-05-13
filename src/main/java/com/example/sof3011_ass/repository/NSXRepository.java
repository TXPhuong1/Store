package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.NSX;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public List<NSX> getAll() {
        List<NSX> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NSX order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(NSX nhaSX, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            NSX nsx = session.get(NSX.class, id);
            nsx.setMa(nhaSX.getMa());
            nsx.setTen(nhaSX.getTen());
            session.update(nsx);
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
            NSX nsx = session.get(NSX.class, id);
            session.delete(nsx);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public NSX getById(UUID id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX where id =: id");
            query.setParameter("id", id);
            nsx = (NSX) query.getSingleResult();
            nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }
}

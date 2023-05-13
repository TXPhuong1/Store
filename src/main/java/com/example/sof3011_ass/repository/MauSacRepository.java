package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.MauSac;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    public List<MauSac> getAll() {
        List<MauSac> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(MauSac mauSac) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(MauSac mauSac, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            MauSac ms = session.get(MauSac.class, id);
            ms.setMa(mauSac.getMa());
            ms.setTen(mauSac.getTen());
            session.update(ms);
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
            MauSac ms = session.get(MauSac.class, id);
            session.delete(ms);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public MauSac getById(UUID id) {
        MauSac mauSac = new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac where id =: id");
            query.setParameter("id", id);
            mauSac = (MauSac) query.getSingleResult();
            mauSac = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }
}

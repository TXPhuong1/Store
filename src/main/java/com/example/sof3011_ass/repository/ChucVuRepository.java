package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.ChucVu;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(ChucVu chucVu) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(ChucVu chucVu, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            ChucVu cv = session.get(ChucVu.class, id);
            cv.setMa(chucVu.getMa());
            cv.setTen(chucVu.getTen());
            session.update(cv);
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
            ChucVu cv = session.get(ChucVu.class, id);
            session.delete(cv);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public ChucVu getById(UUID id) {
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu where id =: id");
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }
}

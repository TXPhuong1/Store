package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.SanPham;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        List<SanPham> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(SanPham sanPham) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(SanPham sanPham, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, id);
            sp.setMa(sanPham.getMa());
            sp.setTen(sanPham.getTen());
            session.update(sp);
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
            SanPham sp = session.get(SanPham.class, id);
            session.delete(sp);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public SanPham getById(UUID id) {
        SanPham sanPham = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham where id =: id");
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
            sanPham = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }
}

package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.CuaHang;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    public List<CuaHang> getAll() {
        List<CuaHang> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(CuaHang cuaHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(CuaHang cuaHang, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            CuaHang ch = session.get(CuaHang.class, id);
            ch.setMa(cuaHang.getMa());
            ch.setTen(cuaHang.getTen());
            ch.setDiaChi(cuaHang.getDiaChi());
            ch.setThanhPho(cuaHang.getThanhPho());
            ch.setQuocGia(cuaHang.getQuocGia());
            session.update(ch);
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
            CuaHang ch = session.get(CuaHang.class, id);
            session.delete(ch);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public CuaHang getById(UUID id) {
        CuaHang cuaHang = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang where id =: id");
            query.setParameter("id", id);
            cuaHang = (CuaHang) query.getSingleResult();
            cuaHang = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }
}

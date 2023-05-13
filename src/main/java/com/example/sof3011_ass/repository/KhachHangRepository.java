package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.KhachHang;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    public List<KhachHang> getAll() {
        List<KhachHang> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(KhachHang khachHang, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            KhachHang kh = session.get(KhachHang.class, id);
            kh.setMa(khachHang.getMa());
            kh.setTen(khachHang.getTen());
            kh.setTenDem(khachHang.getTenDem());
            kh.setHo(khachHang.getHo());
            kh.setNgaySinh(khachHang.getNgaySinh());
            kh.setSdt(khachHang.getSdt());
            kh.setDiaChi(khachHang.getDiaChi());
            kh.setThanhPho(khachHang.getThanhPho());
            kh.setQuocGia(khachHang.getQuocGia());
            kh.setMatKhau(khachHang.getMatKhau());
            session.update(kh);
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
            KhachHang ch = session.get(KhachHang.class, id);
            session.delete(ch);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public KhachHang getById(UUID id) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang where id =: id");
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}

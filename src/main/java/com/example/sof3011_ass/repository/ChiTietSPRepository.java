package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.ChiTietSP;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ChiTietSP getOne(UUID id) {
        ChiTietSP chiTietSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP WHERE id =:id");
            query.setParameter("id", id);
            chiTietSanPham = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

    public ChiTietSP search(String ma) {
        ChiTietSP chiTietSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP WHERE idSP.ma =:ma");
            query.setParameter("ma", ma);
            chiTietSanPham = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

//    public List<ChiTietSP> timKiem(UUID id) {
//        List<ChiTietSP> listTimKiem = new ArrayList<>();
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("FROM ChiTietSanPham WHERE id =:id", ChiTietSP.class);
//            query.setParameter("id", id);
//            listTimKiem = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listTimKiem;
//    }

    public Boolean add(ChiTietSP chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(UUID id, ChiTietSP chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            ChiTietSP ctsp = session.get(ChiTietSP.class, id);
            ctsp.setIdSP(chiTietSanPham.getIdSP());
            ctsp.setIdDongSP(chiTietSanPham.getIdDongSP());
            ctsp.setIdMauSac(chiTietSanPham.getIdMauSac());
            ctsp.setIdNSX(chiTietSanPham.getIdNSX());
            ctsp.setNamBH(chiTietSanPham.getNamBH());
            ctsp.setMoTa(chiTietSanPham.getMoTa());
            ctsp.setSoLuongTon(chiTietSanPham.getSoLuongTon());
            ctsp.setGiaNhap(chiTietSanPham.getGiaNhap());
            ctsp.setGiaBan(chiTietSanPham.getGiaBan());
            session.update(ctsp);
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
            ChiTietSP ctsp = session.get(ChiTietSP.class, id);
            session.delete(ctsp);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }
}

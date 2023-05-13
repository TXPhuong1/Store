package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.HoaDon;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HoaDonRepository {
    public List<HoaDon> getAll() {
        List<HoaDon> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon order by ngayTao desc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public HoaDon getById(UUID id) {
        HoaDon hoaDon = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon WHERE id =:id");
            query.setParameter("id", id);
            hoaDon = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
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

    public Boolean add(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(UUID id, HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            HoaDon hd = session.get(HoaDon.class, id);
            hd.setMa(hoaDon.getMa());
            hd.setIdKH(hoaDon.getIdKH());
            hd.setIdNV(hoaDon.getIdNV());
            hd.setNgayTao(hoaDon.getNgayTao());
            hd.setNgayNhan(hoaDon.getNgayNhan());
            hd.setNgayShip(hoaDon.getNgayShip());
            hd.setNgayThanhToan(hoaDon.getNgayThanhToan());
            hd.setTinhTrang(hoaDon.getTinhTrang());
            hd.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
            hd.setDiaChi(hoaDon.getDiaChi());
            hd.setSdt(hoaDon.getSdt());
            session.update(hd);
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
            HoaDon hd = session.get(HoaDon.class, id);
            session.delete(hd);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }
}

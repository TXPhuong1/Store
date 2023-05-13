package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.HoaDonChiTiet;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HoaDonChiTietRepository {
    public List<HoaDonChiTiet> getAll(UUID idHD) {
        List<HoaDonChiTiet> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDonChiTiet where idHoaDon.id =: idHD");
            query.setParameter("idHD", idHD);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

//    public HoaDonChiTiet getById(UUID id) {
//        HoaDon hoaDon = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("FROM HoaDon WHERE id =:id");
//            query.setParameter("id", id);
//            hoaDon = (HoaDon) query.getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return hoaDon;
//    }

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

    public Boolean add(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(UUID id, HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            HoaDonChiTiet hdct = session.get(HoaDonChiTiet.class, id);
            hdct.setSoLuong(hoaDonChiTiet.getSoLuong());
            hdct.setDonGia(hoaDonChiTiet.getDonGia());
            hdct.setIdChiTietSP(hoaDonChiTiet.getIdChiTietSP());
            session.update(hdct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<HoaDonChiTiet> getAll2() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            return session.createQuery("from HoaDonChiTiet").getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean delete(UUID idHd, UUID idSp) {
        boolean check = false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            System.out.println(idHd + "-----" + idSp);
            String query = ("delete from HoaDonChiTiet where idHoaDon =:id1 and idChiTietSP =:id2");
            Query q = session.createQuery(query);
            q.setParameter("id1", idHd);
            q.setParameter("id2", idSp);
            q.executeUpdate();
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public static void main(String[] args) {
        String id1 = "17221476-fe0b-da41-922a-3870f2ee5447";
        String id2 = "c877c9d7-abb7-3545-99dd-18c38645de51";
        UUID idHD = UUID.fromString(id1);
        UUID idSP = UUID.fromString(id2);
        new HoaDonChiTietRepository().delete(idHD, idSP);
    }
}

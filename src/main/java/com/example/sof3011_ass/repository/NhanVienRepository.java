package com.example.sof3011_ass.repository;

import com.example.sof3011_ass.entity.NhanVien;
import com.example.sof3011_ass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien order by ma asc");
            lists = query.getResultList();
        } catch (
                Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Boolean add(NhanVien nhanVien) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(NhanVien nhanVien, UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            NhanVien nv = session.get(NhanVien.class, id);
            nv.setMa(nhanVien.getMa());
            nv.setTen(nhanVien.getTen());
            nv.setTenDem(nhanVien.getTenDem());
            nv.setHo(nhanVien.getHo());
            nv.setNgaySinh(nhanVien.getNgaySinh());
            nv.setSdt(nhanVien.getSdt());
            nv.setDiaChi(nhanVien.getDiaChi());
            nv.setGioiTinh(nhanVien.getGioiTinh());
            nv.setMatKhau(nhanVien.getMatKhau());
            nv.setTrangThai(nhanVien.getTrangThai());
            nv.setIdCH(nhanVien.getIdCH());
            nv.setIdCV(nhanVien.getIdCV());
            nv.setIdGBC(nhanVien.getIdGBC());
            session.update(nv);
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
            NhanVien ch = session.get(NhanVien.class, id);
            session.delete(ch);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public NhanVien getById(UUID id) {
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien where id =: id");
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
            nhanVien = session.get(NhanVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
}

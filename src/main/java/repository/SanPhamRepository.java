package repository;

import entity.SanPham;
import org.hibernate.Session;
import util.HibernateConfig;

import java.util.List;

public class SanPhamRepository {
    //Session giống như kết nối giữa Java và database;
    //Mỗi lần muốn truy vấn DB thì cần session
    private Session session;
    //click chuột phải -> generate -> constructor
    //-> select none
    public SanPhamRepository() {
        session = HibernateConfig.getFACTORY().openSession();
        //mở phiên làm việc
    }
//    import java.util.List;
    /*
        - HQL (Hibernate Query Language) là ngôn ngữ truy vấn của Hibernate dùng để làm việc với dữ liệu
        thông qua các class Java (Entity) thay vì thao tác trực tiếp với bảng trong database
            + SQL → làm việc với bảng (table), cột (column)
            + HQL → làm việc với class (entity), thuộc tính (field)
     */
    public List<SanPham> getAll(){
        return session.createQuery("FROM SanPham ").list();
    }
    public SanPham getOne(Integer id){
        return session.find(SanPham.class, id);
    }
    public void add(SanPham sp){
        try {
            session.getTransaction().begin();//bắt đầu transaction
            session.save(sp);//lưu vào DB
            session.getTransaction().commit();//xác nhận lưu
        }catch (Exception e){
            session.getTransaction().rollback();
            //hủy toàn bộ thao tác tránh lỗi vd insert thất bại
            //rollback trạng thái ban đầu
            e.printStackTrace();//in chi tiết lỗi
        }
    }
    public void update(SanPham sp){
        try {
            session.getTransaction().begin();//bắt đầu transaction
            session.merge(sp);//lưu vào DB
            session.getTransaction().commit();//xác nhận lưu
        }catch (Exception e){
            session.getTransaction().rollback();
            //hủy toàn bộ thao tác tránh lỗi vd insert thất bại
            //rollback trạng thái ban đầu
            e.printStackTrace();//in chi tiết lỗi
        }
    }
    //xóa theo id
    public void delete(Integer id){
        try {
            session.getTransaction().begin();//bắt đầu transaction
            session.delete(this.getOne(id));//lấy đối tượng -> xóa
            session.getTransaction().commit();//xác nhận lưu
        }catch (Exception e){
            session.getTransaction().rollback();
            //hủy toàn bộ thao tác tránh lỗi vd insert thất bại
            //rollback trạng thái ban đầu
            e.printStackTrace();//in chi tiết lỗi
        }
    }
//tạo test
    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getAll());
    }
}

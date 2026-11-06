package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//copy Lombok -> đưa vào pom.xml
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //đánh dấu class này là 1 bảng table trong database
@Table(name = "SanPham")//Map Class ->bảng sản phẩm trong DB
public class SanPham {
    @Id //đánh dấu đây là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ID tự tăng -> ko cần set khi insert
    private Integer id;
    @Column(name = "Ma")//tương ứng với tên cột trong DB
    private String ma;
    @Column(name = "Ten")
    private String ten;
}

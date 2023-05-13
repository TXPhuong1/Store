var ma = document.getElementById("ma");
var ten = document.getElementById("ten");
var diaChi = document.getElementById("diaChi");
var thanhPho = document.getElementById("thanhPho");
var quocGia = document.getElementById("quocGia");
var giaNhap = document.getElementById("giaNhap");
var giaBan = document.getElementById("giaBan");
var mauSac = document.getElementById("mauSac");
var sanPham = document.getElementById("sanPham");
var nhaSX = document.getElementById("nhaSX");
var dongSP = document.getElementById("dongSP");
var namBH = document.getElementById("namBH");
var moTa = document.getElementById("moTa");
var soLuongTon = document.getElementById("soLuongTon");
var hoaDon = document.getElementById("hoaDon");
var soLuong = document.getElementById("soLuong");
var chiTietSP = document.getElementById("chiTietSP");
var nhanVien = document.getElementById("nhanVien");
var khachHang = document.getElementById("khachHang");
var ngayTao = document.getElementById("ngayTao");
var ngayNhan = document.getElementById("ngayNhan");
var ngayThanhToan = document.getElementById("ngayThanhToan");
var tenNguoiNhan = document.getElementById("tenNguoiNhan");
var ngayShip = document.getElementById("ngayShip");
var sdt = document.getElementById("sdt");
var ho = document.getElementById("ho");
var tenDem = document.getElementById("tenDem");
var ngaySinh = document.getElementById("ngaySinh");
var matKhau = document.getElementById("matKhau");
var gioiTinh = document.getElementById("gioiTinh");
var cuaHang = document.getElementById("cuaHang");
var chucVu = document.getElementById("chucVu");
var trangThai = document.getElementById("trangThai");
var pattern = /M\d+$/;
// var flag =true;
var err = 0;

function check(data, input) {
    console.log(data);
    if (data) {
        if (data.value == "") {
            alert("Vui lòng nhập đủ thông tin " + input);
            // return  false;
            err += 1;
        } else if (!isNaN(data.value)) {
            if (data.value < 0) {
                alert("Dữ liệu " + input + " phải là số dương");
                // return  false;
                err += 1;
            }
        }
    }
}

send.onclick = function () {
    err = 0;
    check(ma, "mã");
    check(ho, "họ");
    check(tenDem, "tên đệm");
    check(ten, "tên");
    check(gioiTinh, "giới tính");
    check(ngaySinh, "ngày sinh");
    check(diaChi, "địa chỉ");
    check(sdt, "sdt");
    check(thanhPho, "thành phố");
    check(quocGia, "quốc gia");
    check(nhanVien, "nhân viên");
    check(cuaHang, "cửa hàng");
    check(chucVu, "chức vụ");
    check(trangThai, "trạng thái");
    check(matKhau, "mật khẩu");
    check(sanPham, "sản phẩm");
    check(mauSac, "màu sắc");
    check(nhaSX, "nhà sản xuất");
    check(dongSP, "dòng sản phẩm");
    check(namBH, "năm bảo hành");
    check(moTa, "mô tả");
    check(soLuongTon, "số lượng tồn");
    check(giaNhap, "giá nhập");
    check(giaBan, "giá bán");
    check(khachHang, "khách hàng");
    check(hoaDon, "hóa đơn");
    check(ngayTao, "ngày tạo");
    check(ngayThanhToan, "ngày thanh toán")
    check(ngayShip, "ngày ship");
    check(ngayNhan, "ngày nhận");
    check(tenNguoiNhan, "tên người nhận")
    check(chiTietSP, "sản phẩm");
    check(soLuong, "số lượng");
    console.log(err);
    if (err > 0) {
        return false;
    } else {
        return true;
    }
}

package action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Helper;
import common.Validate;
import form.SPForm;
import model.bean.DataAjax;
import model.bean.LoaiSanPham;
import model.bo.LoaiSanPhamBO;
import model.bo.PhienDauGiaBO;

public class ThemPhienDauGiaAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		SPForm sPForm = (SPForm) form;
		
		if(null == request.getSession().getAttribute("userName")){
			return mapping.findForward("chuadangnhap");
		}
		
		// danh sach loai san pham
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		ArrayList<LoaiSanPham> listLoaiSanPham = loaiSanPhamBO.getListLoaiSanPham();
		System.out.println(loaiSanPhamBO.getListLoaiSanPham());
		sPForm.setListLoaiSanPham(listLoaiSanPham);
		
		//khởi tạo 1 ArrayList<DataAjax> để gộp các sản phẩm thuộc cùng 1 phiên đấu giá lại với nhau
		ArrayList<DataAjax> list = (ArrayList<DataAjax>) (request.getSession().getAttribute("list") != null ? (ArrayList<DataAjax>) request.getSession().getAttribute("list") : new ArrayList<DataAjax>());
//		
////		searchText = searchText.trim();
////		String searchText = new String(searchText.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
//		
//		// khi có sự kiện gửi 1 sản phẩm của 1 phiên đấu giá
//		if("them".equals(sPForm.getThem())){
//			String maLoaiSP = sPForm.getMaLoaiSP();
//			
//			//String tenSanPham =sPForm.getTenSanPham();
//			//String hangSanXuat = sPForm.getHangSanXuat();
//			String tenSanPham = sPForm.getTenSanPham();
//			String hangSanXuat = sPForm.getHangSanXuat();
//			String thoiHanBaoHanh = sPForm.getThoiHanBaoHanh();
//			//String moTa = sPForm.getMoTa();
//			String moTa = sPForm.getMoTa();
//			String[] pathfile = null;
//			String[] fileBase64 = null;
//			File[] files = null;
//			if(sPForm.getFiles() != null) {
//				pathfile = sPForm.getPathfile();
//				files = sPForm.getFiles();
//				fileBase64 = sPForm.getFileBase64();
//			}
//
//			// check validate
//			// maLoaiSP
//			ActionErrors actionErrors = new ActionErrors();
//			if(Validate.notVaild(maLoaiSP)){
//				actionErrors.add("maLoaiSPError", new ActionMessage("error.maLoaiSP.trong"));
//			}
//			else if(Validate.notVaildNumber(maLoaiSP)){
//				actionErrors.add("maLoaiSPError", new ActionMessage("error.maLoaiSP.khongphaiso"));
//			}
//			// tenSanPham
//			if(Validate.notVaild(tenSanPham)){
//				actionErrors.add("tenSanPhamError", new ActionMessage("error.tenSanPham.trong"));
//			}
//			// thoiHanBaoHanh
//			if(Validate.notVaildNumber(thoiHanBaoHanh)){
//				actionErrors.add("thoiHanBaoHanhError", new ActionMessage("error.thoiHanBaoHanh.khongphaiso"));
//			}
//			// hinh anh
////			if(files != null){
////				System.out.println("files");
////				for (File file : files) {
////					if(!Validate.isImage(file.getName())){
////						System.out.println("filessss");
////						actionErrors.add("hinhAnhError", new ActionMessage("error.hinhAnh.khongphaianh"));
////					}
////				}
////			}
//			saveErrors(request, actionErrors);
//			if(actionErrors.size()>0){
//				sPForm.setThem("");
//				return mapping.findForward("themSPError");
//			}
//			
//			
//			System.out.println("---- san pham ---- ");
//			System.out.println(maLoaiSP + " ma loai sp");
//			System.out.println(tenSanPham + " tenSanPham");
//			System.out.println(hangSanXuat + " hangSanXuat");
//			System.out.println(thoiHanBaoHanh + " thoiHanBaoHanh");
//			System.out.println(moTa + " moTa");
//			if(files != null) {
//				for (int i = 0; i < files.length; i++) {
//					System.out.println(files[i].getParentFile()+" dsdsd");
//					System.out.println(pathfile[i] + " pathfile");
//					
//				}
//			}
//
//			
//			
//			// khi các dữ liệu đầu vào của sản phẩm đã đúng định dạng
//			request.getSession().setAttribute("list", list);
//			
//			DataAjax data = new DataAjax();
//			data.setsTT(list.size());
//			data.setMaLoaiSP(maLoaiSP);
//			data.setTenSanPham(tenSanPham);
//			System.out.println("ten san pham DATA: "+data.getTenSanPham());
//			data.setHangSanXuat(hangSanXuat);
//			data.setThoiHanBaoHanh(thoiHanBaoHanh);
//			data.setMoTa(moTa);
//			if(files != null) {
//				data.setFile(files);
//				data.setPathfile(pathfile);
//				data.setFileBase64(fileBase64);
//			}
//			list.add(data);
//			
//			// gán thông tin sản phẩm vào trong list đã tạo
//			sPForm.setData(list);
//			sPForm.setThem("");
//			sPForm.setSubmit("");
//			
//			return mapping.findForward("themxong");
//			
//		} 
		// khi có sự kiện hoàn thành phiên đấu giá
		if("submit".equals(sPForm.getSubmit())){
			String tenpdg = sPForm.getTenpdg();
			String iDNguoiTao = (String) request.getSession().getAttribute("id");
			String ngayBatDau = sPForm.getThoiGianBatDau();
			String gioBatDau = sPForm.getGioBatDau();
			String thoiGianBatDau = ngayBatDau + " " + gioBatDau;
			String ngayKetThuc = sPForm.getThoiGianKetThuc();
			String gioKetThuc = sPForm.getGioKetThuc();
			String thoiGianKetThuc = ngayKetThuc + " " + gioKetThuc;
			String loaiPhienDauGia = sPForm.getLoaiPhienDauGia();
			String tinhTrang = sPForm.getTinhTrang();
			String giaDeNghi = sPForm.getGiaDeNghi();
			String buocGia = sPForm.getBuocGia();
			
			

			// check validate
			ActionErrors actionErrors = new ActionErrors();
			
			// ten phien dau gia
			if(Validate.notVaild(tenpdg)){
				actionErrors.add("tenpdgError", new ActionMessage("error.tenpdg.trong"));
			}
			// thoi gian bat dau
			if(Validate.notVaild(thoiGianBatDau.trim())){
				actionErrors.add("thoiGianBatDauError", new ActionMessage("error.thoiGianBatDau.trong"));
			}
			// thoi gian ket thuc
			if(Validate.notVaild(thoiGianKetThuc.trim())){
				actionErrors.add("thoiGianKetThucError", new ActionMessage("error.thoiGianKetThuc.trong"));
			}
			else if(!Validate.isDateStartLessThanDateEnd(thoiGianBatDau, thoiGianKetThuc)) {
				actionErrors.add("thoiGianKetThucError", new ActionMessage("error.thoiGianKetThuc.truoc"));
			}
			// gia de nghi
			if(Validate.notVaild(giaDeNghi)){
				actionErrors.add("giaDeNghiError", new ActionMessage("error.giaDeNghi.trong"));
			}
			else if(Validate.notVaildNumber(giaDeNghi)){
				actionErrors.add("giaDeNghiError", new ActionMessage("error.giaDeNghi.khongphaiso"));
			}
			// buoc gia
			if(Validate.notVaild(buocGia)){
				actionErrors.add("buocGiaError", new ActionMessage("error.buocGia.trong"));
			}
			else if(Validate.notVaildNumber(buocGia)){
				actionErrors.add("buocGiaError", new ActionMessage("error.buocGia.khongphaiso"));
			}
			// loai phien dau gia
			if(Validate.notVaild(loaiPhienDauGia)){
				actionErrors.add("loaiPhienDauGiaError", new ActionMessage("error.loaiPhienDauGia.trong"));
			}
			
			// check xem da co san pham nao chua
			if(list == null){
				actionErrors.add("sanPhamError", new ActionMessage("error.sanPham.rong"));
			}
			
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				sPForm.setSubmit("");
				return mapping.findForward("themPDGError");
			}

			System.out.println("--- submit len db ---");
			System.out.println(tenpdg + " tenpdg");
			System.out.println(iDNguoiTao + " iDNguoiTao");
			System.out.println(thoiGianBatDau + " thoiGianBatDau");
			System.out.println(thoiGianKetThuc + " thoiGianKetThuc");
			System.out.println(loaiPhienDauGia + " loaiPhienDauGia");
			System.out.println(tinhTrang + " tinhTrang");
			System.out.println(giaDeNghi + " giaDeNghi");
			System.out.println(buocGia + " buocGia");
			
			// khi các dữ liệu đã đúng định dạng
			
			PhienDauGiaBO phienDauGiaBO = new PhienDauGiaBO();
			
			ArrayList<DataAjax> listt = sPForm.getData();
			for (DataAjax dataAjax : list) {
				System.out.println("san pham --");
				System.out.println(dataAjax.getTenSanPham());
				
				String[] fileBase64 = dataAjax.getFileBase64();
				ArrayList<String> fileNames = new ArrayList<String>();
				for (String file : fileBase64) {
					Date date = new Date();
					long timeInMillis = date.getTime();
					String filename = timeInMillis + ".png";
					Helper.uploadFile(file.split(",")[1], "D:\\mock\\MyProject-master\\Project_Struts\\WebContent\\img\\" + filename);
					
					System.out.println("path ---- " + file);
					fileNames.add(filename);
				}
				
				dataAjax.setFileName(fileNames);
			}
			
			phienDauGiaBO.themMoiPhienDauGia(tenpdg,iDNguoiTao,thoiGianBatDau,thoiGianKetThuc,loaiPhienDauGia,tinhTrang,giaDeNghi,buocGia,list);
			
			
			
			list.clear();
			sPForm.setData(list);
			sPForm.setSubmit("");
			return mapping.findForward("themxongphiendaugia");
		}
		// xoa 1 san pham ra khoi phien dau gia
		if("xoa".equals(sPForm.getXoa())){
			System.out.println(sPForm.getTenSanPham() + " - ddddddddddddddddddddddddddd");
			int index = 0;
			if(list != null){
				for (DataAjax l : list) {
					System.out.println("sPForm.getTenSanPham().equals(l.getTenSanPham()) " + sPForm.getTenSanPham().equals(l.getTenSanPham()));
					if(sPForm.getTenSanPham().equals(l.getTenSanPham())) {
						System.out.println("index " + index);
						
						list.remove(index);
			            System.out.println("list " + list);
			            break;
					}
					index++;
				}
			}
			sPForm.setData(list);
			sPForm.setSubmit("");
			sPForm.setXoa("");
			return mapping.findForward("xoa1sanpham");
		}
		// huy phien dau gia dang tao
		if("huy".equals(sPForm.getHuy())) {
			list.clear();
			sPForm.setData(list);
			sPForm.setSubmit("");
			sPForm.setHuy("");
			return mapping.findForward("huyphiendaugia");
		}
		// khi f5 trình duyệt
		else{
			System.out.println("ccc");
			sPForm.setSubmit("");
			sPForm.setHuy("");
			sPForm.setThem("");
			return mapping.findForward("them");
		}
	}
	
}

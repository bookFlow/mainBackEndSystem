package com.wkzhng.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.IBookManage;

public class SaleBookAction implements Action{
	
	@Resource
	private IBookManage bookManage;
	
	private String name;
	private String uid;
	private String x;
	private String y;
	private String des;
    private String productor;
    private String company;
    private String price;
    private String pname;
    
    private List<File> image;
	
	private List<String> imageFileName;
    private List<String> imageContentType;
    
    private Map<String, Object> dataMap;
    
    public IBookManage getBookManage() {
		return bookManage;
	}
    
    public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
    
    public List<File> getImage() {
		return image;
	}
    
    public List<String> getImageContentType() {
		return imageContentType;
	}
    
    public List<String> getImageFileName() {
		return imageFileName;
	}
    
    public void setImage(List<File> image) {
		this.image = image;
	}
    
    public void setImageContentType(List<String> imageContentType) {
		this.imageContentType = imageContentType;
	}
    
    public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}
    
    public String getPname() {
		return pname;
	}
    
    public void setPname(String pname) {
		this.pname = pname;
	}
    
    public String getCompany() {
		return company;
	}
    
    public void setCompany(String company) {
		this.company = company;
	}
    
    public String getDes() {
		return des;
	}
    
    public void setDes(String des) {
		this.des = des;
	}
    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getPrice() {
		return price;
	}
    
    public void setPrice(String price) {
		this.price = price;
	}
    
    public String getProductor() {
		return productor;
	}
    
    public void setProductor(String productor) {
		this.productor = productor;
	}
    
    public String getUid() {
		return uid;
	}
    
    public void setUid(String uid) {
		this.uid = uid;
	}
    
    public String getX() {
		return x;
	}
    public void setX(String x) {
		this.x = x;
	}
    
    public String getY() {
		return y;
	}
    
    public void setY(String y) {
		this.y = y;
	}
    
    public Map<String, Object> getDataMap() {
		return dataMap;
	}
    
    public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
    
    @Override
    public String execute(){
    	System.out.println("SaleBookAction is working");
    	dataMap = new HashMap<>();
    	
    	String images = "";
    	String dir = ServletActionContext.getServletContext().getRealPath("/image");
    	File fileLocation = new File(dir);
		if (!fileLocation.exists()) {
			boolean isCreated = fileLocation.mkdir();
			if (!isCreated) {
				return "error";
			}
		}
		
		try{
			for(int i = 0; i < image.size(); i++){
				InputStream in = new FileInputStream(image.get(i));
				String fileName = this.getImageFileName().get(i);
				File uploadFile = new File(dir, fileName);
				OutputStream out = new FileOutputStream(uploadFile);
				byte[] buffer = new byte[1024 * 1024];
				int length;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
				in.close();
				out.close();
				images += fileName + ";";
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
    	
		System.out.println(images);
		
    	String result = bookManage.addBook(uid, name, Double.parseDouble(x), Double.parseDouble(y), 
    			des, productor, company, images, Double.parseDouble(price), pname);
    	if(result.equals(Const.SUCCEED))
    		dataMap.put("isSucceed", true);
    	else
    		dataMap.put("isSucceed", false);
    	return SUCCESS;
    }
}

package model;

import java.util.Date;

public class CctvVO {
	private int field_seq, cctv_no;
	private String field_name, rtsp, cctv_name, directory, hls_url;
	private Date created_at, updated_at, last_commu;
	
	
	
	public String getHls_url() {
		return hls_url;
	}
	public void setHls_url(String hls_url) {
		this.hls_url = hls_url;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public int getCctv_no() {
		return cctv_no;
	}
	public void setCctv_no(int cctv_no) {
		this.cctv_no = cctv_no;
	}
	public String getCctv_name() {
		return cctv_name;
	}
	public void setCctv_name(String cctv_name) {
		this.cctv_name = cctv_name;
	}
	public int getField_seq() {
		return field_seq;
	}
	public void setField_seq(int field_seq) {
		this.field_seq = field_seq;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getRtsp() {
		return rtsp;
	}
	public void setRtsp(String rtsp) {
		this.rtsp = rtsp;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getLast_commu() {
		return last_commu;
	}
	public void setLast_commu(Date last_commu) {
		this.last_commu = last_commu;
	}
	
}

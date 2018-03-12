package com.portfolio.yshome.domain;

public class FileDTO {
	private int fno;
	private int fgroup;
	private String filename;
	private String filetype;
	
	public FileDTO() {
		
	}

	public FileDTO(int fno, int fgroup, String filename, String filetype) {
		super();
		this.fno = fno;
		this.fgroup = fgroup;
		this.filename = filename;
		this.filetype = filetype;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFgroup() {
		return fgroup;
	}

	public void setFgroup(int fgroup) {
		this.fgroup = fgroup;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", fgroup=" + fgroup + ", filename=" + filename + ", filetype=" + filetype + "]";
	}
	
	
}

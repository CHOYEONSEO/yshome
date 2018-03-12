package com.portfolio.yshome.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardDTO {

	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private Integer nextbno;
	private String nexttitle;
	private String nextcontent;
	private String nextwriter;
	private Date nextregdate;
	private int nextviewcnt;
	private Integer prevbno;
	private String prevtitle;
	private String prevcontent;
	private String prevwriter;
	private Timestamp prevregdate;
	private int prevviewcnt;
	private int bgroup;
	private int bseq;
	private int depth;
	private int nextbgroup;
	private int nextbseq;
	private int nextdepth;
	private int prevbgroup;
	private int prevbseq;
	private int prevdepth;

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(Integer bno, String title, String content, String writer, Date regdate, int viewcnt,
			Integer nextbno, String nexttitle, String nextcontent, String nextwriter, Date nextregdate, int nextviewcnt,
			Integer prevbno, String prevtitle, String prevcontent, String prevwriter, Timestamp prevregdate,
			int prevviewcnt, int bgroup, int bseq, int depth, int nextbgroup, int nextbseq, int nextdepth,
			int prevbgroup, int prevbseq, int prevdepth) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.nextbno = nextbno;
		this.nexttitle = nexttitle;
		this.nextcontent = nextcontent;
		this.nextwriter = nextwriter;
		this.nextregdate = nextregdate;
		this.nextviewcnt = nextviewcnt;
		this.prevbno = prevbno;
		this.prevtitle = prevtitle;
		this.prevcontent = prevcontent;
		this.prevwriter = prevwriter;
		this.prevregdate = prevregdate;
		this.prevviewcnt = prevviewcnt;
		this.bgroup = bgroup;
		this.bseq = bseq;
		this.depth = depth;
		this.nextbgroup = nextbgroup;
		this.nextbseq = nextbseq;
		this.nextdepth = nextdepth;
		this.prevbgroup = prevbgroup;
		this.prevbseq = prevbseq;
		this.prevdepth = prevdepth;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Integer getNextbno() {
		return nextbno;
	}

	public void setNextbno(Integer nextbno) {
		this.nextbno = nextbno;
	}

	public String getNexttitle() {
		return nexttitle;
	}

	public void setNexttitle(String nexttitle) {
		this.nexttitle = nexttitle;
	}

	public String getNextcontent() {
		return nextcontent;
	}

	public void setNextcontent(String nextcontent) {
		this.nextcontent = nextcontent;
	}

	public String getNextwriter() {
		return nextwriter;
	}

	public void setNextwriter(String nextwriter) {
		this.nextwriter = nextwriter;
	}

	public Date getNextregdate() {
		return nextregdate;
	}

	public void setNextregdate(Date nextregdate) {
		this.nextregdate = nextregdate;
	}

	public int getNextviewcnt() {
		return nextviewcnt;
	}

	public void setNextviewcnt(int nextviewcnt) {
		this.nextviewcnt = nextviewcnt;
	}

	public Integer getPrevbno() {
		return prevbno;
	}

	public void setPrevbno(Integer prevbno) {
		this.prevbno = prevbno;
	}

	public String getPrevtitle() {
		return prevtitle;
	}

	public void setPrevtitle(String prevtitle) {
		this.prevtitle = prevtitle;
	}

	public String getPrevcontent() {
		return prevcontent;
	}

	public void setPrevcontent(String prevcontent) {
		this.prevcontent = prevcontent;
	}

	public String getPrevwriter() {
		return prevwriter;
	}

	public void setPrevwriter(String prevwriter) {
		this.prevwriter = prevwriter;
	}

	public Timestamp getPrevregdate() {
		return prevregdate;
	}

	public void setPrevregdate(Timestamp prevregdate) {
		this.prevregdate = prevregdate;
	}

	public int getPrevviewcnt() {
		return prevviewcnt;
	}

	public void setPrevviewcnt(int prevviewcnt) {
		this.prevviewcnt = prevviewcnt;
	}

	public int getBgroup() {
		return bgroup;
	}

	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getNextbgroup() {
		return nextbgroup;
	}

	public void setNextbgroup(int nextbgroup) {
		this.nextbgroup = nextbgroup;
	}

	public int getNextbseq() {
		return nextbseq;
	}

	public void setNextbseq(int nextbseq) {
		this.nextbseq = nextbseq;
	}

	public int getNextdepth() {
		return nextdepth;
	}

	public void setNextdepth(int nextdepth) {
		this.nextdepth = nextdepth;
	}

	public int getPrevbgroup() {
		return prevbgroup;
	}

	public void setPrevbgroup(int prevbgroup) {
		this.prevbgroup = prevbgroup;
	}

	public int getPrevbseq() {
		return prevbseq;
	}

	public void setPrevbseq(int prevbseq) {
		this.prevbseq = prevbseq;
	}

	public int getPrevdepth() {
		return prevdepth;
	}

	public void setPrevdepth(int prevdepth) {
		this.prevdepth = prevdepth;
	}

	@Override
	public String toString() {
		return "BoardDTO " + "[bno = " + bno + ", title = " + title 
				+ ", content = " + content + ", writer = " + writer
				+ ", regdate = " + regdate + ", viewcnt = " + viewcnt + "]" 
				+ "[nextbno = " + nextbno + ", nexttitle = " + nexttitle 
				+ ", nextcontent = " + nextcontent + ", nextwriter = " + nextwriter 
				+ ", nextregdate = " + nextregdate + ", nextviewcnt = " + nextviewcnt + "]" 
				+ "[prevbno = " + prevbno + ", prevtitle = " + prevtitle 
				+ ", prevcontent = " + prevcontent + ", prevwriter = " + prevwriter 
				+ ", prevregdate = " + prevregdate + ", prevregdate = " + prevregdate 
				+ ", prevviewcnt = " + prevviewcnt + ", bgroup = " + bgroup
				+ ", bseq = " + bseq + ", depth = " + depth
				+ ", nextbgroup = " + nextbgroup + ", nextbseq = " + nextbseq
				+ ", nextdepth = " + nextdepth + ", prevgroup = " + prevbgroup
				+ ", prevbseq = " + prevbseq + ", prevdepth = " + prevdepth
				+ "]";
	}
}

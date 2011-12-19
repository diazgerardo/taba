package ar.com.scriptorum.taba.util.documents;

public interface BasicDocument {
	public String getDepartment();
	public void setDepartment(String deptarment);
	public String getDocName();
	public void setDocName(String docName);
	public void accept( DocumentVisitor dv);
}

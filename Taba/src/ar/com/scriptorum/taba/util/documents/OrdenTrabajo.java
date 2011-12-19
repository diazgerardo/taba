package ar.com.scriptorum.taba.util.documents;

public class OrdenTrabajo implements BasicDocument {

	private String department;
	private String docName;

	public OrdenTrabajo() {
		this.docName = Constants.ORDEN_DE_TRABAJO;
	}

	@Override
	public String getDepartment() {
		return this.department;
	}

	@Override
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String getDocName() {
		return this.docName;
	}

	@Override
	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public void accept(DocumentVisitor dv) {
		dv.visit(this);
	}

}

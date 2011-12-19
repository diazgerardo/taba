package ar.com.scriptorum.taba.util.documents;

public class AutorizacionIngreso implements BasicDocument {

	private String department;
	private String docName;

	public AutorizacionIngreso() {
		this.docName = Constants.AUTORIZACION_DE_INGRESO;
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
	public void accept(DocumentVisitor dv) {
		dv.visit(this);
	}

	@Override
	public String getDocName() {
		return this.docName;
	}

	@Override
	public void setDocName(String docName) {
		this.docName = docName;
	}

}

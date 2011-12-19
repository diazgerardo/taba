package ar.com.scriptorum.taba.util.documents;

public class OperacionesConfigurator implements DocumentVisitor {

	@Override
	public void visit(OrdenTrabajo f) {
		f.setDepartment(Constants.OPERACIONES);
	}

	@Override
	public void visit(AutorizacionIngreso r) {
		r.setDepartment(Constants.OPERACIONES);
	}

}

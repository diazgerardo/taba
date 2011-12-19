package ar.com.scriptorum.taba.util.documents;

public class IngenieriaConfigurator implements DocumentVisitor {

	@Override
	public void visit(OrdenTrabajo f) {
		f.setDepartment(Constants.INGENIERIA);
	}

	@Override
	public void visit(AutorizacionIngreso r) {
		r.setDepartment(Constants.INGENIERIA);
	}

}

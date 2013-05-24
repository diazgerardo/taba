package com.scriptorum.polymorphism;

import com.scriptorum.polymorphism.PorfinReader.Layout;

public class EdealerReader extends CSVReader {

	@Override
	Order getOrder() {
		Order order = new Order();
		String[] fieldValues = nextRecord();
		order.setNombre(fieldValues[Layout.NOMBRE.ndx()]);
		order.setApellido(fieldValues[Layout.APELLIDO.ndx()]);
		order.setDireccion(fieldValues[Layout.DIRECCION.ndx()]);
		return order;
	}

	public enum Layout {
		NOMBRE(2), APELLIDO(1), DIRECCION(0);

		private int ndx;

		private Layout(int i) {
			ndx = i;
		}

		public int ndx() {
			return ndx;
		}
	}

}

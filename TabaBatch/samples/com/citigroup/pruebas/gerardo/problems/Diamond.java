package com.citigroup.pruebas.gerardo.problems;

public class Diamond implements CrownFacet, PavillionFacet {

	public CrownFacet getFacet() {
		return new CrownFacet() {
			public CrownFacet getFacet() {
				return null;
			}
		};
	}

//	public PavillionFacet getFacet() {
//		return new PavillionFacet() {
//			public PavillionFacet getFacet() {
//				return null;
//			}
//		};
//	}

}

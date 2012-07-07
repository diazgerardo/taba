package ar.com.scriptorum.diamonds;

/**
 * Demonstrates the Diamond problem
 * @author gerardo
 *
 */
public class Diamond implements CrownFacet, PavillionFacet {
	
	public CrownFacet getCrownFacet() {
		return new CrownFacet() {
			public CrownFacet getFacet() {
				return null;
			}
		};
	}

	public PavillionFacet getFacet() {
		return new PavillionFacet() {
			public PavillionFacet getFacet() {
				return null;
			}
		};
	}

}

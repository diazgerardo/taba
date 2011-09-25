package ar.com.scriptorum.taba.database;

import java.util.ArrayList;
import java.util.List;

import ar.com.scriptorum.taba.abstractions.Vertice;

public class VerticeDao {
	
	public List <Vertice> findVertices(Vertice vertice, int magnitud) {
		// TODO this list is expected to retrieve from the database all of the vertices near vertice.
		// "near" means located inside the square box centered at the vertice received, and whose sides
		// are determined by the magnitud received as parameter...
		
		List<Vertice> list = new ArrayList<Vertice>();
		return list;
	}

}

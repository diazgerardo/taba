package ar.com.scriptorum.taba.beans;

import java.util.ArrayList;
import java.util.List;

public class DTSystem {

	private List<Defect> defects;

	public DTSystem(){
		defects = new ArrayList<Defect>();
	}
	
	public void addDefect(Defect defect){
		defects.add(defect);
	}
	
	public List<Defect> getDefects() {
		return defects;
	}

	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}	
	
}

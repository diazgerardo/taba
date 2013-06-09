package ar.com.scriptorum.taba.beans;

import java.util.Date;

public class Release {

	private String name;
	private Date releaseDate;
	
	public Release(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean equals(Object object){
		
		if (!(object instanceof Release)){
			return false;
		}
		
		Release incomingRelease = (Release)object;
		return name.equals(incomingRelease.name);
	}
	
	public int hashCode(){
		return 1212 + name.hashCode();
	}

	public String toString(){
		return name;
	}
}

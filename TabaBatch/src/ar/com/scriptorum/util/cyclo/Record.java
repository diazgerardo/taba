package ar.com.scriptorum.util.cyclo;

public class Record {

	private String module;
	private String name;
	private int lines;
	private int size;
	private int maxParams;
	private String results;

	public void setModule(String module) {

		this.module = module;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setMaxParam(int maxParams) {
		this.maxParams = maxParams;
	}

	public void setResults(String result) {
		this.results = result;
	}

	public int getMaxParams() {
		return maxParams;
	}

	public void setMaxParams(int maxParams) {
		this.maxParams = maxParams;
	}

	public String getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

	public int getLines() {
		return lines;
	}

	public int getSize() {
		return size;
	}

	public String getResults() {
		return results;
	}

}

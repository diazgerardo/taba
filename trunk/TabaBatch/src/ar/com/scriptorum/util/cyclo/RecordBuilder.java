package ar.com.scriptorum.util.cyclo;


public class RecordBuilder {

	Record record;
	public RecordBuilder() {
		this.record = new Record();
	}
	public RecordBuilder setModule(String module) {
		record.setModule(module);
		return this;
	}

	public RecordBuilder setName(String name) {
		record.setName(name);
		return this;
	}

	public RecordBuilder setLines(int lines) {
		record.setLines(lines);
		return this;
	}

	public RecordBuilder setSize(int size) {
		record.setSize(size);
		return this;
	}

	public RecordBuilder setMaxParam(int maxParams) {
		record.setMaxParam(maxParams);
		return this;
	}
	public RecordBuilder setResults(String result) {
		record.setResults(result);
		return this;
	}
	
	public Record build() {
		return record;
	}

}

package com.pbarczewski.dataPath;

public enum Path {
	
	PATH("http://localhost:8080/api");
	
	private String apiPath;
	
	private Path(String apiPath) {
		this.apiPath = apiPath;
	}

	public String getApiPath() {
		return apiPath;
	}
}

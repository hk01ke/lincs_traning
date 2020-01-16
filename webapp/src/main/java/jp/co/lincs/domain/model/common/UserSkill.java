package jp.co.lincs.domain.model.common;

import java.io.Serializable;

public class UserSkill implements Serializable {

	private String os;
	private String language;
	private String db;
	private String other;

	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}



}

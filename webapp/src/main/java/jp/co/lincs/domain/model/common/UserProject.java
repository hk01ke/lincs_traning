package jp.co.lincs.domain.model.common;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class UserProject implements Serializable {

	private String projectId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String industry;
	private String role;
	private String os;
	private String db;
	private String language;
	private String tool;
	private String phase;
	private String content;

	private String phaseResearchFlg;
	private String phaseRequirementFlg;
	private String phaseBasicDesignFlg;
	private String phaseDetailedDesignFlg;
	private String phaseCodingFlg;
	private String phaseUnitTestFlg;
	private String phaseItTestFlg;
	private String phaseStTestFlg;
	private String phaseUatFlg;
	private String phaseMaintenanceFlg;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhaseResearchFlg() {
		return phaseResearchFlg;
	}

	public void setPhaseResearchFlg(String phaseResearchFlg) {
		this.phaseResearchFlg = phaseResearchFlg;
	}

	public String getPhaseRequirementFlg() {
		return phaseRequirementFlg;
	}

	public void setPhaseRequirementFlg(String phaseRequirementFlg) {
		this.phaseRequirementFlg = phaseRequirementFlg;
	}

	public String getPhaseBasicDesignFlg() {
		return phaseBasicDesignFlg;
	}

	public void setPhaseBasicDesignFlg(String phaseBasicDesignFlg) {
		this.phaseBasicDesignFlg = phaseBasicDesignFlg;
	}

	public String getPhaseDetailedDesignFlg() {
		return phaseDetailedDesignFlg;
	}

	public void setPhaseDetailedDesignFlg(String phaseDetailedDesignFlg) {
		this.phaseDetailedDesignFlg = phaseDetailedDesignFlg;
	}

	public String getPhaseCodingFlg() {
		return phaseCodingFlg;
	}

	public void setPhaseCodingFlg(String phaseCodingFlg) {
		this.phaseCodingFlg = phaseCodingFlg;
	}

	public String getPhaseUnitTestFlg() {
		return phaseUnitTestFlg;
	}

	public void setPhaseUnitTestFlg(String phaseUnitTestFlg) {
		this.phaseUnitTestFlg = phaseUnitTestFlg;
	}

	public String getPhaseItTestFlg() {
		return phaseItTestFlg;
	}

	public void setPhaseItTestFlg(String phaseItTestFlg) {
		this.phaseItTestFlg = phaseItTestFlg;
	}

	public String getPhaseStTestFlg() {
		return phaseStTestFlg;
	}

	public void setPhaseStTestFlg(String phaseStTestFlg) {
		this.phaseStTestFlg = phaseStTestFlg;
	}

	public String getPhaseUatFlg() {
		return phaseUatFlg;
	}

	public void setPhaseUatFlg(String phaseUatFlg) {
		this.phaseUatFlg = phaseUatFlg;
	}

	public String getPhaseMaintenanceFlg() {
		return phaseMaintenanceFlg;
	}

	public void setPhaseMaintenanceFlg(String phaseMaintenanceFlg) {
		this.phaseMaintenanceFlg = phaseMaintenanceFlg;
	}


	public String getDispPeriod() {
	    Calendar calFrom = Calendar.getInstance();
	    calFrom.setTime(startDate);
	    calFrom.set(Calendar.DATE, 1);

	    Calendar calTo = Calendar.getInstance();
	    calTo.setTime(endDate);
	    calTo.set(Calendar.DATE, 1);

	    int count = 0;
	    while (calFrom.before(calTo)) {
	        calFrom.add(Calendar.MONTH, 1);
	        count++;
	    }
		return count + "ヵ月";
	}

	public String getDispPhaseResearch() {
		if ("1".equals(getPhaseResearchFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseRequirement() {
		if ("1".equals(getPhaseRequirementFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseBasicDesign() {
		if ("1".equals(getPhaseBasicDesignFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseDetailedDesign() {
		if ("1".equals(getPhaseDetailedDesignFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseCodingUnitTest() {
		// TODO 製造とテストはひとつの項目となるため、
		// 製造フラグのみを見る
		if ("1".equals(getPhaseCodingFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseUnitTest() {
		if ("1".equals(getPhaseUnitTestFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseItTestFlg() {
		if ("1".equals(getPhaseItTestFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseStTestFlg() {
		if ("1".equals(getPhaseStTestFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseUatFlg() {
		if ("1".equals(getPhaseUatFlg())) {
			return "〇";
		}
		return "";
	}

	public String getDispPhaseMaintenanceFlg() {
		if ("1".equals(getPhaseMaintenanceFlg())) {
			return "〇";
		}
		return "";
	}

}

package PojoClass;

public class TYProject {

	String projectName;
	String createdBy;
	String status;
	int teamSize;
	public TYProject(String projectName, String createdBy, String status, int teamSize) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getStatus() {
		return status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}

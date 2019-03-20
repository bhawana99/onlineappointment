package project.com.dao;

import java.util.List;

import project.com.bo.Report;

public interface ReportDao {

	public abstract List<Report> getAllReport();
	public abstract void setInfo(Report r, Long p_id);
	public abstract boolean delete(Long id);
	public abstract List<Report> getReportById(String id);

}

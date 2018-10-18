package com.example.rockalhost.model.chart.dao;

import java.util.List;

import com.example.rockalhost.model.chart.dto.ChartDTO;

public interface ChartDAO {
	public List<ChartDTO> getChartGenre();
	public List<ChartDTO> getChartArea();
	public List<ChartDTO> getChartBand();
	public List<ChartDTO> getChartSex();
	public List<ChartDTO> getChartAge();
	public List<ChartDTO> getChartPosition();
	public List<ChartDTO> getChartB_area();
	public List<ChartDTO> getChartB_genre();
}

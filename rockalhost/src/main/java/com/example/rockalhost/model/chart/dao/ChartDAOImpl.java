package com.example.rockalhost.model.chart.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.chart.dto.ChartDTO;

@Repository
public class ChartDAOImpl implements ChartDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ChartDTO> getChartGenre() {
		return sqlSession.selectList("chart.getChartGenre");
	}

	@Override
	public List<ChartDTO> getChartArea() {
		return sqlSession.selectList("chart.getChartArea");
	}

	@Override
	public List<ChartDTO> getChartBand() {
		return sqlSession.selectList("chart.getChartBand");
	}

	@Override
	public List<ChartDTO> getChartSex() {
		return sqlSession.selectList("chart.getChartSex");
	}

	@Override
	public List<ChartDTO> getChartAge() {
		return sqlSession.selectList("chart.getChartAge");
	}

	@Override
	public List<ChartDTO> getChartPosition() {
		return sqlSession.selectList("chart.getChartPosition");
	}

	@Override
	public List<ChartDTO> getChartB_area() {
		return sqlSession.selectList("chart.getChartB_area");
	}

	@Override
	public List<ChartDTO> getChartB_genre() {
		return sqlSession.selectList("chart.getChartB_genre");
	}
	
}

package com.example.rockalhost.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.rockalhost.model.chart.dao.ChartDAO;
import com.example.rockalhost.model.chart.dto.ChartDTO;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {
	
	@Inject
	ChartDAO chartDao;

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartGenre() {
		List<ChartDTO> items = chartDao.getChartGenre();

		JSONObject data=new JSONObject();

		JSONObject col1=new JSONObject();
		JSONObject col2=new JSONObject();
		
		JSONArray title=new JSONArray();

		col1.put("label", "장르");
		col1.put("type", "string");
		col2.put("label", "공연횟수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartArea() {
		List<ChartDTO> items = chartDao.getChartArea();

		JSONObject data=new JSONObject();

		JSONObject col1=new JSONObject();
		JSONObject col2=new JSONObject();
		
		JSONArray title=new JSONArray();

		col1.put("label", "지역");
		col1.put("type", "string");
		col2.put("label", "공연횟수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartBand() {
		List<ChartDTO> items = chartDao.getChartBand();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "밴드이름");
		col1.put("type", "string");
		col2.put("label", "공연횟수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartSex() {
		List<ChartDTO> items = chartDao.getChartSex();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "성별");
		col1.put("type", "string");
		col2.put("label", "회원수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartAge() {
		List<ChartDTO> items = chartDao.getChartAge();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "나이대");
		col1.put("type", "string");
		col2.put("label", "회원수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartPosition() {
		List<ChartDTO> items = chartDao.getChartPosition();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "메인포지션");
		col1.put("type", "string");
		col2.put("label", "회원수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartB_area() {
		List<ChartDTO> items = chartDao.getChartB_area();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "지역");
		col1.put("type", "string");
		col2.put("label", "밴드수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getChartB_genre() {
		List<ChartDTO> items = chartDao.getChartB_genre();

		JSONObject data=new JSONObject();

		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();

		col1.put("label", "장르");
		col1.put("type", "string");
		col2.put("label", "밴드수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title);

		JSONArray body = new JSONArray();
		for(ChartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getC_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getC_count());
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

}

package com.appspot.egun.money.ws.dto;

import com.appspot.egun.money.comp.utility.DateU;

/**
 * 시작일, 종료일
 * @author dongchimi
 *
 */
public class StartEndDateDto {
	private String startDay;
	private String endDay;
	
	public StartEndDateDto() {
	}
	
	public void setStartEndBaseDayByToday(String today, String baseDay) {
		String baseDate = today.substring(0, 6) + baseDay;
		
		// 기준일 기준으로 한달을 가져옴.
		int todayI = Integer.parseInt(today);
		int baseDayI = Integer.parseInt(baseDate);
		
		if (todayI < baseDayI) {
			startDay = DateU.addMonth(baseDate, -1);
			endDay = baseDate;
		}
		else if (todayI >= baseDayI) {
			startDay = baseDate;
			endDay = DateU.addMonth(baseDate, 1);
		}
		
		endDay = DateU.addDate(endDay, -1);
	}
	
	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
}

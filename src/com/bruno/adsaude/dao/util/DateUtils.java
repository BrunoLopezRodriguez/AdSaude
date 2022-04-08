package com.bruno.adsaude.dao.util;

import java.util.Calendar;

public class DateUtils {

	public static final char LUNES = 'L';
	public static final char MARTES = 'M';
	public static final char MIERCOLES = 'X';
	public static final char JUEVES = 'J';
	public static final char VIERNES = 'V';
	public static final char SABADO = 'S';
	public static final char DOMINGO = 'D';
	
	public static final char getDiaSemana(int calendarDayOfWeek) {
		char diaSemana = '0';
		if (calendarDayOfWeek == Calendar.MONDAY) {
			diaSemana = LUNES ;
		} else if (calendarDayOfWeek == Calendar.TUESDAY) {
			diaSemana = MARTES;
		} else if (calendarDayOfWeek == Calendar.WEDNESDAY) {
			diaSemana = MIERCOLES;
		} else if (calendarDayOfWeek == Calendar.THURSDAY) {
			diaSemana = JUEVES;
		} else if (calendarDayOfWeek == Calendar.FRIDAY) {
			diaSemana = VIERNES;
		} else if (calendarDayOfWeek == Calendar.SATURDAY) {
			diaSemana = SABADO;
		} else if (calendarDayOfWeek == Calendar.SUNDAY) {
			diaSemana = DOMINGO;
		} else {
			diaSemana = '0';
			
		}
		return diaSemana;

	}
}

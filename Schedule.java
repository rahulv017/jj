package com.medical.model;

import java.util.Date;

public class Schedule {
Date date,mor_st_time,mor_end_time,eve_st_time,eve_end_time;
long mor_duration = (mor_end_time.getTime()-mor_st_time.getTime())/3600,
	 eve_duration = (eve_end_time.getTime()-eve_st_time.getTime())/3600;

int mor_slot = (int)mor_duration*4,
	eve_slot = (int)eve_duration*4;
Date mor_arr[] = new Date[mor_slot],
eve_arr[] = new Date[eve_slot];

public Schedule(Date mor_st_time,Date mor_end_time,Date eve_st_time,Date eve_end_time) {
	this.mor_st_time=mor_st_time;
	this.mor_end_time=mor_end_time;
	this.eve_st_time=eve_st_time;
	this.eve_end_time=eve_end_time;
	for(int i=0;i<mor_slot;i++)
	{
		mor_arr[i]=new Date(mor_st_time.getTime()+15*60);
	}
	for(int i=0;i<eve_slot;i++)
	{
		eve_arr[i]=new Date(eve_st_time.getTime()+15*60);
	}
}

}

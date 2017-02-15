package com.nacre.online_assesment.form_bean;

import java.util.ArrayList;

import com.nacre.online_assesment.dto.UserDTO;



public class RecordJsonObjectBean {
	
	int iTotalRecords;

    int iTotalDisplayRecords;

    String sEcho;

    String sColumns;
    
    ArrayList<UserDTO> firstRoundlis;

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public ArrayList<UserDTO> getFirstRoundlis() {
		return firstRoundlis;
	}

	public void setFirstRoundlis(ArrayList<UserDTO> firstRoundlis) {
		this.firstRoundlis = firstRoundlis;
	}

}

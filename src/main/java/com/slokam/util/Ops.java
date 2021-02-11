package com.slokam.util;

import java.util.ArrayList;

public class Ops {
  // Test second changes
	
	public static void main(String[] args) {
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		
		Ticket t1 = new Ticket();
		t1.setSno(1);
		t1.setTicketId("tc1234");
		t1.setActualTime("20h");
		t1.setActualCost("20$");
		t1.setEstimatedCost("30$");
		
		Ticket t2 = new Ticket();
		t2.setSno(2);
		t2.setTicketId("tc1235");
		t2.setActualTime("40h");
		t2.setActualCost("40$");
		t2.setEstimatedCost("30$");
		
		Ticket t3 = new Ticket();
		t3.setSno(3);
		t3.setTicketId("tc1235");
		t3.setActualTime("50h");
		t3.setActualCost("150$");
		t3.setEstimatedCost("100$");
		
		ticketList.add(t1);
		ticketList.add(t2);
		ticketList.add(t3);
		
		ExcelManager manage = new ExcelManager();
		manage.writeToReport(ticketList);
	}
}

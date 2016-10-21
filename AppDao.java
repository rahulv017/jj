package com.medical.DAO;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.medical.model.Patient;
import com.medical.model.Prescription;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.medical.model.Appointment;
public class AppDao {
	public List<Appointment> getAppointment(String id,String role) throws UnknownHostException{
		DB db = DataConnect.getdb();
		DBCollection table = db.getCollection("appointment");
		List<Appointment> listOfappointments = new ArrayList<Appointment>();
		if(role.equals("patient")){
		BasicDBObject  query=new BasicDBObject("pat_id",id).append("treatment", "pending");
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			BasicDBObject basicdbobject=(BasicDBObject)cursor.next();
			Appointment app = new Appointment();
			app.setApp_id(basicdbobject.getString("app_id"));
			app.setDate(basicdbobject.getDate("date"));
			app.setDoc_id(basicdbobject.getString("Doc_id"));
			app.setPat_id(basicdbobject.getString("pat_id"));
			app.setSt_time(basicdbobject.getDate("st_time"));
			listOfappointments.add(app);
	}
		return listOfappointments;
	}
		else{
			BasicDBObject  query=new BasicDBObject("doc_id",id).append("treatment", "pending");
			DBCursor cursor=table.find(query);
			while(cursor.hasNext()){
				BasicDBObject basicdbobject=(BasicDBObject)cursor.next();
				Appointment app = new Appointment();
				app.setApp_id(basicdbobject.getString("app_id"));
				app.setDate(basicdbobject.getDate("date"));
				app.setDoc_id(basicdbobject.getString("Doc_id"));
				app.setPat_id(basicdbobject.getString("pat_id"));
				app.setSt_time(basicdbobject.getDate("st_time"));
				listOfappointments.add(app);
		}
			return listOfappointments;
			
		}
	}
	public void saveprescription(Prescription pris) throws UnknownHostException{
		DB db = DataConnect.getdb();
		DBCollection table = db.getCollection("appointment");
		BasicDBObject  searchquery=new BasicDBObject("app_id",pris.getApp_id());
		DBCursor cursor=table.find(searchquery);
		BasicDBObject basicdbobject=(BasicDBObject)cursor.next();
		BasicDBObject query = new BasicDBObject();
		query.put("treatment", basicdbobject.get("treatment"));
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("treatment","done");
		newDocument.put("medicine",pris.getMedicine());
		newDocument.put("next_date",pris.getNext_date());
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
		table.update(query, updateObj);
		//table.update(query, newDocument);
		
	}
	public void saveappointment(Appointment app) throws UnknownHostException{
		DB db = DataConnect.getdb();
		DBCollection table = db.getCollection("appointment");
		String app_id=app.getPat_id()+app.getDoc_id()+app.getDate().toString();
		BasicDBObject basicdbobject=new BasicDBObject("app_id",app_id).
													 append("Date",app.getDate() ).
				                                     append("pat_id", app.getPat_id()).
				                                     append("Doc_id",app.getDoc_id()).
				                                     append("St_time", app.getSt_time()).
				                                     append("treatment","pending");
				                                     
		table.insert(basicdbobject);
	}
	public List<Appointment> getMedicalHistory(String id) throws UnknownHostException{
		DB db = DataConnect.getdb();
		DBCollection table = db.getCollection("appointment");
		List<Appointment> listOfappointments = new ArrayList<Appointment>();
		BasicDBObject  query=new BasicDBObject("pat_id",id).append("treatment", "done");
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			BasicDBObject basicdbobject=(BasicDBObject)cursor.next();
			Appointment app = new Appointment();
			Prescription prescription =new Prescription();
			prescription.setMedicine(basicdbobject.getString("medicine"));
			prescription.setNext_date(basicdbobject.getDate("next_date"));
			app.setPrescription(prescription);
			app.setApp_id(basicdbobject.getString("app_id"));
			app.setDate(basicdbobject.getDate("date"));
			app.setDoc_id(basicdbobject.getString("Doc_id"));
			app.setPat_id(basicdbobject.getString("pat_id"));
			app.setSt_time(basicdbobject.getDate("st_time"));
			listOfappointments.add(app);
		}
		return listOfappointments;
	}
	public List<Appointment> getMutuaAppointment(String pat_id,String doc_id) throws UnknownHostException{
		DB db = DataConnect.getdb();
		DBCollection table = db.getCollection("appointment");
		List<Appointment> listOfappointments = new ArrayList<Appointment>();
		BasicDBObject  query=new BasicDBObject("pat_id",pat_id).append("doc_id", doc_id).append("treatment", "done");
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			BasicDBObject basicdbobject=(BasicDBObject)cursor.next();
			Appointment app = new Appointment();
			Prescription prescription =new Prescription();
			prescription.setMedicine(basicdbobject.getString("medicine"));
			prescription.setNext_date(basicdbobject.getDate("next_date"));
			app.setPrescription(prescription);
			app.setApp_id(basicdbobject.getString("app_id"));
			app.setDate(basicdbobject.getDate("date"));
			app.setDoc_id(basicdbobject.getString("Doc_id"));
			app.setPat_id(basicdbobject.getString("pat_id"));
			app.setSt_time(basicdbobject.getDate("st_time"));
			listOfappointments.add(app);
		}
		return listOfappointments;
	}
}

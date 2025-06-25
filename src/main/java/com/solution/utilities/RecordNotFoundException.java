package com.solution.utilities;

public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

     @Override
     public String getMessage() {
		 return "Record not found in the database.";
	 }

	 @Override
	 public String toString() {
		 return "RecordNotFoundException: " + getMessage();
	 }

}

package com.solution.utilities;

public class RecordAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Record already exists in the database.";
	}

	@Override
	public String toString() {
		return "RecordAlreadyExistsException: " + getMessage();
	}

}

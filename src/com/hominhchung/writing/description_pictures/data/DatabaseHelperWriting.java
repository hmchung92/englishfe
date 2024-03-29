package com.hominhchung.writing.description_pictures.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperWriting extends SQLiteOpenHelper {
	
	// Declare Variables
	private static final String DB_NAME = "WritingTopic";
	public static final String TABLE_NAME = "tablenotes";
	public static final String TITLE = "title";
	public static final String NOTE = "note";

	public DatabaseHelperWriting(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DB_NAME, factory, version);
	}

	@Override	
	public void onCreate(SQLiteDatabase db) {
		// Create a database table
		String createQuery = "CREATE TABLE " + TABLE_NAME
				+ " (_id integer primary key autoincrement," + TITLE + ", "
				+ NOTE + ");";
		db.execSQL(createQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Database will be wipe on version change
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}
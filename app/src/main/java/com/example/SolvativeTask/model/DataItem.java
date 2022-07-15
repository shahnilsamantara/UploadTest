package com.example.SolvativeTask.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "users_table")
public class DataItem{
	@ColumnInfo(name = "last_name")
	@SerializedName("last_name")
	private String lastName;
	@PrimaryKey(autoGenerate = false)
	@NonNull
	private int id;
	@ColumnInfo(name = "avatar")
	private String avatar;
	@ColumnInfo(name = "first_name")
	@SerializedName("first_name")
	private String firstName;
	@ColumnInfo(name = "email")
	private String email;

	public String getLastName(){
		return lastName;
	}

	public int getId(){
		return id;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

}

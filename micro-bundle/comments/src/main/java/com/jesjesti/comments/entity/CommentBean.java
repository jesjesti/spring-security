package com.jesjesti.comments.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class CommentBean {
	@Id
	private String id;

	private String title;
	private String content;
	private Date createdOn;
	@DBRef
	private UserBean createdBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserBean getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserBean createdBy) {
		this.createdBy = createdBy;
	}

}

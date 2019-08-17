package com.zhiyou.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseExtension extends Course implements Serializable{
	private List<Video> videos = new ArrayList<Video>();
	private Subject subject;
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public CourseExtension(List<Video> videos, Subject subject) {
		super();
		this.videos = videos;
		this.subject = subject;
	}
	public CourseExtension() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CourseExtension [videos=" + videos + ", subject=" + subject + "]";
	}
}

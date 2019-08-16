package com.zhiyou.model;

import java.io.Serializable;

public class VideoExtension extends Video implements Serializable{
	private Speaker speaker;
	private CourseExtension course;
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public CourseExtension getCourse() {
		return course;
	}
	public void setCourse(CourseExtension course) {
		this.course = course;
	}
	public VideoExtension(Speaker speaker, CourseExtension course) {
		super();
		this.speaker = speaker;
		this.course = course;
	}
	public VideoExtension() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VideoExtension [speaker=" + speaker + ", course=" + course + "]";
	}
}

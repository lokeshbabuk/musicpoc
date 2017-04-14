/**
 * 
 */
package com.music.application.dao;


import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author M1028349
 *This is the entity class which Hibernate will automatically translate into a table.
 */

public class Song {
	

	private Integer  songid;
	
	private String title;
	private String length;
	private String track_number;
	/*private String genre;
	private String date_added;
	private String date_modified;
	private Integer AlbumId;*/
	
	/*public Integer getAlbumId() {
		return AlbumId;
	}*/

	/*public void setAlbumId(Integer albumId) {
		AlbumId = albumId;
	}*/

	public Integer  getsongid() {
		return songid;
	}
	
	public void setsongid(Integer  songid) {
		this.songid = songid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getTrack_number() {
		return track_number;
	}
	public void setTrack_number(String track_number) {
		this.track_number = track_number;
	}
/*	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDate_added() {
		return date_added;
	}
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	public String getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}*/

	
/*	public Song(Integer  songid, String title, String length, String track_number,
			String genre, String date_added, String date_modified, Integer  AlbumId ) {*/
	public Song(Integer  songid, String title, String length, String track_number) {	
		super();
		this.songid = songid;
		this.title = title;
		this.length = length;
		this.track_number = track_number;
		/*this.genre = genre;
		this.date_added = date_added;
		this.date_modified = date_modified;
		this.AlbumId=AlbumId;*/
	}
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}


}

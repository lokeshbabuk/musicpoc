/**
 * 
 */
package com.music.application.dao;

import java.util.List;

/**
 * @author M1028349
 *
 */

public class Album {
	
	private Integer albumid;

	private String title;
	private String artistName;
	
	private List <Song> song;
	
	public Album(Integer albumid, String title, String artistName) {
		super();
		this.albumid = albumid;
		this.title = title;
		this.artistName = artistName;
		//this.song = song;
	}
    
	public Integer getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

}

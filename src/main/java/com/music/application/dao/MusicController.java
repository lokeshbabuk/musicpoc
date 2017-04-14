/**
 * 
 */
package com.music.application.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author M1028349
 *
 */
@RestController
@RequestMapping(path = "/music")
public class MusicController {

	 
	@Autowired
	private RestTemplate restTemplate;
	
	Album album = new Album();	
	Artist artist = new Artist();	
	Music music = new Music();
	MusicAlbum musicAlbum = new MusicAlbum();
	
	// 1.	Get album details by name. (Return information about Songs in album.)
	
	@GetMapping(path = "/album/{name}/songs")
	public @ResponseBody MusicAlbum getAllSongs(@PathVariable String name) {	
		
		try{
			
			Album albumDetails = restTemplate.getForObject("http://localhost:8083/album/getalbumbyname?title="+name, Album.class);
			
		    Integer albumId = albumDetails.getAlbumid();
		    System.out.println("albumId **** :"+ albumId);
		    
		    String artistName = albumDetails.getArtistName();
		    
		    Song[] songList= restTemplate.getForObject("http://localhost:8082/song/getsongsbyalbumid?albumid="+albumId, Song[].class);	  
		  
		    List<Song> list=Arrays.asList(songList);
		    System.out.println("list   **** :"+ list);
		    album.setAlbumid(albumId);
		    album.setTitle(name);
		    album.setArtistName(artistName);
		    album.setSong(list);
		    
		    List<Album> albumList=Arrays.asList(album);
		    artist.setAlbum(albumList);
		    
		    List<Artist> artishList=Arrays.asList(artist);
		    music.setArtist(artishList);	
		    
		    musicAlbum.setMusic(music);	 

		}catch(Exception exec){
			exec.printStackTrace();			
		}		
		return musicAlbum;
		
	}
	

	@PostMapping(path="/add/{albumId}/song")      
	public String addSong(@RequestBody Songs songs ,@PathVariable Integer albumId){	
		String status = "";
		try{
			System.out.println("albumId ****  :"+albumId);
			status = restTemplate.postForObject("http://localhost:8082/song/add/{albumid}/song", songs, String.class, albumId);
		}catch(Exception exec){
			exec.printStackTrace();
		}
		return status;
	}
	
	@PutMapping(path="/update/{albumId}/song")      
	public String updateSong(@RequestBody Songs songs ,@PathVariable Integer albumId){	
		try{
			System.out.println("albumId ****  :"+albumId);
		    restTemplate.put("http://localhost:8082/song/update/{albumid}/song", songs,albumId);
		}catch(Exception exec){
			exec.printStackTrace();
		}		
		return "updated successfully";
	}	

}

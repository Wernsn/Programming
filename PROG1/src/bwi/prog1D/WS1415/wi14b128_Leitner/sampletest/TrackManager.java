package bwi.prog1D.WS1415.wi14b128_Leitner.sampletest;

import bwi.prog.utils.TextIO;

class Artist {
	String name; /* name of the artist */
}

class Album {
	Artist artist; /* performing artist */
	String title; /* title of the album */
	int year; /* the year the album was released */
}

class Track {
	Album album; /* album of the song */
	String title; /* title of the song */
	int duration; /* duration in seconds */
	int trackNumber; /* which track on album */
}

class TrackManager {
	public static void main(String[] args) {
		Track[] playlist = new Track[99];
		/*some code, not shown*/
		for (int i = 0; i<playlist.length; i++){
			
		}
		Track copy = createCopy(playlist, 42);
		display(playlist[99]);
		/* make a copy of the Track currently at idx 42 */
		/* in the playlist and store it in copy */
		
		int intArray[] = {1,12,0,0,1,-3,0,0};
		
		
		

	}
	public static Album createAlbum(Artist artist, String title, int year){
		Album myAlbum = new Album();
		myAlbum.artist = artist;
		myAlbum.title = title;
		myAlbum.year = year;
		return myAlbum;
	}
	public static Track createCopy(Track[] inputPlaylist, int i){
		Track newTrack = new Track();
		if (inputPlaylist[i] != null){
			newTrack.album.artist.name = inputPlaylist[i].album.artist.name;
			newTrack.album.title = inputPlaylist[i].album.title;
			newTrack.album.year = inputPlaylist[i].album.year;
			newTrack.title = inputPlaylist[i].title;
			newTrack.duration = inputPlaylist[i].duration;
			newTrack.trackNumber = inputPlaylist[i].trackNumber;
		}
		return newTrack;
	}
	public static void display(Artist inputArtist){
		if(inputArtist != null){
			TextIO.put("Name :" +inputArtist.name);
		}
		else{
			TextIO.put("null");
		}
	}
	public static void display(Album album){
		if (album != null){
			display(album.artist);
			TextIO.putln(album.title);
			TextIO.putln(album.year);
		}else{
			TextIO.put("null");
		}
	}
	public static void display(Track track){
		if (track != null){
			display(track.album);
			TextIO.putln(track.duration);
			TextIO.putln(track.title);
			TextIO.putln(track.trackNumber);
		}
		else{
			TextIO.putln("null");
		}
	}
	public static void display(Track[] playlist){
		for (int i = 0; i < playlist.length; i++){
			if (playlist[i] != null){
				display(playlist[i]);
			}else{
			TextIO.putln("null");
			}
		}
	}
	public static int[][] sparse(int[] numbers){

		int count =0;
		int[][] outArray = new int[2][count];
		int indice =0;
		if (numbers != null){
			for(int i = 0; i<numbers.length; i++){
				if (numbers[i]!=0){
					count++;
				}
			}
			for(int i = 0; i<numbers.length; i++){
				if (numbers[i]!=0){
					outArray[0][indice]=i;
					outArray[1][indice]=numbers[i];
				}
			}
		}
		else{
			return null;
		}
		return outArray;
	}
}


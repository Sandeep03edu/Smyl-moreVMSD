package com.example.smylmoreVMSD;

public class SongPlayingVar {
    private String songName;
    private String artistName;
    private int songImageId;
    private int songId;

    public SongPlayingVar(String givenSongName, String givenArtistName, int givenSongImageId){
        songName = givenSongName;
        artistName= givenArtistName;
        songImageId = givenSongImageId;
//        songId = givenSongId;
    }

    public String getSongName(){return songName;}

    public String getArtistName(){return artistName;}

    public int getSongImageId(){return songImageId;}

//    public int getSongId(){return songId;}

}


package com.example.smylmoreVMSD;

public class albumVar {
    private String songName;
    private String artistName;
    private int songImage;
    private int songId;
    private String songVideoId;

    public albumVar(String givenSongName,String givenArtistName, int givenSongImage, int givenSongId, String givenSongVideoId){
        songName = givenSongName;
        artistName = givenArtistName;
        songImage = givenSongImage;
        songId = givenSongId;
        songVideoId = givenSongVideoId;
    }

    public String getSongName(){ return songName;}

    public String getArtistName(){ return artistName;}

    public int getSongImage(){ return  songImage;}

    public int getSongId(){return songId;}

    public String getSongVideoId(){return songVideoId;}

    }

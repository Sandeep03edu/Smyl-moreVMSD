package com.example.smylmoreVMSD;

public class Word {

    private String songArtist;

    /** Miwok translation for the word */
    private String songName;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String givenSongArtist, String givenSongName) {
        songArtist = givenSongArtist;
        songName = givenSongName;
    }

    /**
     * Get the default translation of the word.
     */
    public String getSongArtist() {
        return songArtist;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getSongName() {
        return songName;
    }

}
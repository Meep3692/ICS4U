/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3inventory;

/**
 * Class for storing Mp3 information
 * @author Darian
 */
public class Mp3 {
    
    private String title;
    private String artist;
    private String album;
    private int length;
    private int year;

    /**
     * Create new Mp3
     * @param title Title of song
     * @param artist Artist of song
     * @param album Album song is in
     * @param length Length of song in seconds
     * @param year  Year song was released
     */
    public Mp3(String title, String artist, String album, int length, int year) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.year = year;
    }

    /**
     * Create new Mp3
     * @param title Title of song
     * @param artist Artist of song
     * @param album  Album song is in
     */
    public Mp3(String title, String artist, String album) {
        this(title, artist, album, -1, -1);
    }

    /**
     * Get the title of the song
     * @return Title of song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the song
     * @param title New title of song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the artist of the song
     * @return Artist of song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Set the artist of the song
     * @param artist New artist of song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Get the album the song is in
     * @return Album the song is in
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Set the album the song is in
     * @param album New album to put the song in
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Get the length of the song
     * @return Length of song in seconds or -1 if not avaliable
     */
    public int getLength() {
        return length;
    }

    /**
     * Set the length of the song
     * @param length new length of song in seconds
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Get the year the song was released
     * @return Year song was released or -1 if not avaliable
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the year the song was released
     * @param year New year the song was released
     */
    public void setYear(int year) {
        this.year = year;
    }
    
}

package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String artist, float cost) {
        super(id, title, cost);
        this.artist = artist;
        this.category = category;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public int getLength() {
        int sum = 0;
        for(Track track: tracks) {
            sum += track.getLength();
        }
        super.length = sum;
        return sum;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.err.println("ERR: Track has been existed!");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.err.println("ERR: Track don't existed!");
        }
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        if(this.getLength() > 0) {
            for(Track track: tracks) {
                track.play();
            }
        }
    }

    public int compareTo(Media media) {
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc)media;
            if (tracks.size() == cd.tracks.size())
                return Integer.compare(this.length, cd.getLength());
            else if(tracks.size() < cd.tracks.size())
                return -1;
            else return 1;
        } else
            return super.compareTo(media);
    }
}

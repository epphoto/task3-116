package ratings;

import ratings.datastructures.LinkedListNode;

public class Song {
    private String title;
    private String artist;
    private String id;
    private LinkedListNode<Rating> ratings;

    public Song(String title, String artist, String id) {
        this.title = title;
        this.artist = artist;
        this.id = id;
        this.ratings = null;
    }

    public void addRating(Rating r1) {
        if (this.ratings == null) {
            this.ratings = new LinkedListNode<>(r1, null);
        } else {
            LinkedListNode<Rating> thisNode = this.ratings;
            while (thisNode.getNext() != null) {
                thisNode = thisNode.getNext();
            }
            thisNode.setNext(new LinkedListNode<>(r1, null));
        }
    }

    public double averageRating() {
        LinkedListNode<Rating> newNode=ratings;
        int counter = 0;
        double sum = 0.0;
        if (ratings == null) {
            return 0.0;
        }
        while (newNode != null) {
            int var = newNode.getValue().getRating();
            if (var != -1) {
                sum += var;
                counter++;
            }
            newNode = newNode.getNext();
        }
        return sum / counter;

        }



    public LinkedListNode<Rating> getRatings() {
        if (ratings == null) {
            return null;
        } else {
            return ratings;
        }
    }

    public void setRatings(LinkedListNode<Rating> lln) {
        this.ratings = lln;
    }

    public void removeRatingByReviewer(Reviewer rev1){
        LinkedListNode<Rating> now = ratings;
        String rev12 = rev1.getReviewerID();
        if(ratings==null){
            return;
        }
        if(ratings.getValue().getReviewerID().equals(rev12)){
            ratings=ratings.getNext();
            return;
        }
        while(now.getNext()!=null){
            if(now.getNext().getValue().getReviewerID().equals(rev12)){
                now.setNext(now.getNext().getNext());
                return;
            }
            now=now.getNext();
        }
    }






    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return id;
    }

    public void setSongID(String id) {
        this.id = id;
    }
}

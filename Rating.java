package ratings;

public class Rating {
    private String id;
    private int rating;
    public Rating(String id,int rating){
        this.id=id;
        setRating(rating);
    }
    public String getReviewerID(){
        return id;
    }
    public void setReviewerID(String id){
        this.id=id;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rat1){
        if(ratingCheck(rat1)){
            this.rating=rat1;
        }
        else{
            this.rating=-1;
        }
    }
    public boolean ratingCheck(int rat1){
        return (rat1>=1 && rat1<=5);
    }

}

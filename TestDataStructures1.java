package tests;
import static org.junit.Assert.*;
import org.junit.Test;
import ratings.Reviewer;
import ratings.Song;
import ratings.Rating;
import ratings.datastructures.LinkedListNode;
public class TestDataStructures1 {


    public boolean compareListsOfRatings(LinkedListNode<Rating> l1, LinkedListNode<Rating> l2) {
        while (l1 != null && l2 != null)
        {

            Rating rating1 = l1.getValue();

            Rating rating2 = l2.getValue();


            assertEquals(rating1.getReviewerID(), rating2.getReviewerID()); // true if ids are same


            assertEquals(rating1.getRating(), rating2.getRating()); // true if ratings same


            l1 = l1.getNext();


            l2 = l2.getNext();
        }



        return l1 == null && l2 == null;
    }
    @Test
    public void testwow(){ // test empty
        Song track = new Song("John","LIL WAYNE","THE CARTER 3");
        assertEquals(0.0,track.averageRating(),.001);

    }

    @Test
    public void testwow2() {
        Song song = new Song("JOHN", "LIL WAYNE", "THE CARTER 3 ");
        Rating r1 = new Rating("JUDE", 1);
        Rating r2 = new Rating("JUDE", 5);
        Rating r3 = new Rating("JUDE", 3);
        Rating r4 = new Rating("JUDE", 1);
        Rating r5 = new Rating("BELLINGHAM", 3);
        song.addRating(r1);
        song.addRating(r2);
        song.addRating(r3);
        song.addRating(r4);
        song.addRating(r5);
        song.removeRatingByReviewer(new Reviewer("JUDE"));
        song.removeRatingByReviewer(new Reviewer("BELLINGHAM"));
        assertEquals(3.0, song.averageRating(), .001);
    }



    @Test
    public void testremovelast4(){
        Song s1 = new Song("BANNED FROM TV", "LIL WAYNE", "TC4");

        Song s2 = new Song("PRESIDENT CARTER", "LIL WAYNE", "TC3");

        Rating r1 = new Rating("Ruud Gillit",1);


        Rating r2 = new Rating("Ruud Gillit",-4);


        Rating r3 = new Rating("Ruud Gillit",1);


        Rating r4 = new Rating("Ruud Gillit",3);

        Rating r5 = new Rating("Wayne Rooney",40);

        Rating r6 = new Rating("Dennis Bergkamp",5);

        Rating r7 = new Rating("Dennis Bergkamp",2);

        Rating r8 = new Rating("Kaka",1);

        s1.addRating(r1);


        s1.addRating(r2);


        s1.addRating(r3);


        s1.addRating(r4);


        s1.addRating(r5);


        s1.addRating(r6);


        s1.addRating(r7);


        s1.addRating(r8);


        s1.removeRatingByReviewer(new Reviewer("Kaka"));
        LinkedListNode<Rating> rat1 = s1.getRatings();
        s2.setRatings(rat1);


        assertTrue(compareListsOfRatings(s1.getRatings(),s2.getRatings()));

    }

    @Test
    public void testwow5(){
        Song s1 = new Song("Empaquete", "Dontay","Elon");
        Song s2 = new Song("4K", "El Alfa","hay");
        Rating r1= new Rating("Drogba",5);
        Rating r2= new Rating("Drogba",1);
        Rating r3= new Rating("Drogba",4);
        Rating r4= new Rating("Drogba",5);
        Rating r5= new Rating("Drogba",1);
        Rating r6= new Rating("Drogba",4);
        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s2.addRating(r4);
        s2.addRating(r5);
        s2.addRating(r6);
        assertTrue(compareListsOfRatings(s1.getRatings(),s2.getRatings()));


    }
    @Test
    public void testSetRatings2(){
        Song song = new Song("HOODRAT","Kanye West & Ty Dolla Sign","Gabriel");
        Rating r1 = new Rating("Paulina",5);
        Rating r2 = new Rating("Jessie",2);
        LinkedListNode<Rating>testNode=new LinkedListNode<>(r1,null);
        LinkedListNode<Rating>nodes=new LinkedListNode<Rating>(r2,testNode);
        song.setRatings(testNode);
        assertEquals(true, song.getRatings().equals(testNode));
    }
    @Test
    public void testSetRatings3(){
        Song song = new Song("HOODRAT","Kanye West & Ty Dolla Sign","Gabriel");
        Rating r1 = new Rating("Paulina",5);
        Rating r2 = new Rating("Jason",2);
        Rating r3 = new Rating("Jessie",3);
        Rating r4 = new Rating("Tess",1);
        Rating r5 = new Rating("Lauren",6);
        Rating r6 = new Rating("Hugo",9);
        Rating r7 = new Rating("Rodrygo",1);
        Rating r8 = new Rating("Vini Jr.",4);

        LinkedListNode<Rating>testNode=new LinkedListNode<>(r1,null);
        LinkedListNode<Rating>nodes=new LinkedListNode<Rating>(r2,testNode);
        LinkedListNode<Rating>nodes2=new LinkedListNode<Rating>(r3,nodes);
        LinkedListNode<Rating>nodes3=new LinkedListNode<Rating>(r4,nodes2);
        LinkedListNode<Rating>nodes4=new LinkedListNode<Rating>(r5,nodes3);
        LinkedListNode<Rating>nodes5=new LinkedListNode<Rating>(r6,nodes4);
        LinkedListNode<Rating>nodes6=new LinkedListNode<Rating>(r7,nodes5);
        LinkedListNode<Rating>nodes7=new LinkedListNode<Rating>(r8,nodes6);
        // Rating is invalid
        song.setRatings(nodes7);
        assertEquals(false, song.getRatings().equals(nodes5));
    }
    @Test
    public void testSetRatings4(){
        Song song = new Song("<3MYGNG","Destroy Lonely","Sasha");
        Rating r1 = new Rating("Frances",1);
        Rating r2 = new Rating("Ian",3);
        Rating r3 = new Rating("Vladimir",4);
        Rating r4 = new Rating("Aaron",2);
        Rating r5 = new Rating("Quan",5);

        LinkedListNode<Rating>nodey=new LinkedListNode<>(r1,null);
        song.setRatings(nodey);
        assertEquals(true,song.getRatings().equals(nodey));
    }
    @Test
    public void testwow6() {
        Song song = new Song("<3MYGNG", "DESTROY LONELY", "NOSTYLIST");

        song.addRating(new Rating("jude", 2));


        song.addRating(new Rating("jude", 2));

        song.addRating(new Rating("jude", 2));

        song.addRating(new Rating("BEL", 4));

        song.removeRatingByReviewer(new Reviewer("BEL"));

        song.removeRatingByReviewer(new Reviewer("jude"));

        assertEquals(2.0, song.averageRating(), .001);
    }
    @Test
    public void testSetRatings5(){
        Song song = new Song("<3MYGNG","Destroy Lonely","Sasha");
        Rating r1 = new Rating("Frances",1);
        Rating r2 = new Rating("Ian",3);
        Rating r3 = new Rating("Vladimir",4);
        Rating r4 = new Rating("Aaron",2);
        Rating r5 = new Rating("Quan",5);

        LinkedListNode<Rating>nodey=new LinkedListNode<>(r1,null);

        song.setRatings(nodey);

        assertEquals(true,song.getRatings().equals(nodey));
    }
    @Test
    public void testAverageRatings(){
        Song song = new Song("NOSTYLIST","Destroy Lonely","Lawrence");
        Rating r1 = new Rating("Frances",1);
        Rating r2 = new Rating("Ian",1);
        Rating r3 = new Rating("Vladimir",1);
        Rating r4 = new Rating("Aaron",1);
        Rating r5 = new Rating("Quan",1);
        LinkedListNode<Rating>node= new LinkedListNode<>(r1,null);
        LinkedListNode<Rating>node2= new LinkedListNode<>(r2,node);
        LinkedListNode<Rating>node3= new LinkedListNode<>(r3,node2);
        LinkedListNode<Rating>node4= new LinkedListNode<>(r4,node3);
        LinkedListNode<Rating>node5= new LinkedListNode<>(r5,node4);

        song.setRatings(node3);
        assertEquals(1.0,song.averageRating(),.0001);
    }
    @Test
    public void testAverageRatings2(){
        Song song = new Song("NOSTYLIST","Destroy Lonely","Lawrence");
        Rating r1 = new Rating("Frances",3);
        Rating r2 = new Rating("Ian",1);
        LinkedListNode<Rating>node= new LinkedListNode<>(r1,null);
        LinkedListNode<Rating>node2= new LinkedListNode<>(r2,node);
        song.setRatings(node2);
        assertEquals(2.0,song.averageRating(),.0001);
    }
    @Test
    public void testAverageRatings3(){
        Song song = new Song("NOSTYLIST","Destroy Lonely","Lawrence");
        Rating r1 = new Rating("Frances",6);
        Rating r2 = new Rating("Ian",1);
        Rating r3 = new Rating("Mendy",9);
        Rating r4 = new Rating("Benzema",3);
        Rating r5 = new Rating("Ronaldinho",5);
        LinkedListNode<Rating>node= new LinkedListNode<>(r1,null);
        LinkedListNode<Rating>node2= new LinkedListNode<>(r2,node);
        LinkedListNode<Rating>node3= new LinkedListNode<>(r3,node2);
        LinkedListNode<Rating>node4= new LinkedListNode<>(r4,node3);
        LinkedListNode<Rating>node5= new LinkedListNode<>(r5,node4);
        song.setRatings(node5);
        assertEquals(3.0,song.averageRating(),.0001);
    }

    @Test
    public void test1324(){
        Song s1 = new Song("John", "Lil Wayne", "The Carter 3");


        Rating r1= new Rating("Rodrygo",1);
        Rating r2= new Rating("Rodrygo",5);
        Rating r3= new Rating("Rodrygo",3);
        Rating r4= new Rating("Rodrygo",1);
        Rating r5= new Rating("Memphis Depay",3);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);

        s1.removeRatingByReviewer(new Reviewer("Rodrygo"));
        s1.removeRatingByReviewer(new Reviewer("Memphis Depay"));

        assertEquals(3.0,s1.averageRating(),.001);

    }


    @Test
    public void testRemoveRatingByReviewer15(){
        Song songtesty = new Song("BERGDORF","Destroy Lonely","Jacob");
        Song songtest = new Song("<3MYGNG", "Destroy Lonely", "NOstylist30");

        Rating r1 = new Rating("Jude Bellingham",2);
        Rating r2 = new Rating("d",3);
        Rating r3 = new Rating("Harry Kane",2);
        Rating r4 = new Rating("Jude Bellingham",4);
        Rating r5 = new Rating("Trippier",5);
        Rating r6 = new Rating("Jude Bellingham",5);
        Rating r7 = new Rating("Milner",5);
        Rating r8 = new Rating("Raheem Sterling",5);
        Rating r9 = new Rating("Wayne Rooney",5);

        songtesty.addRating(r1);
        songtesty.addRating(r2);
        songtesty.addRating(r3);
        songtesty.addRating(r4);
        songtesty.addRating(r5);
        songtesty.addRating(r6);
        songtesty.addRating(r7);
        songtesty.addRating(r8);
        songtesty.addRating(r9);
        songtesty.removeRatingByReviewer(new Reviewer("Jude Bellingham"));
        LinkedListNode<Rating> ratings = songtesty.getRatings();
        songtest.setRatings(ratings);
        assertTrue(compareListsOfRatings(songtesty.getRatings(), songtest.getRatings()));
    }






    @Test
    public void testCompareListsOfRatings3(){ //Different Sizes
        Song song = new Song("Wow Freestyle","Kendrick Lamar","Cole");
        Song song2 = new Song("My Jeep","Joey Badass","Wyclef Jean");
        Rating r1 = new Rating("Silva",3);
        Rating r2 = new Rating("Silva",3);
        Rating r3 = new Rating("Silva",3);

        Rating r5 = new Rating("Silva",3);
        Rating r6 = new Rating("Silva",3);
        Rating r7 = new Rating("Silva",3);
        Rating r8 = new Rating("Silva",3);

        LinkedListNode<Rating> node1list1= new LinkedListNode<>(r1,null);
        LinkedListNode<Rating> node2list1= new LinkedListNode<>(r2,node1list1);
        LinkedListNode<Rating> node3list1= new LinkedListNode<>(r3,node2list1);


        LinkedListNode<Rating> node1list2= new LinkedListNode<>(r5,null);
        LinkedListNode<Rating> node2list2= new LinkedListNode<>(r6,node1list2);
        LinkedListNode<Rating> node3list2= new LinkedListNode<>(r7,node2list2);
        LinkedListNode<Rating> node4list2= new LinkedListNode<>(r8,node3list2);

        song.setRatings(node3list1);
        song2.setRatings(node4list2);


        assertEquals(false,compareListsOfRatings(node3list1,node4list2));
    }
    @Test
    public void testCompareListsOfRatings10(){ //Sizes
        Song song = new Song("Wow Freestyle","Kendrick Lamar","Cole");
        Song song2 = new Song("My Jeep","Joey Badass","Wyclef Jean");
        Rating r1 = new Rating("Silva",3);
        Rating r2 = new Rating("Silva",3);
        Rating r3 = new Rating("Silva",3);


        Rating r5 = new Rating("Silva",3);
        Rating r6 = new Rating("Silva",3);
        Rating r7 = new Rating("Silva",3);
        Rating r8 = new Rating("Silva",3);

        LinkedListNode<Rating> node1list1= new LinkedListNode<>(r1,null);
        LinkedListNode<Rating> node2list1= new LinkedListNode<>(r2,node1list1);
        LinkedListNode<Rating> node3list1= new LinkedListNode<>(r3,node2list1);

        LinkedListNode<Rating> node1list2= new LinkedListNode<>(r5,null);
        LinkedListNode<Rating> node2list2= new LinkedListNode<>(r6,node1list2);
        LinkedListNode<Rating> node3list2= new LinkedListNode<>(r7,node2list2);
        LinkedListNode<Rating> node4list2= new LinkedListNode<>(r8,node3list2);

        song.setRatings(node3list1);
        song2.setRatings(node4list2);


        assertEquals(false,compareListsOfRatings(node3list1,node4list2));
    }



    @Test
    public void testCompareListsOfRating11(){
        LinkedListNode<Rating>list1 =null;
        LinkedListNode<Rating>list2 =null;
        assertEquals(true,compareListsOfRatings(list1,list2));
    }

    @Test
    public void testAvgNoRatings() {
        Song song = new Song("Wayne", "Ye", "Ali");
        assertEquals(0.0, song.averageRating(), 0.001);
        }

}









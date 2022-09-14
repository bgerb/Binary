import org.junit.jupiter.api.Test;
import java.lang.Math;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class binaryTest {

    @Test
    void getRoot() {
        binary fortest = new binary();
        node thing = new node(5);
        fortest.setRoot(thing);
        assertEquals(thing, fortest.getRoot());
        assertEquals(5, fortest.getRoot().getData());




    }

    @Test
    void search() {
        binary fortest1 = new binary();
        node thing = new node(29);
        fortest1.setRoot(thing);
        for(int i =0; i<30; ++i) {
            node rep = new node(i*2);
            fortest1.insert(rep);
        }
        assertEquals(14,fortest1.search(fortest1.getRoot(), 14).getData());

    }

    @Test
    void insert() {
        binary fortest1 = new binary();
        node thing = new node(29);
        fortest1.setRoot(thing);
        for(int i =0; i<30; ++i) {
            node rep = new node((int) (Math.random()*50*i));
            fortest1.insert(rep);
        }
        assertEquals(0, fortest1.getRoot().minimum().getData());


    }



    @Test
    void childless() {
        binary fortest1 = new binary();
        node thing = new node(29);
        fortest1.setRoot(thing);
        assertEquals(true, fortest1.childless(fortest1.getRoot()));
        node addchild = new node(5);
        fortest1.insert(addchild);
        assertEquals(false, fortest1.childless(fortest1.getRoot()));


    }

    @Test
    void onechild() {
        binary fortest1 = new binary();
        node thing = new node(29);
        fortest1.setRoot(thing);
        assertEquals(false, fortest1.onechild(fortest1.getRoot()));
        node addchild = new node(5);
        fortest1.insert(addchild);
        assertEquals(true, fortest1.onechild(fortest1.getRoot()));
        node addchild1 = new node(31);
        fortest1.insert(addchild1);
        assertEquals(false, fortest1.onechild(fortest1.getRoot()));
    }

    @Test
    void scrubParent() {
        binary fortest1 = new binary();
        node thing = new node(29);
        fortest1.setRoot(thing);
        node addchild = new node(30);
        node addfinchild = new node( 31);
        fortest1.insert(addchild);
        fortest1.insert(addfinchild);
        fortest1.scrubParent(addchild);
        assertEquals(null,fortest1.search(fortest1.getRoot(), 31));
        fortest1.insert(addfinchild);
        assertEquals(31,fortest1.search(fortest1.getRoot(), 31).getData());


    }


    @Test
    void deletespliceoutrotateout() {
        binary fortest1 = new binary();
        node thing = new node(30);
        fortest1.setRoot(thing);
        int count = 0;
        for(int i =0; i<300; ++i) {
            int toadd = (int) (Math.random()*500*i);
            if(null == fortest1.search(fortest1.getRoot(),toadd)) {

                node rep = new node(toadd);
                fortest1.insert(rep);
                ++count;
                if (count > 50) {
                    fortest1.delete((rep));
                    assertEquals(null, fortest1.search(fortest1.getRoot(), rep.getData()));
                }
            }


        }

        fortest1.delete((fortest1.getRoot().minimum()));
        assertNotEquals(0, fortest1.getRoot().minimum());

    }
}
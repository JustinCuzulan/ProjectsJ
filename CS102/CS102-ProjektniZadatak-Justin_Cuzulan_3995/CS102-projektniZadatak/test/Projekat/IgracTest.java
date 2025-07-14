/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author justincuzulan
 */
public class IgracTest {
    
    public IgracTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test metoda equals, klase Igrac.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Igrac instance = new Igrac("Justin","4444");
        Igrac instance2=new Igrac("Marko","8888");
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        instance2=new Igrac("Justin","4444");
        expResult = true;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        instance2=new Igrac("Marko","4444");
        expResult = false;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        instance2=new Igrac("Justin","8888");
        expResult = false;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    /**
     * Test od povecajBrojBodova metoda, iz klase Igrac.
     */
    @Test
    public void testPovecajBrojBodova() {
        System.out.println("povecajBrojBodova");
        int x = 5;
        Igrac instance = new Igrac();
        instance.setBrojBodova(10);
        instance.povecajBrojBodova(x);
        assertEquals(instance.getBrojBodova(),15);
//        fail("The test case is a prototype.");
    }

    /**
     * Test compareTo metoda, iz klase Igrac.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Igrac instance = new Igrac();
        instance.setBrojBodova(10);
        Igrac instance2 = new Igrac();
        instance2.setBrojBodova(5);
        int expResult = -1;
        int result = instance.compareTo(instance2);
        assertEquals(expResult, result);
       
       expResult=1;
       result=instance2.compareTo(instance);
        assertEquals(expResult, result);
        
        instance2.setBrojBodova(10);
        expResult=0;
        result=instance2.compareTo(instance);
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }
    
}

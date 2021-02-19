package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateRelationshipsTest {

    @Test
     void test1() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("5>-1<0=0<-5>5=5"));
    }

    @Test
     void test2() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("-15<-10<=0=0<5"));
    }

    @Test
     void test3() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("0=807<1000<=1000>9990<-3605<=20"));
    }

    @Test
     void test4() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("3<=3<11>-109"));
    }

    @Test
     void test5() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("44>-33>=1>-13"));
    }

    @Test
     void test6() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("10>2=22>9>3"));
    }

    @Test
     void test7() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("44>0<13>=-2<-1=-1"));
    }

    @Test
     void test8() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("3>=-1"));
    }

    @Test
     void test9() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("9<=9<-1"));
    }

    @Test
     void test10() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("0<9<=9>-1"));
    }

    @Test
     void test11() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("44>=0<13>-2<-1=1"));
    }

    @Test
     void test12() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("-39<=5=5<=9>-1"));
    }

    @Test
     void test13() {
        assertEquals(true, ValidateRelationships.validateTheRelationships("-39<=5=5<=9>-1"));
    }

    @Test
     void test14() {
        assertEquals(false, ValidateRelationships.validateTheRelationships("3<19>-19>5>=-19"));
    }

}

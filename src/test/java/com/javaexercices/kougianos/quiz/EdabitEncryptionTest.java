package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class EdabitEncryptionTest {
    @Test
    void test1() {
        assertEquals("hae and via ecy", EdabitEncryption.encryption("haveaniceday"));
    }

    @Test
    void test2() {
        assertEquals("fto ehg ee dd", EdabitEncryption.encryption("feedthedog"));
    }

    @Test
    void test3() {
        assertEquals("clu hlt io", EdabitEncryption.encryption("chillout"));
    }

    @Test
    void test4() {
        assertEquals("Anoea FdnSr oHeot oiyoe lsAnd aMrP.", EdabitEncryption.encryption("A Fool and His Money Are Soon Parted."));
    }

    @Test
    void test5() {
        assertEquals("Onvtlphb. noehreae etraentc swttaech hohhddaa oriayann urnvhnng lygeadoe dosapttd", EdabitEncryption.encryption("One should not worry over things that have already happened and that cannot be changed."));
    }

    @Test
    void test6() {
        assertEquals("Brpgatroea aeutpo,:dr cOlhessbrd knaartiaa. tertsamcw oismoriki Ssaentltn qayahoaog upinavrtb aonssetho", EdabitEncryption.encryption("Back to Square One is a popular saying that means a person has to start over, similar to: back to the drawing board."));
    }
}

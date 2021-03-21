package com.javaexercices.kougianos.quiz.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookChapterTest {

    private Chapter[][] chapterVector = new Chapter[][] {
            {new Chapter("Chapter 1", 1), new Chapter("Chapter 2", 15), new Chapter("Chapter 3", 37)},
            {new Chapter("New Beginnings", 1), new Chapter("Strange Developments", 62), new Chapter("The End?", 194), new Chapter("The True Ending", 460)},
            {new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5)},
            {new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5), new Chapter("Chapter 1c", 50), new Chapter("Chapter 1d", 100)},
            {new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5), new Chapter("Chapter 1c", 50), new Chapter("Chapter 1d", 100), new Chapter("Chapter 1e", 200)},
            {new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5), new Chapter("Chapter 1c", 50), new Chapter("Chapter 1d", 100), new Chapter("Chapter 1e", 200)},
            {new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5), new Chapter("Chapter 1c", 50), new Chapter("Chapter 1d", 100), new Chapter("Chapter 1e", 200), new Chapter("Chapter 1f", 400)}
    };
    private int[] pageVector = new int[] {10, 200, 3, 75, 150, 74, 300};
    private String[] resVector = new String[] {
            "Chapter 2", "The End?", "Chapter 1b", "Chapter 1d", "Chapter 1e", "Chapter 1c", "Chapter 1f"
    };

    @Test
    void test01() {
        assertEquals(BookChapter.nearestChapter(chapterVector[0], pageVector[0]), resVector[0]);
    }

    @Test
    void test02() {
        assertEquals(BookChapter.nearestChapter(chapterVector[1], pageVector[1]), resVector[1]);
    }

    @Test
    void test03() {
        assertEquals(BookChapter.nearestChapter(chapterVector[2], pageVector[2]), resVector[2]);
    }

    @Test
    void test04() {
        assertEquals(BookChapter.nearestChapter(chapterVector[3], pageVector[3]), resVector[3]);
    }

    @Test
    void test05() {
        assertEquals(BookChapter.nearestChapter(chapterVector[4], pageVector[4]), resVector[4]);
    }

    @Test
    void test06() {
        assertEquals(BookChapter.nearestChapter(chapterVector[5], pageVector[5]), resVector[5]);
    }

    @Test
    void test07() {
        assertEquals(BookChapter.nearestChapter(chapterVector[6], pageVector[6]), resVector[6]);
    }

}

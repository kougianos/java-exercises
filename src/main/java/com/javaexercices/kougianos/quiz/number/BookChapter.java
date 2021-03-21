package com.javaexercices.kougianos.quiz.number;

/**
 * Create a function that returns which chapter is nearest to the page you're on.
 * If two chapters are equidistant, return the chapter with the higher page number.
 * <p>
 * nearestChapter(new Chapter[] {
 * new Chapter("Chapter 1", 1),
 * new Chapter("Chapter 2", 15),
 * new Chapter("Chapter 3", 37)
 * }, 10) ➞ "Chapter 2"
 * <p>
 * nearestChapter(new Chapter[] {
 * new Chapter("New Beginnings", 1),
 * new Chapter("Strange Developments", 62),
 * new Chapter("The End?", 194),
 * new Chapter("The True Ending", 460)
 * }, 200) ➞ "The End?"
 * <p>
 * nearestChapter(new Chapter[] {
 * new Chapter("Chapter 1a", 1),
 * new Chapter("Chapter 1b", 5)
 * }, 3) ➞ "Chapter 1b"
 */
public class BookChapter {

    private BookChapter() {

    }

    public static String nearestChapter(Chapter[] chapter, int page) {

        int nearest = Integer.MAX_VALUE;
        int key = 0;

        for (int i = 0; i < chapter.length; i++) {

            int diff = Math.abs(chapter[i].getPage() - page);
            if (diff <= nearest) {
                nearest = diff;
                key = i;
            } else {
                break;
            }

        }

        return chapter[key].getName();

    }
}

class Chapter {
    private String name;
    private int page;

    public Chapter(String name, int page) {
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
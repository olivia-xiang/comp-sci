public class Book implements Comparable<Book> {

    private int pages;
    private int chapters;
    private double wordsPerPage;

    public Book (int pages, int chapters, double wordsPerPage) {
        this.pages = pages;
        this.chapters = chapters;
        this.wordsPerPage = wordsPerPage;
    }

    public int getPages() {
        return pages;
    }

    public int getChapters() {
        return chapters;
    }

    public double getWordsPerPage() {
        return wordsPerPage;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public void setWordsPerPage(double wordsPerPage) {
        this.wordsPerPage = wordsPerPage;
    } 

    @Override
    public int compareTo(Book other) {
        return this.pages - other.pages;
    }

}
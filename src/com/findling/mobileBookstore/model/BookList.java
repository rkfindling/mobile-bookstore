package com.findling.mobileBookstore.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ralph on 2015-10-27.
 */


public class BookList {
    protected List<Book> mBookList;

    public BookList() {     //Set<Book> bookList

        mBookList = new ArrayList<Book>();

        //BookList mBookList = new BookList();


        //mBookList.importFrom("OMFBookList.csv");
    }

    @Override
    public String toString() {
        String bookList = "";

        for (Book book : mBookList) {
            bookList = bookList + String.format("%d|%s|%s|%c|%f|%n",
                    book.getBookID(),
                    book.getISBN(),
                    book.getTitle(),
                    //book.getFormats(),  //TODO: RPF  This is not correct, I need to make sure a string is returned with the list
                    //book.getActualCost(),
                    book.getMemberPrice(),
                    book.getRetailPrice()
            );
        }

        return bookList;
    }

    public void exportTo(String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                PrintWriter writer = new PrintWriter(fos);
        ) {
            for (Book book : mBookList) {
                writer.printf("%d|%s|%s|%c|%f|%n",
                        book.getBookID(),
                        book.getISBN(),
                        book.getTitle(),
                        //book.getFormats(),  //TODO: RPF  This is not correct, I need to make sure a string is returned with the list
                        //book.getActualCost(),
                        book.getMemberPrice(),
                        book.getRetailPrice()
                );

            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void importFrom(String fileName) {


        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                //TODO: RPF make sure file is parsed properly
                //ID, Title, ISBN, Retail Cost, Member Cost

                //DEBUG
                System.out.printf("Getting next line: %s %n",line);

                String[] args = line.split("\\|");
                //TODO: RPF check to make sure there are no errors in this file!!!
                if (args.length == 5) {
                    int bookID = Integer.parseInt(args[0]);
                    String title = args[1];
                    String ISBN = args[2];
                    float retailCost = Float.parseFloat(args[3]);
                    float memberCost = Float.parseFloat(args[4]);

                    addBook(new Book(bookID, title, ISBN, retailCost, memberCost));
                }

            }
        } catch (IOException ioe) {
            System.out.printf("Problems loading %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    private void addBook(Book book) {
        mBookList.add(book);

    }


}

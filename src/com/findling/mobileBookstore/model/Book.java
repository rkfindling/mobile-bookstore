package com.findling.mobileBookstore.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Set;

/**
 * Created by Ralph on 2015-10-27.
 */
public class Book {
    //protected int mBookID;
    //protected String mISBN;

    private  int mBookID;
    private  String mISBN;

    protected String mTitle;
    //protected float mActualCost;
    protected float mMemberPrice;
    protected float mRetailPrice;
   // protected Set<String> mFormats; // Like paperback, hardcover, Kindle, ePub, MP3, etc.

    public Book(int bookID, String ISBN, String title, /*Set<String> formats, float actualCost, */float memberPrice, float retailPrice ) {
        mBookID = bookID;
        mISBN = ISBN;
        mTitle = title;
        //mFormats = formats;
        //mActualCost = actualCost;   //may not be needed
        mMemberPrice = memberPrice;
        mRetailPrice = retailPrice;

    }

//   public Set<String> getFormats() {
//        return mFormats;
//    }
//
//    public void setFormats(Set<String> formats) {
//        mFormats = formats;
//    }


   /* public float getActualCost() {
        return mActualCost;
    }

    public void setActualCost(float actualCost) {

        mActualCost = actualCost;
    }*/

    public int getBookID() {

        return mBookID;
    }

    public void setBookID(int bookID) {

        mBookID = bookID;
    }

   // public IntegerProperty bookIDProperty() {
   //     return mBookID;
   // }

/*
    public Set<String> getFormats() {
        return
                mFormats;
    }

    public void setFormats(Set<String> formats) {

        mFormats = formats;
    }
*/

    public String getISBN() {

        return mISBN;
    }

    public void setISBN(String ISBN) {

        mISBN = ISBN;
    }


/*
    public StringProperty bookISBNProperty() {
        return mISBN;
    }
*/


    public float getMemberPrice() {

        return mMemberPrice;
    }

    public void setMemberPrice(float memberPrice) {

        mMemberPrice = memberPrice;
    }

    public float getRetailPrice() {
        return mRetailPrice;
    }

    public void setRetailPrice(float retailPrice) {

        mRetailPrice = retailPrice;
    }

    public String getTitle() {

        return mTitle;
    }

    public void setTitle(String title) {

        mTitle = title;
    }

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Book> BookData = FXCollections.observableArrayList();


    @Override
    public String toString() {
        return "Book{" +
                "mBookID=" + mBookID +
                ", mISBN='" + mISBN + '\'' +
                ", mTitle='" + mTitle + '\'' +
                //", mFormats=" + mFormats +
                //", mActualCost=" + mActualCost +
                ", mMemberPrice=" + mMemberPrice +
                ", mRetailPrice=" + mRetailPrice +

                '}';
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Book> getBookData() {
        return BookData;
    }
}

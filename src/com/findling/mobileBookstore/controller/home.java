package com.findling.mobileBookstore.controller;

import com.findling.mobileBookstore.model.Book;
import com.findling.mobileBookstore.model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;



public class home {

    private Book mBook;
    private BookList mBookList;

    @FXML
    private ListView NewBookListWindowFX;

    @FXML
    private TableColumn col_IDFX;




    public home() {

        mBookList = new BookList();
        mBookList.importFrom("BookList.csv");
        System.out.println("Finished loading...");
        //BookListWindow.getStyleClass().add("playing");
        //BookListWindow = mBookList.toString();
        //BookListTextArea.setText("Hello");
    }

    public void handleRefreshBookListWindow() {
        //BookListWindow.getStyleClass().add(mBookList.toString());
        //BookListWindow.getStyleClass().add("Test");
        //BookListWindow.getStyleClass("Test");

    //ListView<String> BookListWindow = new ListView<String>();

        String[] book1 = {"Book 1 Title", "Book 1 Author"};
        String[] book2 = {"Book 2 Title", "Book 2 Author"};

        //ObservableList<String[]> items = FXCollections.observableArrayList(book1,book2);
        //NewBookListWindowFX.setItems(items);
        //BookListTextAreaFX.setText("Hello");
        //col_IDFX.setCellValueFactory();

    }



}

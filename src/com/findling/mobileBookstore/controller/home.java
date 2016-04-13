package com.findling.mobileBookstore.controller;

import com.findling.mobileBookstore.model.Book;
import com.findling.mobileBookstore.model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;



public class BookOverviewController {

    private Book mBook;
    private BookList mBookList;

    @FXML
    private ListView NewBookListWindowFX;

    @FXML
    private TableView bookTable;

    @FXML
    private TableColumn col_IDFX;

    @FXML
    private TableColumn<Book, String> id_Column;

    @FXML
    private TableColumn<Book, String> iSBN_Column;



    public BookOverviewController() {

        mBookList = new BookList();
        mBookList.importFrom("BookList.csv");
        System.out.println("Finished loading...");
        //BookListWindow.getStyleClass().add("playing");
        //BookListWindow = mBookList.toString();
        //BookListTextArea.setText("Hello");

        /**
         * Initializes the controller class. This method is automatically called
         * after the fxml file has been loaded.
         */
        @FXML
        private void initialize() {
            // Initialize the person table with the two columns.
            id_Column.setCellValueFactory(cellData -> cellData.getValue().getBookID());
            iSBN_Column.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        }


    }

    public void handleRefreshBookListWindow() {
        //BookListWindow.getStyleClass().add(mBookList.toString());
        //BookListWindow.getStyleClass().add("Test");
        //BookListWindow.getStyleClass("Test");

    //ListView<String> BookListWindow = new ListView<String>();

/*  from: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.html
        ObservableList<Person> data = ...
        TableView<Person> tableView = new TableView<Person>(data);

        TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
        firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
                // p.getValue() returns the Person instance for a particular TableView row
                return p.getValue().firstNameProperty();
            }
        });

        tableView.getColumns().add(firstNameCol);}

    */

        String[] book1 = {"Book 1 Title", "Book 1 Author"};
        String[] book2 = {"Book 2 Title", "Book 2 Author"};

        ObservableList<String[]> items = FXCollections.observableArrayList(book1,book2);
        TableView<String[]> tableView = new TableView<Person>(data);

        NewBookListWindowFX.setItems(items);
        BookListTextAreaFX.setText("Hello");
        col_IDFX.setCellValueFactory();

    }



}

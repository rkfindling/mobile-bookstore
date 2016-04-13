package com.findling.mobileBookstore.model;

import com.findling.mobileBookstore.model.Book;
import javafx.application.Application;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application {

    private TableView<Book> table = new TableView<Book>();
    private final ObservableList<Book> data =
            FXCollections.observableArrayList(
                    new Book(1, "1234567", "First Book Title", 10, 12),
                    new Book(2, "1234568", "First Book Title", 10, 12),
                    new Book(3, "1234569", "First Book Title", 10, 12),
                    new Book(4, "1234570", "First Book Title", 10, 12),
                    new Book(5, "1234571", "First Book Title", 10, 12));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Book List");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("ID");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("id"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(CellEditEvent<Book, String> t) {
                        ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBookID(Integer.getInteger(t.getNewValue()));
                    }
                }
        );


        TableColumn lastNameCol = new TableColumn("ISBN");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("isbn"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(CellEditEvent<Book, String> t) {
                        ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setISBN(t.getNewValue());
                    }
                }
        );

        TableColumn emailCol = new TableColumn("Title");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("title"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(CellEditEvent<Book, String> t) {
                        ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTitle(t.getNewValue());
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final TextField AddBookID = new TextField();
        AddBookID.setPromptText("ID");
        AddBookID.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField AddISBN = new TextField();
        AddISBN.setMaxWidth(lastNameCol.getPrefWidth());
        AddISBN.setPromptText("ISBN");
        final TextField AddTitle = new TextField();
        AddTitle.setMaxWidth(emailCol.getPrefWidth());
        AddTitle.setPromptText("Title");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Book1(
                         Integer.parseInt(AddBookID.getText()),
                        AddISBN.getText(),
                        AddTitle.getText(),  1.0f, 1.0f);
                AddBookID.clear();
                AddISBN.clear();
                AddTitle.clear();
            }
        });

        hb.getChildren().addAll(AddBookID, AddISBN, AddTitle, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }


    public class Book1 {
        //protected int mBookID;
        //protected String mISBN;

        SimpleIntegerProperty mBookID;
        SimpleStringProperty mISBN;

        SimpleStringProperty mTitle;
        //protected float mActualCost;
        SimpleFloatProperty mMemberPrice;
        SimpleFloatProperty mRetailPrice;
        // protected Set<String> mFormats; // Like paperback, hardcover, Kindle, ePub, MP3, etc.

        public Book1(SimpleIntegerProperty bookID, SimpleStringProperty ISBN, SimpleStringProperty title,
                     /*Set<String> formats, float actualCost, */
                     SimpleFloatProperty memberPrice,
                     SimpleFloatProperty retailPrice) {
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

        public SimpleIntegerProperty getBookID() {

            return mBookID;
        }

        public void setBookID(SimpleIntegerProperty bookID) {

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

        public SimpleStringProperty getISBN() {

            return mISBN;
        }

        public void setISBN(SimpleStringProperty ISBN) {

            mISBN = ISBN;
        }


/*
    public StringProperty bookISBNProperty() {
        return mISBN;
    }
*/


        public SimpleFloatProperty getMemberPrice() {

            return mMemberPrice;
        }

        public void setMemberPrice(SimpleFloatProperty memberPrice) {

            mMemberPrice = memberPrice;
        }

        public SimpleFloatProperty getRetailPrice() {
            return mRetailPrice;
        }

        public void setRetailPrice(SimpleFloatProperty retailPrice) {

            mRetailPrice = retailPrice;
        }

        public SimpleStringProperty getTitle() {

            return mTitle;
        }

        public void setTitle(SimpleStringProperty title) {

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

    }
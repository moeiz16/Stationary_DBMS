package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


import javafx.scene.control.Alert.AlertType;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class Main extends Application {


    public static boolean isNotNumeric(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    Stage window;



    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Stationary Shop Management System");


        //Adding additional Images

        FileInputStream signinpic = new FileInputStream("D:\\Untitled design (3).png");
        Image image2 = new Image(signinpic);
        BackgroundImage backgroundImage2 = new BackgroundImage(image2, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImage2);


        FileInputStream admindashboardpic = new FileInputStream("D:\\Untitled design (10).png");
        Image image3 = new Image(admindashboardpic);
        BackgroundImage backgroundimage3 = new BackgroundImage(image3, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background3 = new Background(backgroundimage3);







        //BUTTON FOR LOGINS
        GridPane layout1 = new GridPane();
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.setPadding(new Insets(50, 10, 10, 30));
        layout1.setVgap(13);

        layout1.setHgap(20);


        Text logo = new Text(" Stationary shop");
        logo.setFont(Font.font("Times New Roman", 40));
        logo.setFill(Color.BLACK);
        layout1.add(logo, 0, 14);
        logo.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Button registrationform = new Button("  Admin Registration");

        layout1.add(registrationform, 0, 22);
        registrationform.setFont(new Font("Times roman",25));

        Button adminlogin = new Button("   Admin  Login        ");
        layout1.add(adminlogin, 0, 24);
        adminlogin.setFont(new Font("Times roman",25 ));

        Button employeelogin = new Button("   Employee Login    ");
        layout1.add(employeelogin, 0, 26);
        employeelogin.setFont(new Font("Times roman",25));



        //managing colors


        registrationform.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        adminlogin.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        employeelogin.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");



        //




        Scene scene1 = new Scene(layout1, 800, 1000);
        layout1.setBackground(background);

// end login forms


        //First Scene(Registration form)
        GridPane FL = new GridPane();
        FL.setAlignment(Pos.TOP_CENTER);
        FL.setPadding(new Insets(50, 10, 10, 30));
        FL.setVgap(12);
        FL.setHgap(12);

        Text FT = new Text("Registration Form");
        FT.setFont(Font.font("Arial", 40));
        FT.setFill(Color.BLACK);
        FL.add(FT, 0, 12);
        FT.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text FNT = new Text("Name: ");
        FNT.setFont(Font.font("Arial", 20));
        FNT.setFill(Color.BLACK);
        TextField NTF = new TextField();
        FL.add(FNT, 0, 15);
        FL.add(NTF, 0, 16);
        NTF.setPromptText("Enter Name");
        NTF.setFocusTraversable(false);



        Text CHARACTERN = new Text("ID: ");
        CHARACTERN.setFont(Font.font("Arial", 20));
        CHARACTERN.setFill(Color.BLACK);
        TextField CNTF = new TextField();
        FL.add(CHARACTERN, 0, 17);
        FL.add(CNTF, 0, 18);
        CNTF.setPromptText("Enter ID");
        CNTF.setFocusTraversable(false);


        Text FET = new Text("Email: ");
        FET.setFont(Font.font("Arial", 20));
        FET.setFill(Color.BLACK);
        TextField ETF = new TextField();
        FL.add(FET, 0, 19);
        FL.add(ETF, 0,20 );
        ETF.setPromptText("Enter Email");
        ETF.setFocusTraversable(false);


        Text FPT = new Text("Password: ");
        FPT.setFont(Font.font("Arial", 20));
        FPT.setFill(Color.BLACK);
        PasswordField PF= new PasswordField();
        FL.add(FPT, 0, 21);
        FL.add(PF, 0, 22);
        PF.setPromptText("Enter Password");
        PF.setFocusTraversable(false);



        Button signIn = new Button("                Sign Up                       ");
        FL.add(signIn, 0, 25);
        signIn.setFont(new Font("Arial",21 ));
        signIn.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        signIn.setStyle("-fx-background-color:rgba(255,192,3,1)");



        Button back_button = new Button("                   Back                       ");
        FL.add(back_button, 0,28);
        back_button.setFont(new Font("Arial",21 ));
        back_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        back_button.setStyle("-fx-background-color:rgba(255,192,3,1)");



        Scene Scene2 = new Scene(FL, 800, 1000);
        FL.setBackground(background3);
        window.setScene(Scene2) ;

//Login Scene
        GridPane login = new GridPane();
        login.setAlignment(Pos.TOP_CENTER);
        login.setPadding(new Insets(50, 10, 10, 30));
        login.setVgap(12);
        login.setHgap(12);

        Text LT = new Text("Login Form");               //title of login form
        LT.setFont(Font.font("Arial", 40));
        LT.setFill(Color.BLACK);
        login.add(LT, 0, 15);
        LT.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text loginID = new Text("ID:");    // login id  text
        loginID.setFont(Font.font("Arial", 20));
        loginID.setFill(Color.BLACK);
        TextField loginTF = new TextField(); //login id text field
        login.add(loginID, 0, 22);
        login.add(loginTF, 0, 23);
        loginTF.setStyle("-fx-backgroung-color:rgba(225,225,225,1)");
        loginTF.setPromptText("Enter ID");
        loginTF.setFocusTraversable(false);

        Text paswordF = new Text("Password: ");  // pasword text
        paswordF.setFont(Font.font("Arial", 20));
        paswordF.setFill(Color.BLACK);

        PasswordField PTF = new PasswordField();  //pasword text field
        login.add(paswordF, 0, 24);
        login.add(PTF, 0, 25);
        PTF.setPromptText("Enter Password");
        PTF.setFocusTraversable(false);





        Button LFB = new Button("            Login             ");  // login button
        login.add(LFB, 0, 28);
        LFB.setFont(new Font("Arial",20 ));
        LFB.setStyle("-fx-border-color:WHITE; -fx-border-width:1px");

        LFB.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        LFB.setStyle("-fx-background-color:rgba(255,192,3,1)");



        Button back_button3 = new Button("            Back             ");  // login button
        login.add(back_button3, 0, 32);
        back_button3.setFont(new Font("Arial",20 ));
        back_button3.setStyle("-fx-border-color:WHITE; -fx-border-width:1px");

        back_button3.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        back_button3.setStyle("-fx-background-color:rgba(255,192,3,1)");

        Scene Scene3 = new Scene(login, 800, 1000);
        login.setBackground(background);
        window.setScene(Scene3) ;


        // end admin login form*********************


        //  admin dashboard form******************


        GridPane adminboard = new GridPane();
        adminboard.setAlignment(Pos.TOP_CENTER);
        adminboard.setPadding(new Insets(50, 10, 10, 30));
        adminboard.setVgap(13);

        adminboard.setHgap(20);


        Text adminlogo = new Text("DASHBOARD");  // admin dashboard title
        adminlogo.setFont(Font.font("Arial",  34));
        adminlogo.setFill(Color.BLACK);
        adminboard.add(adminlogo, 1, 5);



        Button ADDProduct = new Button("   Add Product     ");   // add product button
        adminboard.add(ADDProduct, 1, 10);
        ADDProduct.setFont(new Font("Arial",25));


        Button AddEmployee = new Button("  Add Employee  ");  // add employee button
        adminboard.add(AddEmployee, 1, 12);
        AddEmployee.setFont(new Font("Arial",25 ));


        Button AddSupplier = new Button("   Add Supplier    ");  // add supplier Button
        adminboard.add(AddSupplier, 1, 14);
        AddSupplier.setFont(new Font("Arial",25));

        Button outOfStock= new Button("  Out of Stock    ");
        adminboard.add(outOfStock, 1, 16);
        outOfStock.setFont(new Font("Arial",25));


        Button placeorder = new Button("   Selling Order    ");   // selling product button
        adminboard.add(placeorder, 1, 18);
        placeorder.setFont(new Font("Arial",25));

        Button supplierorder = new Button(" Purchase Order  ");    // purchase button
        adminboard.add(supplierorder, 1, 20);
        supplierorder.setFont(new Font("Arial",25));



        Button profit_report = new Button("        Profit         ");  // retrun to main button
        adminboard.add(profit_report, 1, 22);
        profit_report.setFont(new Font("Arial",25));


        //managing colors


        ADDProduct.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        AddEmployee.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        AddSupplier.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        outOfStock.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        placeorder.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        supplierorder.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        profit_report.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        adminboard.setBackground(background3);
        Scene scene4 = new Scene(adminboard, 800, 1000);




//        GridPane adminboard = new GridPane();
//        adminboard.setAlignment(Pos.TOP_CENTER);
//        adminboard.setPadding(new Insets(50, 10, 10, 30));
//        adminboard.setVgap(13);
//
//        adminboard.setHgap(20);
//
//
//        Text adminlogo = new Text("DASHBOARD");  // admin dashboard title
//        adminlogo.setFont(Font.font("Times New Roman", 30));
//        adminlogo.setFill(Color.BLACK);
//        adminboard.add(adminlogo, 1, 5);
//        adminlogo.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//
//
//        Button ADDProduct = new Button(" Add Product");   // add product button
//        adminboard.add(ADDProduct, 0, 10);
//        ADDProduct.setFont(new Font("Times roman",27));
//
//
//        Button AddEmployee = new Button("Add Employee");  // add employee button
//        adminboard.add(AddEmployee, 0, 12);
//        AddEmployee.setFont(new Font("Times roman",25 ));
//
//
//        Button AddSupplier = new Button("Add Supplier");  // add supplier Button
//        adminboard.add(AddSupplier, 0, 14);
//        AddSupplier.setFont(new Font("Times roman",27));
//
//        Button outOfStock = new Button("Out of Stock");
//        adminboard.add(outOfStock, 0, 16);
//        outOfStock.setFont(new Font("Times roman",27));
//
//
//        Button placeorder = new Button("Sales");   // selling product button
//        adminboard.add(placeorder, 1, 10);
//        placeorder.setFont(new Font("Times roman",27));
//
//        Button supplierorder = new Button("Purchase Order");    // purchase button
//        adminboard.add(supplierorder, 1, 12);
//        supplierorder.setFont(new Font("Times roman",24));
//
//
//
//        Button profit_report = new Button("Monthly Profit Report");  // return to main button
//        adminboard.add(profit_report, 1, 14);
//        profit_report.setFont(new Font("Times roman",27));
//
//
//        //managing colors
//
//
//        ADDProduct.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        AddEmployee.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        AddSupplier.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        outOfStock.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        placeorder.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        supplierorder.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        profit_report.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//
//        ADDProduct.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        AddEmployee.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        AddSupplier.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        outOfStock.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        placeorder.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        profit_report.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        supplierorder.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
//        adminboard.setBackground(background);
//        Scene scene4 = new Scene(adminboard, 800, 700);
        //end admin dashboard****************************

//Add product**************************

        GridPane addprdct = new GridPane();
        addprdct.setAlignment(Pos.TOP_CENTER);
        addprdct.setPadding(new Insets(50, 10, 10, 30));
        addprdct.setVgap(12);
        addprdct.setHgap(12);

        Text pdct_title = new Text(" ADD PRODUCT");
        pdct_title.setFont(Font.font("Arial", 40));
        pdct_title.setFill(Color.BLACK);
        addprdct.add(pdct_title, 0, 10);
        pdct_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text ProductID = new Text ("Product ID: ");
        ProductID.setFont(Font.font("Arial", 20));
        ProductID.setFill(Color.BLACK);
        TextField ProductIDTF = new TextField();
        addprdct.add(ProductID, 0, 14);
        addprdct.add(ProductIDTF, 0, 15);
        ProductIDTF.setPromptText("Enter Name");
        ProductIDTF.setFocusTraversable(false);


        Text ProductIName = new Text("Product Name:");
        ProductIName.setFont(Font.font("Arial", 20));
        ProductIName.setFill(Color.BLACK);
        TextField ProductINameTF = new TextField();
        addprdct.add(ProductIName, 0, 16);
        addprdct.add(ProductINameTF, 0, 17);
        ProductINameTF.setPromptText("Enter Product Name");
        ProductINameTF.setFocusTraversable(false);

        Text unitprice = new Text("UnitPrice: ");
        unitprice.setFont(Font.font("Arial", 20));
        unitprice.setFill(Color.BLACK);
        TextField unitpriceTF = new TextField();
        addprdct.add(unitprice, 0, 18);
        addprdct.add(unitpriceTF, 0,19 );
        unitpriceTF.setPromptText("Enter Unitprice");
        unitpriceTF.setFocusTraversable(false);

        Button APB = new Button("               Add product                 ");
        addprdct.add(APB, 0, 21);
        APB.setFont(new Font("Arial",20));
        APB.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        APB.setStyle("-fx-background-color:rgba(255,192,3,1)");



        Button Update_prdct = new Button("              Update product              ");
        addprdct.add(Update_prdct, 0, 23);
        Update_prdct.setFont(new Font("Arial",20 ));
        Update_prdct.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Update_prdct.setStyle("-fx-background-color:rgba(255,192,3,1)");

//        Button Delete_prdct = new Button("            Delete product                ");
//        addprdct.add(Delete_prdct, 0, 34);
//        Delete_prdct.setFont(new Font("Arial",20 ));
//        Delete_prdct.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        Delete_prdct.setStyle("-fx-background-color:RED");


        Button back_button4 = new Button("                        Back                    ");
        addprdct.add(back_button4, 0, 24);
        back_button4.setFont(new Font("Arial",20 ));
        back_button4.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        back_button4.setStyle("-fx-background-color:rgba(255,192,3,1)");




        Scene Scene5 = new Scene(addprdct, 800, 1000);
        addprdct.setBackground(background3);



        // add product end**************************


        // Add employee************************
        GridPane addemply = new GridPane();
        addemply.setAlignment(Pos.TOP_CENTER);
        addemply.setPadding(new Insets(50, 10, 10, 30));
        addemply.setVgap(12);
        addemply.setHgap(12);

        Text emplyoee_tile = new Text(" ADD Employee");
        emplyoee_tile.setFont(Font.font("Arial", 40));
        emplyoee_tile.setFill(Color.BLACK);
        addemply.add(emplyoee_tile, 0, 10);
        emplyoee_tile.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text E_id = new Text ("Employee ID: ");
        E_id.setFont(Font.font("Arial", 20));
        E_id.setFill(Color.BLACK);
        TextField E_idTF = new TextField();
        addemply.add(E_id, 0, 14);
        addemply.add(E_idTF, 0, 15);
        E_idTF.setPromptText("Enter ID");
        E_idTF.setFocusTraversable(false);



        Text E_Name = new Text("Employee Name:");
        E_Name.setFont(Font.font("Arial", 20));
        E_Name.setFill(Color.BLACK);
        TextField E_NameTF = new TextField();
        addemply.add(E_Name, 0, 16);
        addemply.add(E_NameTF, 0, 17);
        E_NameTF.setPromptText("Enter Name");
        E_NameTF.setFocusTraversable(false);



        Text pass = new Text("Set Password: ");
        pass.setFont(Font.font("Arial", 20));
        pass.setFill(Color.BLACK);
        PasswordField passTF = new PasswordField();
        addemply.add(pass, 0, 18);
        addemply.add(passTF, 0,19 );
        passTF.setPromptText("Enter Password");
        passTF.setFocusTraversable(false);




        Text E_contact = new Text("Contact No: ");
        E_contact.setFont(Font.font("Arial", 20));
        E_contact.setFill(Color.BLACK);
        TextField E_contactTF = new TextField();
        addemply.add(E_contact, 0, 20);
        addemply.add(E_contactTF, 0, 21);
        E_contactTF.setPromptText("Enter Contact No");
        E_contactTF.setFocusTraversable(false);




        Button employee_B = new Button("                Add Employee                 ");
        addemply.add(employee_B, 0, 22);
        employee_B.setFont(new Font("Arial",20));
        employee_B.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        employee_B.setStyle("-fx-background-color:rgba(255,192,3,1)");



//        Button E_update = new Button("               Update Employee             ");
//        addemply.add(E_update, 0, 23);
//        E_update.setFont(new Font("Arial",20 ));
//        E_update.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        E_update.setStyle("-fx-background-color:rgba(255,192,3,1)");

        Button E_Delete = new Button("                Delete Employee             ");
        addemply.add(E_Delete, 0, 23);
        E_Delete.setFont(new Font("Arial",20 ));

        E_Delete.setStyle("-fx-background-color:RED");


        Button back_button5 = new Button("                          Back                       ");
        addemply.add(back_button5, 0, 24);
        back_button5.setFont(new Font("Arial",20 ));
        back_button5.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        back_button5.setStyle("-fx-background-color:rgba(255,192,3,1)");

        addemply.setBackground(background3);
        Scene Scene6 = new Scene(addemply, 800, 1000);


        //end add employee***********************

        // add supplier form********************


        GridPane add_supplier = new GridPane();
        add_supplier.setAlignment(Pos.TOP_CENTER);
        add_supplier.setPadding(new Insets(50, 10, 10, 30));
        add_supplier.setVgap(12);
        add_supplier.setHgap(12);

        Text supplier_title = new Text(" ADD Supplier");
        supplier_title.setFont(Font.font("Times New Roman", 40));
        supplier_title.setFill(Color.BLACK);
        add_supplier.add(supplier_title, 1, 0);
        supplier_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text S_id = new Text ("Supplier ID: ");
        S_id.setFont(Font.font("Times New Roman", 20));
        S_id.setFill(Color.BLACK);
        TextField S_idTF = new TextField();
        add_supplier.add(S_id, 0, 6);
        add_supplier.add(S_idTF, 1, 6);
        S_id.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        S_idTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text S_name = new Text("Supplier Name:");
        S_name.setFont(Font.font("Times New Roman", 20));
        S_name.setFill(Color.BLACK);
        TextField S_nameTF = new TextField();
        add_supplier.add(S_name, 0, 8);
        add_supplier.add(S_nameTF, 1, 8);
        S_name.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        S_nameTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");




        Text S_Contact = new Text("Contact No: ");
        S_Contact.setFont(Font.font("Times New Roman", 20));
        S_Contact.setFill(Color.BLACK);
        TextField S_ContactTF = new TextField();
        add_supplier.add(S_Contact, 0, 10);
        add_supplier.add(S_ContactTF, 1, 10);
        S_Contact.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        S_ContactTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");




        Button supplier_B = new Button("Add Supplier");
        add_supplier.add(supplier_B, 1, 14);
        supplier_B.setFont(new Font("Times roman",25));
        supplier_B.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        supplier_B.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");



        Button S_update = new Button("Update Supplier");
        add_supplier.add(S_update, 2, 20);
        S_update.setFont(new Font("Times roman",20 ));
        S_update.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        S_update.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        Button S_Delete = new Button("Delete Supplier");
        add_supplier.add(S_Delete, 3, 20);
        S_Delete.setFont(new Font("Times roman",20 ));
        S_Delete.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        S_Delete.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        add_supplier.setBackground(background);
        Scene Scene7 = new Scene(add_supplier, 800, 700);




        // employee login***********************
        GridPane employee_login = new GridPane();
        employee_login.setAlignment(Pos.TOP_CENTER);
        employee_login.setPadding(new Insets(50, 10, 10, 30));
        employee_login.setVgap(12);
        employee_login.setHgap(12);

        Text Emplyee_txt = new Text("Employee Login");               //title of employee_login form
        Emplyee_txt.setFont(Font.font("Times New Roman", 40));
        Emplyee_txt.setFill(Color.BLACK);
        employee_login.add(Emplyee_txt, 1, 0);
        Emplyee_txt.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text employee_loginID = new Text("ID:");    // employee_login id  text
        employee_loginID.setFont(Font.font("Times New Roman", 20));
        employee_loginID.setFill(Color.BLACK);
        TextField employee_loginTF = new TextField(); //employee_login id text field
        employee_login.add(employee_loginID, 0, 4);
        employee_login.add(employee_loginTF, 1, 4);
        employee_loginID.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        employee_loginTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text password_emp = new Text("PASSWORD: ");  // pasword text
        password_emp.setFont(Font.font("Times New Roman", 20));
        password_emp.setFill(Color.BLACK);
        PasswordField emp_TF = new PasswordField();  //pasword text field
        employee_login.add(password_emp, 0, 6);
        employee_login.add(emp_TF, 1, 6);
        password_emp.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        emp_TF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");




        Button emp_LB = new Button("Login");  // employee_login button
        employee_login.add(emp_LB, 1, 8);
        emp_LB.setFont(new Font("Times roman",25 ));
        emp_LB.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        emp_LB.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
        Scene Scene8 = new Scene(employee_login, 800, 700);
        employee_login.setBackground(background);


        // end employee login form*********************
// employee dashboard**************
        GridPane emp_board = new GridPane();
        emp_board.setAlignment(Pos.TOP_CENTER);
        emp_board.setPadding(new Insets(50, 10, 10, 30));
        emp_board.setVgap(13);

        emp_board.setHgap(20);


        Text emp_logo = new Text("Employee Dashboard");
        emp_logo.setFont(Font.font("Times New Roman", 40));
        emp_logo.setFill(Color.BLACK);
        emp_board.add(emp_logo, 0, 0);
        emp_logo.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Button employee_Sales_Button = new Button("Sales Department");

        emp_board.add(employee_Sales_Button, 0, 4);
        employee_Sales_Button.setFont(new Font("Times roman",29));

        employee_Sales_Button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        employee_Sales_Button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
        Scene Scene9= new Scene(emp_board, 1000, 800);
        emp_board.setBackground(background);


        //delete supplier**********************

        GridPane dlt_supplier = new GridPane();
        dlt_supplier.setAlignment(Pos.TOP_CENTER);
        dlt_supplier.setPadding(new Insets(50, 10, 10, 30));
        dlt_supplier.setVgap(12);
        dlt_supplier.setHgap(12);

        Text supplier_dlt_title = new Text(" Delete Supplier");
        supplier_dlt_title.setFont(Font.font("Times New Roman", 40));
        supplier_dlt_title.setFill(Color.BLACK);
        dlt_supplier.add(supplier_dlt_title, 1, 0);
        supplier_dlt_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text supplier_dlt_id = new Text ("Supplier ID: ");
        supplier_dlt_id.setFont(Font.font("Times New Roman", 20));
        supplier_dlt_id.setFill(Color.BLACK);
        TextField supplier_dlt_idTF = new TextField();
        dlt_supplier.add(supplier_dlt_id, 0, 6);
        dlt_supplier.add(supplier_dlt_idTF, 1, 6);
        supplier_dlt_id.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        supplier_dlt_idTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Button supplier_dlt_button = new Button("Delete Supplier");
        dlt_supplier.add(supplier_dlt_button, 1, 8);
        supplier_dlt_button.setFont(new Font("Times roman",20 ));
        supplier_dlt_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        supplier_dlt_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");


        Scene Scene10 = new Scene(dlt_supplier, 800, 700);
        dlt_supplier.setBackground(background);


        // end delete supplier************************

        //delete employee**********************

        GridPane dlt_employee = new GridPane();
        dlt_employee.setAlignment(Pos.TOP_CENTER);
        dlt_employee.setPadding(new Insets(50, 10, 10, 30));
        dlt_employee.setVgap(12);
        dlt_employee.setHgap(12);

        Text em_dlt_title = new Text(" Delete Employee");
        em_dlt_title.setFont(Font.font("Times New Roman", 40));
        em_dlt_title.setFill(Color.BLACK);
        dlt_employee.add(em_dlt_title, 1, 0);
        em_dlt_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text em_dlt_id = new Text ("Employee ID: ");
        em_dlt_id.setFont(Font.font("Times New Roman", 20));
        em_dlt_id.setFill(Color.BLACK);
        TextField em_dlt_idTF = new TextField();
        dlt_employee.add(em_dlt_id, 0, 6);
        dlt_employee.add(em_dlt_idTF, 1, 6);
        em_dlt_id.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        em_dlt_idTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Button em_dlt_button = new Button("Delete Employee");
        dlt_employee.add(em_dlt_button, 1, 8);
        em_dlt_button.setFont(new Font("Times roman",20 ));
        em_dlt_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        em_dlt_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");


        Scene Scene11 = new Scene(dlt_employee, 800, 700);
        dlt_employee.setBackground(background);


        // end delete   employee************************

//update product*************


        GridPane update_product = new GridPane();
        update_product.setAlignment(Pos.TOP_CENTER);
        update_product.setPadding(new Insets(50, 10, 10, 30));
        update_product.setVgap(12);
        update_product.setHgap(12);

        Text updated_product_title = new Text(" Update PRODUCT");
        updated_product_title.setFont(Font.font("Times New Roman", 40));
        updated_product_title.setFill(Color.BLACK);
        update_product.add(updated_product_title, 0, 0);
        updated_product_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        ComboBox updateidBox=new ComboBox();
        updateidBox.setPromptText("ProductID");


        Text update_productID = new Text ("Select the Product ID to update: ");
        update_productID.setFont(Font.font("Times New Roman", 20));
        update_productID.setFill(Color.BLACK);
//        TextField update_productIDTF = new TextField();
        update_product.add(update_productID, 0, 6);
        update_product.add(updateidBox, 0, 7);
//        update_productID.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
//        update_productIDTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");





        Text update_product_price = new Text(" Enter the updated price: ");
        update_product_price.setFont(Font.font("Times New Roman", 20));
        update_product_price.setFill(Color.BLACK);
        TextField update_product_priceTF = new TextField();
        update_product.add(update_product_price, 0, 9);
        update_product.add(update_product_priceTF, 0,10 );
        update_product_price.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        update_product_priceTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        //visile wala kaam
//        update_product_price.setVisible(false);
//        update_product_priceTF.setVisible(false);
        // khatam



        Button updated_product_button = new Button("Update");
        update_product.add(updated_product_button, 0, 12);
        updated_product_button.setFont(new Font("Times roman",25));
        updated_product_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        updated_product_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");




        Scene Scene12 = new Scene(update_product, 800, 700);
        update_product.setBackground(background);



        // end update product***************

// purchase department***********
        GridPane purchase_DEPT = new GridPane();
        purchase_DEPT.setAlignment(Pos.TOP_CENTER);
        purchase_DEPT.setPadding(new Insets(50, 10, 10, 30));
        purchase_DEPT.setVgap(12);
        purchase_DEPT.setHgap(12);

        Text PURCHASE_TITLE = new Text(" PURCHASE");
        PURCHASE_TITLE.setFont(Font.font("Times New Roman", 40));
        PURCHASE_TITLE.setFill(Color.BLACK);
        purchase_DEPT.add(PURCHASE_TITLE, 1, 0);
        PURCHASE_TITLE.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text product_id_purchase = new Text ("Product ID: ");
        product_id_purchase.setFont(Font.font("Times New Roman", 20));
        product_id_purchase.setFill(Color.BLACK);
        ComboBox comboBox = new ComboBox();
        comboBox.setPromptText("Product ID");
        purchase_DEPT.add(product_id_purchase, 0, 6);
        purchase_DEPT.add(comboBox, 1, 6);
        product_id_purchase.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        comboBox.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text supplier_id = new Text ("Supplier ID: ");
        supplier_id.setFont(Font.font("Times New Roman", 20));
        supplier_id.setFill(Color.BLACK);
        ComboBox comboBox1 = new ComboBox();
        comboBox1.setPromptText("Supplier ID");
        purchase_DEPT.add(supplier_id, 0, 8);
        purchase_DEPT.add(comboBox1, 1, 8);
        supplier_id.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        comboBox1.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text purchase_price = new Text ("Purchasing price: ");
        purchase_price.setFont(Font.font("Times New Roman", 20));
        purchase_price.setFill(Color.BLACK);
        TextField purchase_priceTF = new TextField();
        purchase_DEPT.add(purchase_price, 0, 10);
        purchase_DEPT.add(purchase_priceTF, 1, 10);
        purchase_price.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        purchase_priceTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text Quantity = new Text ("Quantity: ");
        Quantity.setFont(Font.font("Times New Roman", 20));
        Quantity.setFill(Color.BLACK);
        TextField QuantityTF = new TextField();
        purchase_DEPT.add(Quantity, 0, 12);
        purchase_DEPT.add(QuantityTF, 1, 12);
        Quantity.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        QuantityTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");





        Button Purchase_button = new Button("Purchase");
        purchase_DEPT.add(Purchase_button, 0, 14);
        Purchase_button.setFont(new Font("Times roman",25));
        Purchase_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Purchase_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");


        //Table of Products in sales department

        TableView<Products> productTable2=new TableView();

        productTable2.setEditable(true);

        TableColumn<Products, String> ProductIDCol2 = new TableColumn("Product ID");
        TableColumn<Products, String> ProductNameCol2 = new TableColumn("Product Name");
        TableColumn<Products, String> Sales_Unit_Price_Col2 = new TableColumn("Sales Unit Price");
        TableColumn<Products, String> Purchase_Unit_Price_Col2 = new TableColumn("Purchase Unit Price");
        TableColumn<Products, String> Stock_Col2 = new TableColumn("Stock");

        productTable2.getColumns().addAll(ProductIDCol2, ProductNameCol2, Sales_Unit_Price_Col2, Purchase_Unit_Price_Col2, Stock_Col2);

        ObservableList<Products> productsObservableList2=FXCollections.observableArrayList();

        ProductIDCol2.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        ProductNameCol2.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        Sales_Unit_Price_Col2.setCellValueFactory(new PropertyValueFactory<>("Sales_Unit_Price"));
        Purchase_Unit_Price_Col2.setCellValueFactory(new PropertyValueFactory<>("Purchase_Unit_Price"));
        Stock_Col2.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        productTable2.setPrefWidth(450);
        productTable2.setItems(productsObservableList2);


        purchase_DEPT.add(productTable2, 1,16);


        Scene Scene13 = new Scene(purchase_DEPT, 800, 700);
        purchase_DEPT.setBackground(background);

        //  sales department***********************8

        GridPane sales_Dept = new GridPane();
        sales_Dept.setAlignment(Pos.TOP_CENTER);
        sales_Dept.setPadding(new Insets(50, 10, 10, 30));
        sales_Dept.setVgap(12);
        sales_Dept.setHgap(12);

        Text sales_dept_title = new Text("Sales Department");
        sales_dept_title.setFont(Font.font("Times New Roman", 40));
        sales_dept_title.setFill(Color.BLACK);
        sales_Dept.add(sales_dept_title, 1, 0);
        sales_dept_title.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");

        Text product_id_sales = new Text ("Product ID: ");
        product_id_sales.setFont(Font.font("Times New Roman", 20));
        product_id_sales.setFill(Color.BLACK);
        ComboBox comboBox3 = new ComboBox();
        comboBox3.setPromptText("Product ID");
        sales_Dept.add(product_id_sales, 0, 6);
        sales_Dept.add(comboBox3, 1, 6);
        product_id_sales.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        comboBox.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");


        Text Quantity_sales = new Text ("Quantity: ");
        Quantity_sales.setFont(Font.font("Times New Roman", 20));
        Quantity_sales.setFill(Color.BLACK);
        TextField Quantity_salesTF = new TextField();
        sales_Dept.add(Quantity_sales, 0, 8);
        sales_Dept.add(Quantity_salesTF, 1, 8);
        Quantity_sales.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Quantity_salesTF.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");



        Button Add_product_sales_button = new Button("Add to Cart");
        sales_Dept.add(Add_product_sales_button, 1, 10);
        Add_product_sales_button.setFont(new Font("Times roman",25));
        Add_product_sales_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Add_product_sales_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        Button Sales_button = new Button("Checkout");
        sales_Dept.add(Sales_button, 1, 12);
        Sales_button.setFont(new Font("Times roman",25));
        Sales_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Sales_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        //for employee
        Button Sales_button2 = new Button("Checkout");
        sales_Dept.add(Sales_button2, 1, 12);
        Sales_button2.setFont(new Font("Times roman",25));
        Sales_button2.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        Sales_button2.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        Sales_button2.setVisible(false);


        Button cancelOrder_button = new Button("Cancel Order");
        sales_Dept.add(cancelOrder_button, 1, 14);
        cancelOrder_button.setFont(new Font("Times roman",25));
        cancelOrder_button.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        cancelOrder_button.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

//Table of Products in sales department

        TableView<Products> productTable=new TableView();

        productTable.setEditable(true);

        TableColumn<Products, String> ProductIDCol = new TableColumn("Product ID");
        TableColumn<Products, String> ProductNameCol = new TableColumn("Product Name");
        TableColumn<Products, String> Sales_Unit_Price_Col = new TableColumn("Sales Unit Price");
        TableColumn<Products, String> Purchase_Unit_Price_Col = new TableColumn("Purchase Unit Price");
        TableColumn<Products, String> Stock_Col = new TableColumn("Stock");

        productTable.getColumns().addAll(ProductIDCol, ProductNameCol, Sales_Unit_Price_Col, Purchase_Unit_Price_Col, Stock_Col);

        ObservableList<Products> productsObservableList=FXCollections.observableArrayList();

        ProductIDCol.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        ProductNameCol.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        Sales_Unit_Price_Col.setCellValueFactory(new PropertyValueFactory<>("Sales_Unit_Price"));
        Purchase_Unit_Price_Col.setCellValueFactory(new PropertyValueFactory<>("Purchase_Unit_Price"));
        Stock_Col.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        productTable.setPrefWidth(450);
        productTable.setItems(productsObservableList);

      sales_Dept.add(productTable,1, 15);




        Scene Scene14 = new Scene(sales_Dept, 800, 700);
        sales_Dept.setBackground(background);


//Out of Stock Scene

        GridPane stockout = new GridPane();
        stockout.setAlignment(Pos.TOP_CENTER);
        stockout.setPadding(new Insets(50, 10, 10, 30));
        stockout.setVgap(12);
        stockout.setHgap(12);


//---------------------Out of Stock Table

        TableView<Products> outOfStockTable=new TableView();

        outOfStockTable.setEditable(true);

        TableColumn<Products, String> ProductIDCol3 = new TableColumn("Product ID");
        TableColumn<Products, String> ProductNameCol3 = new TableColumn("Product Name");
        TableColumn<Products, String> Sales_Unit_Price_Col3 = new TableColumn("Sales Unit Price");
        TableColumn<Products, String> Purchase_Unit_Price_Col3 = new TableColumn("Purchase Unit Price");
        TableColumn<Products, String> Stock_Col3 = new TableColumn("Stock");

        outOfStockTable.getColumns().addAll(ProductIDCol3, ProductNameCol3, Sales_Unit_Price_Col3, Purchase_Unit_Price_Col3, Stock_Col3);

        ObservableList<Products> outOfStockObservableList=FXCollections.observableArrayList();

        ProductIDCol3.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        ProductNameCol3.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        Sales_Unit_Price_Col3.setCellValueFactory(new PropertyValueFactory<>("Sales_Unit_Price"));
        Purchase_Unit_Price_Col3.setCellValueFactory(new PropertyValueFactory<>("Purchase_Unit_Price"));
        Stock_Col3.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        outOfStockTable.setPrefWidth(450);
        outOfStockTable.setItems(outOfStockObservableList);


        stockout.add(outOfStockTable, 1, 2);

        Button moveToPurchase = new Button("Place Order");  // login button
        stockout.add(moveToPurchase , 2, 12);
        moveToPurchase .setFont(new Font("Times roman",25 ));
        moveToPurchase .setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        moveToPurchase .setStyle("-fx-border-color:WHITE; -fx-border-width:3px");
        Scene Scene15 = new Scene(stockout, 800, 700);
        stockout.setBackground(background);
//------------End of out of Stock Profit Scene----------



// ------------------Profit Report Scene------------------


        GridPane profitPane = new GridPane();
        profitPane.setAlignment(Pos.TOP_CENTER);
        profitPane.setPadding(new Insets(50, 10, 10, 30));
        profitPane.setVgap(12);
        profitPane.setHgap(12);

        TableView<ProfitReport> profitReportTable=new TableView();

        profitReportTable.setEditable(true);

        TableColumn<ProfitReport, String> MonthCol = new TableColumn("Month");
        TableColumn<ProfitReport, String> Total_SalesCol = new TableColumn("Total Sales");
        TableColumn<ProfitReport, String> Total_PurchaseCol = new TableColumn("Total Purchase");
        TableColumn<ProfitReport, String> Total_ProfitCol = new TableColumn("Total Profit");


        profitReportTable.getColumns().addAll(MonthCol, Total_SalesCol, Total_PurchaseCol, Total_ProfitCol);

        ObservableList<ProfitReport> profitReportList=FXCollections.observableArrayList();

        MonthCol.setCellValueFactory(new PropertyValueFactory<>("Month"));
        Total_SalesCol.setCellValueFactory(new PropertyValueFactory<>("Total_Sales"));
        Total_PurchaseCol.setCellValueFactory(new PropertyValueFactory<>("Total_Purchase"));
        Total_ProfitCol.setCellValueFactory(new PropertyValueFactory<>("Total_Profit"));


        profitReportTable.setPrefWidth(310);
        profitReportTable.setItems(profitReportList);


        profitPane.add(profitReportTable, 1, 2);

        Button endProfitReport = new Button("Back");
        profitPane.add(endProfitReport , 2, 12);
        endProfitReport.setFont(new Font("Times roman",25 ));
        endProfitReport.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        endProfitReport.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");


        Button mostsoldproduct = new Button("Most Sold Product");
        profitPane.add(mostsoldproduct , 1, 12);
        mostsoldproduct.setFont(new Font("Times roman",25 ));
        mostsoldproduct.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.8),10,0,0,0)");
        mostsoldproduct.setStyle("-fx-border-color:WHITE; -fx-border-width:3px");

        Scene Scene16 = new Scene(profitPane, 800, 1000);

        profitPane.setBackground(background);









//End Profit Report Scene
        //-----------Use of Buttons----------------//


        //Button for admin registration form
        signIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String adminName = NTF.getText();
                String adminID = CNTF.getText();
                String adminEmail = ETF.getText();
                String adminPassword = PF.getText();
            if(adminID.isEmpty() || adminPassword.isEmpty()|| adminEmail.isEmpty()){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Insertion Dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Incomplete Details");

                alert.showAndWait();

            }
            else{
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    try {
                        Statement statement1 = conn.createStatement();


                        String insertionQuery = "insert into adminInfo values ('" + adminName + "','" + adminID + "','" + adminEmail + "','" + adminPassword + "')";
                        int query = statement1.executeUpdate(insertionQuery);


                        if (query > 0) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Admin Registration Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("Admin Successfully Registered");

                            alert.showAndWait();
                            window.setScene(scene1);

                        }
                    } catch (Exception unsuccessful) {

                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Insertion Dialogue");
                        alert.setHeaderText(null);
                        alert.setContentText("Admin ID already exists");

                        alert.showAndWait();

                    }

                    NTF.setText("");
                    CNTF.setText("");
                    ETF.setText("");
                    PF.setText("");

                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }
            }

            }
        });

        adminlogin.setOnAction(e -> window.setScene(Scene3)); // switch button

        //This button is for admin login
        LFB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String loginID=loginTF.getText();
                String password=PTF.getText();


                if(loginID.isEmpty() || password.isEmpty()){

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Login Dialogue");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter all Details");

                    alert.showAndWait();
                }else {
                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");


                        Statement statement1 = conn.createStatement();
                        String loginQuery = "select ID, Password from adminInfo where ID='" + loginID + "' and Password='" + password + "'";
                        ResultSet rs = statement1.executeQuery(loginQuery);

                        if (rs.next()) {
                            if (rs.getString(1).equals(loginID) && rs.getString(2).equals(password)) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Login Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("Login Successful");

                                alert.showAndWait();


                                window.setScene(scene4);
                            }

                        } else {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Login Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("AdminID does not exist");

                            alert.showAndWait();
                        }
                        loginTF.setText("");
                        PTF.setText("");


                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }
            }
        });

        //Button used to go to add product form
        ADDProduct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene5);
            }
        });

        //This button is used to add product
        APB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                float salesPrice=0;
                int ids=0;

                if(ProductIDTF.getText().isEmpty() || ProductINameTF.getText().isEmpty()|| unitpriceTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD PRODUCT Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Incomplete Product Details");

                    alert.showAndWait();

                }else if(isNotNumeric(unitpriceTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD PRODUCT Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Enter Valid Unit Price");

                    alert.showAndWait();
                    unitpriceTF.setText("");

                }else if(isNotNumeric(ProductIDTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD PRODUCT Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("ID must be a number");

                    alert.showAndWait();
                    ProductIDTF.setText("");

                }else if((salesPrice=Float.parseFloat(unitpriceTF.getText()))<=0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD PRODUCT Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid unit price");

                    alert.showAndWait();
                    unitpriceTF.setText("");

                }else if((ids=Integer.parseInt(ProductIDTF.getText()))<=0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD PRODUCT Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("ID must be a positive");

                    alert.showAndWait();
                    ProductIDTF.setText("");
                }
                else{
                    int productID = Integer.parseInt(ProductIDTF.getText());
                    String productName= ProductINameTF.getText();
                    float unitPrice=Float.parseFloat(unitpriceTF.getText());
                    int initialStock=0;
                    float purchasingUnitPrice=0;

                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();


                            String insertionQuery = "insert into products values (" + productID + ",'" + productName + "'," + unitPrice + "," + purchasingUnitPrice + "," + initialStock + ")";
                            int query = statement1.executeUpdate(insertionQuery);


                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Product Insertion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Product was successfully added");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }
                        } catch (Exception unsuccessful) {
                                
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Product Insertion Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("The Product ID already exists");

                            alert.showAndWait();

                        }

                        ProductIDTF.setText("");
                        ProductINameTF.setText("");
                        unitpriceTF.setText("");


                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

            }
        });







        registrationform.setOnAction(e -> window.setScene(Scene2)); // switch button
        FL.setBackground(background);


        AddEmployee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene6);
            }
        });


        employee_B.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                if(E_idTF.getText().isEmpty() || E_NameTF.getText().isEmpty()|| passTF.getText().isEmpty() || E_contactTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD EMPLOYEE Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Incomplete Employee Details");

                    alert.showAndWait();

                }
                else{
                    String employeeID = E_idTF.getText();
                    String employeeName= E_NameTF.getText();
                    String employeePassword= passTF.getText();
                    String employeeContact= E_contactTF.getText();



                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();


                            String insertionQuery = "insert into employees values ('" + employeeID + "','" + employeeName + "','" + employeePassword + "','" + employeeContact + "')";
                            int query = statement1.executeUpdate(insertionQuery);


                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Employee Insertion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Employee was successfully registered");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }
                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Employee Insertion Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("The Employee ID already exists");

                            alert.showAndWait();

                        }

                        E_idTF.setText("");
                        E_NameTF.setText("");
                        passTF.setText("");
                        E_contactTF.setText("");

                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

            }
        });

        AddSupplier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene7);
            }
        });

        supplier_B.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                if(S_idTF.getText().isEmpty() || S_nameTF.getText().isEmpty()|| S_ContactTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ADD SUPPLIER Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Incomplete Supplier Details");

                    alert.showAndWait();

                }
                else{
                    String supplierID = S_idTF.getText();
                    String supplierName= S_nameTF.getText();
                    String supplierContact= S_ContactTF.getText();




                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();


                            String insertionQuery = "insert into suppliers values ('" + supplierID + "','" + supplierName + "','" + supplierContact + "')";
                            int query = statement1.executeUpdate(insertionQuery);


                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Supplier Insertion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Supplier was successfully added");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }
                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Supplier Insertion Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("The Supplier ID already exists");

                            alert.showAndWait();

                        }

                        S_idTF.setText("");
                        S_nameTF.setText("");
                        S_ContactTF.setText("");


                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

            }
        });

//Employee Login Form
        employeelogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene8);
            }
        });

        emp_LB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String loginID=employee_loginTF.getText();
                String password=emp_TF.getText();


                if(loginID.isEmpty() || password.isEmpty()){

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Employee Login Dialogue");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter all Details");

                    alert.showAndWait();
                }else {
                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");


                        Statement statement1 = conn.createStatement();
                        String loginQuery = "select EmployeeID, Emp_Password from employees where EmployeeID='" + loginID + "' and Emp_Password='" + password + "'";
                        ResultSet rs = statement1.executeQuery(loginQuery);

                        if (rs.next()) {
                            if (rs.getString(1).equals(loginID) && rs.getString(2).equals(password)) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Employee Login Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("Login Successful");

                                alert.showAndWait();


                                window.setScene(Scene9);
                            }

                        } else {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Employee Login Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("EmployeeID does not exist");

                            alert.showAndWait();
                        }
                        employee_loginTF.setText("");
                        emp_TF.setText("");


                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }
            }
        });


        S_Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene10);
            }
        });

        supplier_dlt_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                if(supplier_dlt_idTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Delete SUPPLIER Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the Supplier ID to delete");

                    alert.showAndWait();

                }
                else{
                    String supplierID = supplier_dlt_idTF.getText();

                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();


                            String deletionQuery="delete from product_supplier where SupplierID='"+supplierID+"'";

                            int queryFirst=statement1.executeUpdate(deletionQuery);


                            String insertionQuery = "DELETE from suppliers WHERE SupplierID = '" + supplierID +"'";
                            int query = statement1.executeUpdate(insertionQuery);


                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Supplier Deletion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Supplier was successfully deleted");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Supplier Deletion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Supplier ID does not exist");

                                alert.showAndWait();
                            }
                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Supplier Deletion Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("The Supplier ID does not exist");

                            alert.showAndWait();

                        }

                        supplier_dlt_idTF.setText("");



                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

            }
        });

        E_Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(Scene11);
            }
        });


        em_dlt_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                if(em_dlt_idTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Delete EMPLOYEE Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the Employee ID to delete");

                    alert.showAndWait();

                }
                else{
                    String employeeID = em_dlt_idTF.getText();

                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();


                            String insertionQuery = "DELETE from employees WHERE EmployeeID = '" + employeeID +"'";
                            int query = statement1.executeUpdate(insertionQuery);


                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Employee Deletion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Employee was successfully deleted");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }else{
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Employee Deletion Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("The Employee ID does not exist");

                                alert.showAndWait();
                            }
                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Employee Deletion Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("The Employee ID does not exist");

                            alert.showAndWait();

                        }

                        em_dlt_idTF.setText("");



                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

            }
        });


        Update_prdct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
            System.out.println("Connected");

            Statement statement1=conn.createStatement();

            String q1="select ProductID from products";
            ResultSet rs=statement1.executeQuery(q1);

            updateidBox.getItems().removeAll(updateidBox.getItems());

            while (rs.next())
            {
                updateidBox.getItems().add(rs.getString(1));
            }


            conn.close();


        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Database connection error.");

        }



                window.setScene(Scene12);
            }
        });

        updated_product_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                float updatedUnitPriceofProduct=0;
                if(updateidBox.getSelectionModel().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Update Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose a Product ID");

                    alert.showAndWait();

                }else if(update_product_priceTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Update Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter updated unit price");

                    alert.showAndWait();
                }else if(isNotNumeric(update_product_priceTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid unit price");

                    alert.showAndWait();
                    update_product_priceTF.setText("");


                }else if((updatedUnitPriceofProduct=Float.parseFloat(update_product_priceTF.getText()))<=0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid unit price");

                    alert.showAndWait();
                    update_product_priceTF.setText("");


                }
                else{
                    String stringproductID = (String) updateidBox.getValue();
                    int productID=Integer.parseInt(stringproductID);
                    float updatedUnitPrice=Float.parseFloat(update_product_priceTF.getText());

                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();



                            int updateHistory=0;

                            try {
                                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                                        Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                                        System.out.println("Connected");

                                        Statement statement10=conn2.createStatement();

                                        String q10="select SalesUnitPrice from products where ProductID="+productID;
                                        ResultSet rs50=statement10.executeQuery(q10);
                                        float number=0;

                                        while (rs50.next())
                                        {
                                            number=Float.parseFloat(rs50.getString(1));
                                        }

                                        if(number!=updatedUnitPrice){
                                            String historyTableQuery="insert into historyTableSalesPrice values (GETDATE(),"+productID+", (Select ProductName from Products where ProductID="+productID+"), (Select SalesUnitPrice from Products where ProductID="+productID+"),  (Select PurchaseUnitPrice from Products where ProductID="+productID+"))";
                                            updateHistory=statement10.executeUpdate(historyTableQuery);
                                        }



                                        conn2.close();


                            } catch (Exception e) {
                                        System.err.println(e.getMessage());
                                        e.printStackTrace();
                                        System.out.println("Database connection error.");

                                    }



                            String updationQuery = "Update Products set SalesUnitPrice= "+ updatedUnitPrice+" where ProductID= "+productID;
                            int query = statement1.executeUpdate(updationQuery);

                            if (updateHistory > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("History Updation");
                                alert.setHeaderText(null);
                                alert.setContentText("History Table was updated");

                                alert.showAndWait();


                            }



                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Product Updation");
                                alert.setHeaderText(null);
                                alert.setContentText("The Product's Unit Price was successfully updated");

                                alert.showAndWait();
                                window.setScene(scene4);

                            }




                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Product Updation");
                            alert.setHeaderText(null);
                            alert.setContentText("Product Unit Price was not updated");

                            alert.showAndWait();

                        }


                        update_product_priceTF.setText("");



                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }


            }
        });

        supplierorder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                productsObservableList2.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from Products";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        productsObservableList2.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }







                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();

                    String q1="select ProductID from products";
                    ResultSet rs=statement1.executeQuery(q1);

                    comboBox.getItems().removeAll(comboBox.getItems());

                    while (rs.next())
                    {
                        comboBox.getItems().add(rs.getString(1));
                    }

                    Statement statement2=conn.createStatement();
                    String q2="select SupplierID from suppliers";
                    ResultSet rs2=statement2.executeQuery(q2);

                    comboBox1.getItems().removeAll(comboBox1.getItems());

                    while (rs2.next())
                    {
                        comboBox1.getItems().add(rs2.getString(1));
                    }

                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }

                window.setScene(Scene13);
            }
        });

        Purchase_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int quant=0;
                float purchasePriceFromSupplier=0;
                if(comboBox.getSelectionModel().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose a Product ID");

                    alert.showAndWait();

                }else if(comboBox1.getSelectionModel().isEmpty()){

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose a Supplier ID");

                    alert.showAndWait();
                }else if(purchase_priceTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a purchase unit price");

                    alert.showAndWait();
                }else if(QuantityTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter quantity to complete order");

                    alert.showAndWait();
                }else if(isNotNumeric(purchase_priceTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter correct purchase unit price");

                    alert.showAndWait();
                }else if(isNotNumeric(QuantityTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter correct quantity");

                    alert.showAndWait();
                }else if((quant=Integer.parseInt(QuantityTF.getText())) <= 0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid quantity");

                    alert.showAndWait();
                    purchase_priceTF.setText("");
                    QuantityTF.setText("");


                }else if((purchasePriceFromSupplier=Float.parseFloat(purchase_priceTF.getText())) <= 0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Purchase Product Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid unit price");

                    alert.showAndWait();

                    purchase_priceTF.setText("");
                    QuantityTF.setText("");
                }
                else{
                    String stringproductID = (String) comboBox.getValue();
                    int productID=Integer.parseInt(stringproductID);

                    String stringSupplierID = (String) comboBox1.getValue();

                    float purchaseUnitPriceFromSupplier=Float.parseFloat(purchase_priceTF.getText());
                    int quantityOrderedForPurchase=Integer.parseInt(QuantityTF.getText());



                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();

                        int updateHistory=0;
                            try {
                                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                                Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                                System.out.println("Connected");

                                Statement statement10=conn2.createStatement();

                                String q10="select PurchaseUnitPrice from products where ProductID="+productID;
                                ResultSet rs50=statement10.executeQuery(q10);
                                float number=0;

                                while (rs50.next())
                                {
                                    number=Float.parseFloat(rs50.getString(1));
                                }

                                if(number!=purchasePriceFromSupplier){
                                    String historyTableQuery="insert into historyTableSalesPrice values (GETDATE(),"+productID+", (Select ProductName from Products where ProductID="+productID+"), (Select SalesUnitPrice from Products where ProductID="+productID+"),  (Select PurchaseUnitPrice from Products where ProductID="+productID+"))";
                                    updateHistory=statement10.executeUpdate(historyTableQuery);

                                }



                                conn2.close();


                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                                e.printStackTrace();
                                System.out.println("Database connection error.");

                            }


                            String purchaseQuery = "insert into product_supplier values (" + productID + ",'" + stringSupplierID + "', GETDATE(), " +purchaseUnitPriceFromSupplier + ", "+quantityOrderedForPurchase+", null)";;
                            int query = statement1.executeUpdate(purchaseQuery);

                            Statement statement2= conn.createStatement();
                            String displayTotal="select Total from product_supplier where PurchaseID=(SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC)";
                            ResultSet resultSet= statement2.executeQuery(displayTotal);
                            float total=0;

                            if(resultSet.next()){
                                total=Float.parseFloat(resultSet.getString(1));
                            }


                            if (updateHistory > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("History Updation");
                                alert.setHeaderText(null);
                                alert.setContentText("History Table was updated");

                                alert.showAndWait();


                            }





                            if (query > 0) {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Purchase Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("Total was: "+ total);

                                alert.showAndWait();

                                Alert alert2 = new Alert(AlertType.INFORMATION);
                                alert2.setTitle("Purchase Dialogue");
                                alert2.setHeaderText(null);
                                alert2.setContentText("Purchase was successful and stock was updated");

                                alert2.showAndWait();

                                window.setScene(scene4);
                            }



                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Purchase Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("Sorry! the purchase order was unsuccessful");

                            alert.showAndWait();

                        }


                        purchase_priceTF.setText("");
                        QuantityTF.setText("");



                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }


            }
        });


        placeorder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productsObservableList.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from Products";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        productsObservableList.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();

                    String q1="select ProductID from products";
                    ResultSet rs=statement1.executeQuery(q1);

                    comboBox3.getItems().removeAll(comboBox3.getItems());

                    while (rs.next())
                    {
                        comboBox3.getItems().add(rs.getString(1));
                    }

                    Statement statement2= conn.createStatement();


                    String insertionQuery = "insert into orders values(GETDATE(), 0, 0, 0, 0)";
                    int query = statement2.executeUpdate(insertionQuery);





                    if(query>0){
                        Sales_button.setVisible(true);
                        Sales_button2.setVisible(false);
                        window.setScene(Scene14);
                    }




                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


            }
        });




        Add_product_sales_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                int quant=0;

                if(comboBox3.getSelectionModel().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Sales Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose a Product ID");

                    alert.showAndWait();

                }else if(Quantity_salesTF.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Sales Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter quantity of Product");

                    alert.showAndWait();
                }else if(isNotNumeric(Quantity_salesTF.getText())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Sales Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid quantity");

                    alert.showAndWait();

                    Quantity_salesTF.setText("");


                }else if((quant=Integer.parseInt(Quantity_salesTF.getText())) <= 0){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Sales Dialogue Box");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid quantity");

                    alert.showAndWait();

                    Quantity_salesTF.setText("");


                }
                else{
                    String stringproductID = (String) comboBox3.getValue();
                    int productID=Integer.parseInt(stringproductID);

                    int quantityOrderedForSale=Integer.parseInt(Quantity_salesTF.getText());



                    try {
                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                        System.out.println("Connected");

                        try {
                            Statement statement1 = conn.createStatement();

                            String query= "Select Stock from Products where ProductID="+productID;
                            ResultSet rs=statement1.executeQuery(query);

                            int actualStockOfProduct=0;

                            while(rs.next()){

                                actualStockOfProduct=Integer.parseInt(rs.getString(1));

                            }


                            if(quantityOrderedForSale>actualStockOfProduct){
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Sales Dialogue");
                                alert.setHeaderText(null);
                                alert.setContentText("Sorry but we're short of Stock for your order. Present Stock is: "+actualStockOfProduct);

                                alert.showAndWait();
                            }else{

                                try {
                                    Statement statement2 = conn.createStatement();

                                   // insert into order_product values ((SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC), 202, GETDATE(), 5, 0, 0, 0, 0)

                                    String salesQuery = "insert into order_product values ((SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC),"+productID+",  GETDATE(),"+quantityOrderedForSale+", 0, 0, 0, 0)";
                                    int sales = statement2.executeUpdate(salesQuery);



                                    if (sales > 0) {
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("Cart Dialogue");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Added To Cart");

                                        alert.showAndWait();

                                    }
                                } catch (Exception unsuccessful) {

                                    Alert alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Sales Dialogue");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Sorry! the order was unsuccessful");

                                    alert.showAndWait();

                                }





                            }





                        } catch (Exception unsuccessful) {

                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Sales Dialogue");
                            alert.setHeaderText(null);
                            alert.setContentText("Sorry! the sales order was unsuccessful");

                            alert.showAndWait();

                        }

                        Quantity_salesTF.setText("");



                        conn.close();


                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                        System.out.println("Database connection error.");

                    }
                }

                productsObservableList.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from Products";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        productsObservableList.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }





            }
        });
        

        Sales_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

           try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
            System.out.println("Connected");

            Statement statement1=conn.createStatement();


            String q1="update orders set Total_Sales_Cost=0";
            int query=statement1.executeUpdate(q1);

            Statement statement2= conn.createStatement();
            String q2="Select Total_Sales_Cost from orders where order_id = (SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)";
            ResultSet rs= statement2.executeQuery(q2);

            float totalBillOrder=0;

            while(rs.next()){
                totalBillOrder=Float.parseFloat(rs.getString(1));
            }

            if(query>0){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sales Dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Your ordered was successfully placed. Total bill is: "+totalBillOrder);

                alert.showAndWait();
            }


            conn.close();


        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Database connection error.");

        }


                window.setScene(scene4);
            }
        });



        Sales_button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();


                    String q1="update orders set Total_Sales_Cost=0";
                    int query=statement1.executeUpdate(q1);

                    Statement statement2= conn.createStatement();
                    String q2="Select Total_Sales_Cost from orders where order_id = (SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)";
                    ResultSet rs= statement2.executeQuery(q2);

                    float totalBillOrder=0;

                    while(rs.next()){
                        totalBillOrder=Float.parseFloat(rs.getString(1));
                    }

                    if(query>0){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sales Dialogue");
                        alert.setHeaderText(null);
                        alert.setContentText("Your ordered was successfully placed. Total bill is: "+totalBillOrder);

                        alert.showAndWait();
                    }


                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


                window.setScene(Scene9);
            }
        });

        //Cancelling Order in sales


        cancelOrder_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();


                    String q1="delete from orders where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)";
                    int query=statement1.executeUpdate(q1);


                    if(query>0){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sales Dialogue");
                        alert.setHeaderText(null);
                        alert.setContentText("Your order was cancelled");

                        alert.showAndWait();
                    }


                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }



                window.setScene(scene4);
            }
        });



        //Out of Stock Products
        outOfStock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                outOfStockObservableList.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from products where Products.Stock<=5";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        outOfStockObservableList.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


                window.setScene(Scene15);
            }
        });


        moveToPurchase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                productsObservableList2.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from Products";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        productsObservableList2.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }







                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();

                    String q1="select ProductID from products";
                    ResultSet rs=statement1.executeQuery(q1);

                    comboBox.getItems().removeAll(comboBox.getItems());

                    while (rs.next())
                    {
                        comboBox.getItems().add(rs.getString(1));
                    }

                    Statement statement2=conn.createStatement();
                    String q2="select SupplierID from suppliers";
                    ResultSet rs2=statement2.executeQuery(q2);

                    comboBox1.getItems().removeAll(comboBox1.getItems());

                    while (rs2.next())
                    {
                        comboBox1.getItems().add(rs2.getString(1));
                    }

                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }

                window.setScene(Scene13);

            }
        });



        profit_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                profitReportList.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from VIEW_TOTAL";
                    ResultSet rsProfit=statementDisplay.executeQuery(displayquery);


                    while (rsProfit.next())
                    {
                        profitReportList.add(new ProfitReport(rsProfit.getString(1),rsProfit.getString(2), rsProfit.getString(3),rsProfit.getString(4)));
                    }

                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }






                window.setScene(Scene16);
            }
        });

        endProfitReport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene4);
            }
        });



        back_button.setOnAction(e -> window.setScene(scene1));
//        back_button2.setOnAction(e -> window.setScene(scene1));
        back_button3.setOnAction(e -> window.setScene(scene1));



        employee_Sales_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productsObservableList.clear();
                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statementDisplay=conn2.createStatement();

                    String displayquery="select * from Products";
                    ResultSet rsProducts=statementDisplay.executeQuery(displayquery);


                    while (rsProducts.next())
                    {
                        productsObservableList.add(new Products(rsProducts.getString(1),rsProducts.getString(2), rsProducts.getString(3),rsProducts.getString(4),rsProducts.getString(5)));
                    }


                    conn2.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


                try {
                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
                    System.out.println("Connected");

                    Statement statement1=conn.createStatement();

                    String q1="select ProductID from products";
                    ResultSet rs=statement1.executeQuery(q1);

                    comboBox3.getItems().removeAll(comboBox3.getItems());

                    while (rs.next())
                    {
                        comboBox3.getItems().add(rs.getString(1));
                    }

                    Statement statement2= conn.createStatement();


                    String insertionQuery = "insert into orders values(GETDATE(), 0, 0, 0, 0)";
                    int query = statement2.executeUpdate(insertionQuery);





                    if(query>0){


                        Sales_button2.setVisible(true);
                        Sales_button.setVisible(false);
                        window.setScene(Scene14);
                    }




                    conn.close();


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    System.out.println("Database connection error.");

                }


            }
        });

        mostsoldproduct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
            System.out.println("Connected");

            Statement statement1=conn.createStatement();

            String q1="select top 1 (select ProductName from Products where ProductID=Product_id) as ProductName from(select Product_id, sum(Quantity) as QuantityOrdered from order_product group by Product_id)temp order by QuantityOrdered desc";
            ResultSet rs=statement1.executeQuery(q1);



            while (rs.next())
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Most Sold Product");
                alert.setHeaderText(null);
                alert.setContentText("Most Sold Product is: "+rs.getString(1));

                alert.showAndWait();
            }

            String q2="select top 1 (select ProductName from Products where ProductID=temp3.Product_id) as ProductName, (temp3.Costing * temp3.QuantityOrdered) as TotalMarginProfit from(select Product_id, QuantityOrdered, (temp2.SalesPrice-temp2.PurchasePrice) as Costing from(select Product_id, QuantityOrdered, (select SalesUnitPrice from Products where ProductID=temp.Product_id) as SalesPrice, (select PurchaseUnitPrice from Products where ProductID=temp.Product_id) as PurchasePrice from(select Product_id, sum(Quantity) as QuantityOrdered from order_product group by Product_id)temp)temp2)temp3 order by TotalMarginProfit desc";
            ResultSet rs2=statement1.executeQuery(q2);

            while (rs2.next())
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Most Sold Product");
                alert.setHeaderText(null);
                alert.setContentText("Most Revenue Generating Product is: "+rs2.getString(1));

                alert.showAndWait();
            }



            conn.close();


        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Database connection error.");

        }


            }
        });


       window.setScene(scene1);
        window.show();
    }



    public static void main(String[] args) {
//
//        try {
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=PROJECT;user=MOEIZSH;password=MADS");
//            System.out.println("Connected");
//
//            Statement statement1=conn.createStatement();
//
//
////            String q1="insert into Tbl_student values (10, 'Shahzad')";
////            int query=statement1.executeUpdate(q1);
////
////            System.out.println(query);
//            String q1="select ProductID from products where ProductID=123";
//            ResultSet rs=statement1.executeQuery(q1);
//            int number=0;
//
//            while (rs.next())
//            {
//                number=Integer.parseInt(rs.getString(1));
//            }
//
//            System.out.println(number);
//            conn.close();
//
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//            System.out.println("Database connection error.");
//
//        }



        launch(args);
    }
}

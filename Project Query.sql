--Using Database PROJECT
use PROJECT
--For admin
CREATE TABLE adminInfo (Name varchar(100), ID varchar(30) primary key, Email varchar(100) not null, Password varchar(100) not null)
select * from adminInfo



--For products

 
 CREATE TABLE Products(ProductID int primary key, ProductName varchar(100), SalesUnitPrice float not null, PurchaseUnitPrice float, Stock int)
 select * from products

 --Constraints
 alter table Products
 add constraint nonnegativestock
 CHECK (Products.Stock >= 0)

 alter table Products
 add constraint nonnegativeSalesUnitPrice
 CHECK (Products.SalesUnitPrice >= 0)

 alter table Products
 add constraint nonnegativePurchaseUnitPrice
 CHECK (Products.PurchaseUnitPrice >= 0)

 



--For employees
create table employees(EmployeeID varchar(30) primary key, EmployeeName varchar(100), Emp_Password varchar(100) not null, Emp_Contact varchar(14))
select * from employees


--For Suppliers
create table suppliers(SupplierID varchar(30) primary key, SupplierName varchar(100), SupplierContact varchar(14))
select * from suppliers



--PURCHASE DEPARTMENT TABLES, TRIGGERS, STORED PROCEDURES AND QUERIES
CREATE TABLE product_supplier (PurchaseID int primary key Identity(100, 1),ProductID int, SupplierID varchar(30), PurchaseDate date Default(getDate()), UnitPrice float not null, Quantity int not null, Total float)




--Constraints
 alter table product_supplier
 add constraint nonnegativepurchaseunitpriceproduct_supplier
 CHECK (product_supplier.UnitPrice >= 0)

 alter table product_supplier
 add constraint nonnegativepurchasequantityproduct_supplier
 CHECK (product_supplier.Quantity >= 0)



--Applying Foreign Keys
alter table product_supplier
add constraint supplier_fk
Foreign key (SupplierID) References Suppliers (SupplierID)

alter table product_supplier
add constraint product_fk
Foreign key (ProductID) References Products (ProductID)


--Procedures and Triggers for Purchase Department
create procedure purchaseStoredProcedure
@PurchaseID int,
@ProductID int,
@SupplierID varchar(30),
@UnitPrice float,
@Quantity int
as
BEGIN

Update product_supplier set product_supplier.Total=@UnitPrice*@Quantity where product_supplier.PurchaseID=@PurchaseID

Update PRODUCTS set PRODUCTS.PurchaseUnitPrice= @UnitPrice where PRODUCTS.ProductID=@ProductID

Update PRODUCTS set PRODUCTS.Stock=@Quantity+(PRODUCTS.Stock) where PRODUCTS.ProductID=@ProductID

END

create trigger purchase_trigger
on product_supplier
after insert 
as begin

Declare @PurchaseID int = (SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC),@ProductID int=(select ProductID from product_supplier where PurchaseID=(SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC)), @SupplierID varchar(30)=(select SupplierID from product_supplier where PurchaseID=(SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC)), @UnitPrice float=(select UnitPrice from product_supplier where PurchaseID=(SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC)), @Quantity int=(select Quantity from product_supplier where PurchaseID=(SELECT TOP 1 PurchaseID FROM product_supplier ORDER BY PurchaseID DESC))
Execute purchaseStoredProcedure  @PurchaseID, @ProductID, @SupplierID, @UnitPrice, @Quantity
End


--SALES DEPARTMENT TABLES, PROCEDURES AND TRIGGERS
create table orders(order_id int primary key Identity(001, 1), order_date date Default(getDate()), Total_Sales_Cost float, Total_Purchase_Cost float, Profit float, MonthofOrder int)


create table order_product(sales_id int primary key Identity(1000, 1), order_id int Foreign key References orders (order_id), Product_id int Foreign key references Products (ProductID), sales_datetime smalldatetime Default (getDate()), Quantity int, Sales_Unit_Price float, Purchase_Unit_Price float, Total_Sale_Cost float, Total_Purchase_Cose float)


--Constraints of order_product
 alter table order_product
 add constraint nonnegativesalesquantityproduct_order
 CHECK (order_product.Quantity >= 0)


--Trigger to add product in order
create trigger set_sales_trigger
on order_product
after insert
as begin


Declare @salesid int= (SELECT TOP 1 sales_id FROM order_product ORDER BY sales_id DESC), @order_id int = (select order_id from order_product where sales_id=(SELECT TOP 1 sales_id FROM order_product ORDER BY sales_id DESC)),@ProductID int=(select Product_id from order_product where sales_id=(SELECT TOP 1 sales_id FROM order_product ORDER BY sales_id DESC)),@Quantity int=(select Quantity from order_product where sales_id=(SELECT TOP 1 sales_id FROM order_product ORDER BY sales_id DESC))
Execute salesStoredProcedure @salesid, @order_id,@ProductID, @Quantity

End


--Procedure for add product to order button
create procedure salesStoredProcedure
@salesid int,
@order_id int,
@ProductID int,
@Quantity int
as
BEGIN

update order_product set Sales_Unit_Price = (select SalesUnitPrice from PRODUCTS where PRODUCTS.ProductID=@ProductID) where sales_id=@salesid
update order_product set Purchase_Unit_Price = (select PurchaseUnitPrice from PRODUCTS where PRODUCTS.ProductID=@ProductID) where sales_id=@salesid
update order_product set Total_Sale_Cost = (@Quantity * (select Sales_Unit_Price from order_product where sales_id=@salesid)) where sales_id=@salesid
update order_product set Total_Purchase_Cose = (@Quantity * (select Purchase_Unit_Price from order_product where sales_id=@salesid)) where sales_id=@salesid
update PRODUCTS set PRODUCTS.Stock=((select PRODUCTS.Stock from PRODUCTS where ProductID=@ProductID)-@Quantity) where PRODUCTS.ProductID=@ProductID

END



--Trigger for updating Total Prices in order table
create trigger updatingPricesinOrders on 
orders instead of 
update as begin

update orders set Total_Sales_Cost=temp.TotalSalesAmount from(select order_id, sum(Total_Sale_Cost) as TotalSalesAmount from order_product where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)
group by order_id)temp
where orders.order_id=temp.order_id

update orders set Total_Purchase_Cost=temp.TotalPurchaseAmount from(select order_id, sum(Total_Purchase_Cose) as TotalPurchaseAmount from order_product where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)
group by order_id)temp
where orders.order_id=temp.order_id

update orders set Profit=(Total_Sales_Cost-Total_Purchase_Cost) where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)
update orders set MonthofOrder=(Select MONTH(order_date) as Month from orders where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)) where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)

End

insert into orders values(GETDATE(), 0, 0)

insert into order_product values ((SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC), 202, GETDATE(), 5, 0, 0, 0, 0)

update orders set Total_Sales_Cost=0





--if user presses cancel order
--3 kaam hogay
--1. Update the stock back in the products
--2. delete from order_product where order_id is the latest id
--3. delete from orders where order_id is the latest id




select * from order_product
select * from orders
select * from Products

update orders set Total_Sales_Cost=0


--Cancelling Order will result in updation of stock called in this order
create trigger cancelOrder
on orders instead of 
delete as Begin

update Products set Products.Stock=(Products.Stock+Quantity) from(select Product_id, Quantity from order_product where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC))temp
where Products.ProductID=temp.Product_id

delete from order_product where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)

delete from orders where order_id=(SELECT TOP 1 order_id FROM orders ORDER BY order_id DESC)


End





select * from Products
select * from orders
select * from order_product

--HISTORY TABLE FOR UPDATION OF UNIT PRICES
create table historyTableSalesPrice (UpdationDate smalldatetime Default(getDate()),ProductID int, ProductName varchar(100), Sales_Unit_Price float, Purchase_Unit_Price float)

insert into historyTableSalesPrice values (GETDATE(), 110, (Select ProductName from Products where ProductID=110), (Select SalesUnitPrice from Products where ProductID=110), (Select PurchaseUnitPrice from Products where ProductID=110))
select * from historyTableSalesPrice

select * from orders
select * from order_product


select * from employees
select * from Products


select order_date, sum(Total_Sales_Cost) from orders
group by order_date


--CREATING VIEWS
CREATE VIEW VIEW_TOTAL AS

select MonthofOrder as Month_, sum(Total_Sales_Cost) as Total_Sales, sum(Total_Purchase_Cost) as Total_Purchase, SUM(Profit) as Total_Profit from orders
group by MonthofOrder



select * from VIEW_TOTAL


select * from order_product
--Most Sold Product Query
select top 1 (select ProductName from Products where ProductID=Product_id) as ProductName from(select Product_id, sum(Quantity) as QuantityOrdered from order_product group by Product_id)temp order by QuantityOrdered desc

select * from Products


--Most Profit Margin Product
select temp4.ProductName from(select top 1 (select ProductName from Products where ProductID=temp3.Product_id) as ProductName, (temp3.Costing * temp3.QuantityOrdered) as TotalMarginProfit from(select Product_id, QuantityOrdered, (temp2.SalesPrice-temp2.PurchasePrice) as Costing from(select Product_id, QuantityOrdered, (select SalesUnitPrice from Products where ProductID=temp.Product_id) as SalesPrice, (select PurchaseUnitPrice from Products where ProductID=temp.Product_id) as PurchasePrice from(select Product_id, sum(Quantity) as QuantityOrdered from order_product group by Product_id)temp)temp2)temp3 order by TotalMarginProfit desc)temp4


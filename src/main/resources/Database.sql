--Create database BanSon
--go
--USE BanSon
--go
----DROP DATABASE BanSon

--CREATE TABLE Category (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Name NVARCHAR(30)
--);

--CREATE TABLE Color (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Name NVARCHAR(255) NOT NULL,
--);

---- Tạo bảng Sản phẩm (Product)
--CREATE TABLE Product (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Name NVARCHAR(255) NOT NULL,
--	Importprice DECIMAL(10, 2) NOT NULL,
--    Price DECIMAL(10, 2) NOT NULL,
--	AvailableQuantity INT,
--	sold INT,
--	Manufacturer NVARCHAR(MAX),
--	Datecreated DATE NOT NULL,
--    ImageUrl NVARCHAR(MAX),
--	Status INT,
--    Description NVARCHAR(MAX),
--    ColorId UNIQUEIDENTIFIER,
--	CategoryId UNIQUEIDENTIFIER,
--    FOREIGN KEY (CategoryId) REFERENCES Category(Id),
--	FOREIGN KEY (ColorId) REFERENCES Color(Id)
--);

---- Tạo bảng Sản phẩm (Product)
--CREATE TABLE Product (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Name NVARCHAR(255) NOT NULL,
--    Description NVARCHAR(MAX),
--	Manufacturer NVARCHAR(MAX),
--	AvailableQuantity INT,
--	sold INT,
--    Price DECIMAL(10, 2) NOT NULL,
--	Importprice DECIMAL(10, 2) NOT NULL,
--	date DATE NOT NULL,
--	Status INT,
--    ImageUrl NVARCHAR(MAX),
--    ColorId UNIQUEIDENTIFIER,
--	CategoryId UNIQUEIDENTIFIER,
--    FOREIGN KEY (CategoryId) REFERENCES Category(Id),
--	FOREIGN KEY (ColorId) REFERENCES Color(Id)
--);

--CREATE TABLE Role (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    RoleName NVARCHAR(100) NOT NULL,
--    Description NVARCHAR(MAX),
--    Status INT
--);

--CREATE TABLE Employee (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    FullName NVARCHAR(100) NOT NULL,
--    Username NVARCHAR(200),
--    Password NVARCHAR(15),
--    Gender INT,
--    PhoneNumber NVARCHAR(11),
--    Email NVARCHAR(50),
--    DateOfBirth Date,
--	Datecreated Date, 
--    Image NVARCHAR(MAX),
--	Address NVARCHAR(100),
--	Status INT,
--	RoleId UNIQUEIDENTIFIER,
--	FOREIGN KEY (RoleId) REFERENCES Role(Id)
--);

--CREATE TABLE Customer (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    FullName NVARCHAR(100) NOT NULL,
--    Username NVARCHAR(50),
--    Password NVARCHAR(50),
--	Gender INT,
--    PhoneNumber NVARCHAR(15),
--    Email NVARCHAR(100),
--    DateOfBirth DATE,
--	Datecreated Date, 
--    Address NVARCHAR(200),
--    Status INT,
--);

---- Tạo bảng Danh mục (Category)
--CREATE TABLE Cart (
--	Cartid UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    CustomerId UNIQUEIDENTIFIER,
--	FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
--);

--CREATE TABLE Employee (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    FullName NVARCHAR(100) NOT NULL,
--    Username NVARCHAR(200),
--    Password NVARCHAR(15),
--    Image NVARCHAR(MAX),
--    DateOfBirth Date,
--    Gender INT,
--	Datecreated Date, 
--    PhoneNumber NVARCHAR(11),
--    Email NVARCHAR(50),
--	Address NVARCHAR(100),
--	Status INT,
--	RoleId UNIQUEIDENTIFIER,
--	FOREIGN KEY (RoleId) REFERENCES Role(Id)
--);

--CREATE TABLE Customer (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    FullName NVARCHAR(100) NOT NULL,
--    DateOfBirth DATE,
--    Address NVARCHAR(200),
--    PhoneNumber NVARCHAR(15),
--	Datecreated Date, 
--    Email NVARCHAR(100),
--	Gender INT,
--    Status INT,
--    Username NVARCHAR(50),
--    Password NVARCHAR(50),
--);

---- Tạo bảng Danh mục (Category)
--CREATE TABLE Cart (
--	Cartid UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    CustomerId UNIQUEIDENTIFIER,
--    Description NVARCHAR(MAX) NOT NULL,
--	FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
--);

--CREATE TABLE CartDetail (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Cartdetail  UNIQUEIDENTIFIER,
--    ProductId UNIQUEIDENTIFIER,
--    Quantity INT NOT NULL,
--	FOREIGN KEY (Cartdetail) REFERENCES Cart(Cartid),
--    FOREIGN KEY (ProductId) REFERENCES Product(Id)	
--);

--CREATE TABLE FavoriteProducts (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    CustomerId UNIQUEIDENTIFIER NOT NULL,
--    ProductId UNIQUEIDENTIFIER NOT NULL,
--    Description NVARCHAR(MAX) NOT NULL,
--    FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
--    FOREIGN KEY (ProductId) REFERENCES Product(Id)
--);

--CREATE TABLE Bill_Status (
--    Id INT PRIMARY KEY IDENTITY(1,1),
--    Name NVARCHAR(MAX)
--);

--CREATE TABLE Bill (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    CreateDate DATE NOT NULL,
--	Price DECIMAL(10, 2) NOT NULL,
--	Address  NVARCHAR(100) NOT NULL,
--    BillStatusId Int,
--	EmployeeId UNIQUEIDENTIFIER,
--    CustomerId UNIQUEIDENTIFIER,
--    FOREIGN KEY (BillStatusId) REFERENCES Bill_Status(Id),
--    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id),
--    FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
--);

--CREATE TABLE BillDetail (
--    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
--    Price DECIMAL(10, 2) NOT NULL,
--    Quantity INT NOT NULL,
--    BillId UNIQUEIDENTIFIER,
--    ProductId UNIQUEIDENTIFIER,
--    FOREIGN KEY (BillId) REFERENCES Bill(Id),
--    FOREIGN KEY (ProductId) REFERENCES Product(Id)
--);



-- Tạo Database
IF OBJECT_ID('BanSon') IS NOT NULL
	DROP DATABASE BanSon
GO
CREATE DATABASE BanSon
GO
-- Sử dụng database
USE BanSon
GO

--Tạo bảng Thương hiệu (Brand)
IF OBJECT_ID('Brand') IS NOT NULL
	DROP TABLE Brand
GO
CREATE TABLE Brand (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(50) NOT NULL,
	Image NVARCHAR(MAX),
	Status INT NOT NULL,
);

-- Tạo bảng Sản phẩm (Product)
IF OBJECT_ID('Product') IS NOT NULL
	DROP TABLE Product
GO
CREATE TABLE Product (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(255) NOT NULL,
	AvailableQuantity INT NOT NULL,
	Sold INT NOT NULL,
	Likes INT NOT NULL,
	CreatedDate DATE NOT NULL,
	Status INT NOT NULL,
    Description NVARCHAR(MAX),
    BrandId UNIQUEIDENTIFIER,
    FOREIGN KEY (BrandId) REFERENCES Brand(Id),
);

--Tạo bảng Danh mục (Category)
IF OBJECT_ID('Category') IS NOT NULL
	DROP TABLE Category
GO
CREATE TABLE Category (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(50) NOT NULL,
	Status INT NOT NULL,
);

--Tạo bảng Chi tiết Danh mục (CategoryDetail)
IF OBJECT_ID('CategoryDetail') IS NOT NULL
	DROP TABLE CategoryDetail
GO
CREATE TABLE CategoryDetail (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Quantity INT NOT NULL,
    ProductId UNIQUEIDENTIFIER,
    CategoryId UNIQUEIDENTIFIER,
    FOREIGN KEY (ProductId) REFERENCES Product(Id),
    FOREIGN KEY (CategoryId) REFERENCES Category(Id),
);

--Tạo bảng Màu sắc (Color)
IF OBJECT_ID('Color') IS NOT NULL
	DROP TABLE Color
GO
CREATE TABLE Color (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(50) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    Image NVARCHAR(MAX) NOT NULL,
	Status INT NOT NULL,
    BrandId UNIQUEIDENTIFIER,
    FOREIGN KEY (BrandId) REFERENCES Brand(Id),
);

-- Tạo bảng Chi tiết Sản phẩm (ProductDetail)
IF OBJECT_ID('ProductDetail') IS NOT NULL
	DROP TABLE ProductDetail
GO
CREATE TABLE ProductDetail (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ImportPrice DECIMAL(10, 2) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
	Quantity INT NOT NULL,
	CreatedDate DATE NOT NULL,
	Status INT NOT NULL,
    Description NVARCHAR(MAX),
    ProductId UNIQUEIDENTIFIER,
    ColorId UNIQUEIDENTIFIER,
    FOREIGN KEY (ProductId) REFERENCES Product(Id),
    FOREIGN KEY (ColorId) REFERENCES Color(Id),
);

-- Tạo bảng Hình ảnh Sản phẩm (ProductImage)
IF OBJECT_ID('ProductImage') IS NOT NULL
	DROP TABLE ProductImage
GO
CREATE TABLE ProductImage (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(MAX) NOT NULL,
	Status INT NOT NULL,
    ProductDetailId UNIQUEIDENTIFIER,
    FOREIGN KEY (ProductDetailId) REFERENCES ProductDetail(Id),
);

-- Tạo bảng Khách hàng (Customer)
IF OBJECT_ID('Customer') IS NOT NULL
	DROP TABLE Customer
GO
CREATE TABLE Customer (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    FullName NVARCHAR(100) NOT NULL,
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
	Gender INT NOT NULL,
    PhoneNumber NVARCHAR(15) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    DateOfBirth DATE NOT NULL,
	CreatedDate DATE NOT NULL, 
    Address NVARCHAR(MAX),
    Status INT NOT NULL,
);

-- Tạo bảng Danh sách Yêu Thích (WishList)
IF OBJECT_ID('WishList') IS NOT NULL
	DROP TABLE WishList
GO
CREATE TABLE WishList (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ProductId UNIQUEIDENTIFIER,
    CustomerId UNIQUEIDENTIFIER,
    FOREIGN KEY (ProductId) REFERENCES Product(Id),
    FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
);

-- Tạo bảng Giỏ hàng (Cart)
IF OBJECT_ID('Cart') IS NOT NULL
	DROP TABLE Cart
GO
CREATE TABLE Cart (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Quantity INT NOT NULL,
    TotalMoney DECIMAL(10, 2) NOT NULL,
	Status INT NOT NULL,
    CustomerId UNIQUEIDENTIFIER,
    FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
);

-- Tạo bảng Chi tiết Giỏ hàng (CartDetail)
IF OBJECT_ID('CartDetail') IS NOT NULL
	DROP TABLE CartDetail
GO
CREATE TABLE CartDetail (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    CustomerId UNIQUEIDENTIFIER,
    ProductDetailId UNIQUEIDENTIFIER,
    FOREIGN KEY (CustomerId) REFERENCES Cart(Id),
    FOREIGN KEY (ProductDetailId) REFERENCES ProductDetail(Id),
);

-- Tạo bảng Chức vụ (Role)
IF OBJECT_ID('Role') IS NOT NULL
	DROP TABLE Role
GO
CREATE TABLE Role (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(30) NOT NULL,
    Status INT NOT NULL,
);

-- Tạo bảng  (Employee)
IF OBJECT_ID('Employee') IS NOT NULL
	DROP TABLE Employee
GO
CREATE TABLE Employee (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    FullName NVARCHAR(100) NOT NULL,
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
	Gender INT NOT NULL,
    PhoneNumber NVARCHAR(15) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Image NVARCHAR(MAX),
    DateOfBirth DATE NOT NULL,
	CreatedDate DATE NOT NULL, 
    Address NVARCHAR(MAX),
	Status INT NOT NULL,
	RoleId UNIQUEIDENTIFIER,
	FOREIGN KEY (RoleId) REFERENCES Role(Id),
);

-- Tạo bảng Trạng thái Hóa Đơn (BillStatus)
IF OBJECT_ID('BillStatus') IS NOT NULL
	DROP TABLE BillStatus
GO
CREATE TABLE BillStatus (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(50) NOT NULL,
	Status INT NOT NULL
);

-- Tạo bảng Phương thức thanh toán (Payment)
IF OBJECT_ID('Payment') IS NOT NULL
	DROP TABLE Payment
GO
CREATE TABLE Payment (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Name NVARCHAR(50) NOT NULL,
	Status INT NOT NULL
);

-- Tạo bảng Hóa Đơn (Bill)
IF OBJECT_ID('Bill') IS NOT NULL
	DROP TABLE Bill
GO
CREATE TABLE Bill (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ReceiverName NVARCHAR(100) NOT NULL,
	TotalMoney DECIMAL(10, 2) NOT NULL,
    CustomerPhone NVARCHAR(50) NOT NULL,
	AddressDelivery NVARCHAR(100) NOT NULL,
    CreatedDate DATE NOT NULL,
    BillStatusId UNIQUEIDENTIFIER,
    PaymentId UNIQUEIDENTIFIER,
	EmployeeId UNIQUEIDENTIFIER,
    CustomerId UNIQUEIDENTIFIER,
    FOREIGN KEY (BillStatusId) REFERENCES BillStatus(Id),
    FOREIGN KEY (PaymentId) REFERENCES Payment(Id),
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id),
    FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
);

-- Tạo bảng Chi tiết Hóa Đơn (BillDetail)
IF OBJECT_ID('BillDetail') IS NOT NULL
	DROP TABLE BillDetail
GO
CREATE TABLE BillDetail (
    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    Quantity INT NOT NULL,
	Price DECIMAL(10, 2) NOT NULL,
    BillId UNIQUEIDENTIFIER,
    ProductDetailId UNIQUEIDENTIFIER,
    FOREIGN KEY (BillId) REFERENCES Bill(Id),
    FOREIGN KEY (ProductDetailId) REFERENCES ProductDetail(Id),
);

--Nhập liệu các bảng

--Nhập dữ liệu bảng Thương hiệu (Brand)
INSERT INTO Brand VALUES
('15333be6-0d95-4b7c-b0e9-ee00c5110101', 'M.A.C', 'mac.png', 0),
('15333be6-0d95-4b7c-b0e9-ee00c5110102', '3CE', '3ce.png', 0),
('15333be6-0d95-4b7c-b0e9-ee00c5110103', 'Dior', 'dior.jpg', 0),
('15333be6-0d95-4b7c-b0e9-ee00c5110104', 'Bobbi Brown', 'bobbi_brown.png', 0),
('15333be6-0d95-4b7c-b0e9-ee00c5110105', 'Black Rouge', 'Black_Rouge.png', 0),
('15333be6-0d95-4b7c-b0e9-ee00c5110106', 'Maybelline', 'MAYBELLINE.png', 0)
GO

--Nhập dữ liệu bảng Sản phẩm (Product)
INSERT INTO Product VALUES
('67357ae4-342e-4673-b80f-1f1d1f030c0c', 'MATTE LIPSTICK', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110101'),
('67357ae4-342e-4673-b80f-1f1d1f020c0c', 'MILK TEA VELVET TINT', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110102'),
('67357ae4-342e-4673-b80f-1f1d1f010c0c', 'ROUGE DIOR', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110103'),
('67357ae4-342e-4673-b80f-1f1d1f000c0c', 'Crushed Oil-Infused Gloss', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110104'),
('67357ae4-342e-4673-b80f-1f1d1f070c0c', 'Black Rouge Air Fit Velvet Tint Ver 9 Acoustic Mood', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110105'),
('67357ae4-342e-4673-b80f-1f1d1f080c0c', 'Color Sensational Made For All Lipstick', 100, 0, 0, '09/10/2023', 0, '', '15333be6-0d95-4b7c-b0e9-ee00c5110106')
GO

--Nhập dữ liệu bảng Danh mục (Category)
INSERT INTO Category VALUES
('67357ae4-342e-4673-b80f-1f1d1f068c9c', 'Creame Lipstick', 0),
('67357ae4-342e-4673-b80f-1f1d1f068c0c', 'Lip tint', 0),
('67357ae4-342e-4673-b80f-1f1d1f069c0c', 'Matte Lipstick', 0),
('67357ae4-342e-4673-b80f-1f1d1f067c0c', 'Lip Gross', 0),
('67357ae4-342e-4673-b80f-1f1d1f066c0c', 'Lip Balm', 0),
('67357ae4-342e-4673-b80f-1f1d1f065c0c', 'Pearly/frost lipstick', 0),
('67357ae4-342e-4673-b80f-1f1d1f064c0c', 'Son Satin', 0),
('67357ae4-342e-4673-b80f-1f1d1f063c0c', 'Son Sheer', 0)
GO

--Nhập dữ liệu bảng Chi tiết Danh mục (CategoryDetail)
INSERT INTO CategoryDetail VALUES
('653ef875-5059-486e-b13d-2cc1b2a78ae1', 1, '67357ae4-342e-4673-b80f-1f1d1f030c0c', '67357ae4-342e-4673-b80f-1f1d1f068c9c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae2', 2, '67357ae4-342e-4673-b80f-1f1d1f020c0c', '67357ae4-342e-4673-b80f-1f1d1f068c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae3', 2, '67357ae4-342e-4673-b80f-1f1d1f010c0c', '67357ae4-342e-4673-b80f-1f1d1f069c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae4', 1, '67357ae4-342e-4673-b80f-1f1d1f010c0c', '67357ae4-342e-4673-b80f-1f1d1f064c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae5', 1, '67357ae4-342e-4673-b80f-1f1d1f000c0c', '67357ae4-342e-4673-b80f-1f1d1f067c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae6', 2, '67357ae4-342e-4673-b80f-1f1d1f070c0c', '67357ae4-342e-4673-b80f-1f1d1f068c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae7', 2, '67357ae4-342e-4673-b80f-1f1d1f080c0c', '67357ae4-342e-4673-b80f-1f1d1f064c0c'),
('653ef875-5059-486e-b13d-2cc1b2a78ae8', 2, '67357ae4-342e-4673-b80f-1f1d1f080c0c', '67357ae4-342e-4673-b80f-1f1d1f069c0c')
GO

--Nhập dữ liệu bảng Màu sắc (Color)
INSERT INTO Color VALUES
('67357ae4-342e-4673-b80f-1f1d1f062c0c', 'Sweet Deal', 2, 'MAC_Sweet_Deal.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110101'),
('67357ae4-342e-4673-b80f-1f1d1f061c0c', 'Kinda Sexy', 2, 'MAC_Kinda_Sexy.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110101'),
('67357ae4-342e-4673-b80f-1f1d1f060c0c', 'Red Rock', 2, 'MAC_Red_Rock.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110101'),
('67357ae4-342e-4673-b80f-1f1d1f050c0c', '#05 Vanilla_Tea', 2, '05_Vanilla_Tea.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110102'),
('67357ae4-342e-4673-b80f-1f1d1f040c0c', '#06 Jasmine Tea', 2, '06_Jasmine_Tea.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110102'),
('67357ae4-342e-4673-b80f-1f1d1f000c0c', '520 Feel Good satin finish', 2, '520_Feel_Good_satin_finish.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110103'),
('67357ae4-342e-4673-b80f-1f1d2f000c0c', '080 Red Smile satin finish', 2, '080_Red_Smile_satin_finish.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110103'),
('67357ae4-342e-4673-b80f-1f1d3f000c0c', 'Free Spirit', 2, 'Bobbi_Brown_Free_Spirit.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110104'),
('67357ae4-342e-4673-b80f-1f1d4f000c0c', 'Force of Nature', 2, 'Bobbi_Brown_Force_of_Nature.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110104'),
('67357ae4-342e-4673-b80f-1f1d5f000c0c', 'A46', 2, 'Black_Rouge_A46.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110105'),
('67357ae4-342e-4673-b80f-1f1d6f000c0c', 'A47', 2, 'Black_Rouge_A46.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110105'),
('67357ae4-342e-4673-b80f-1f1d7f000c0c', 'Ruby', 2, 'Maybelline_Ruby.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110106'),
('67357ae4-342e-4673-b80f-1f1d8f000c0c', 'Red', 2, 'Maybelline_Red.png', 0, '15333be6-0d95-4b7c-b0e9-ee00c5110106')
GO

--Nhập dữ liệu bảng Chi tiết Sản phẩm (ProductDetail)
INSERT INTO ProductDetail VALUES
('f548c39d-d212-45c3-b191-a2a80f8d9d1b', 20, 23, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f030c0c', '67357ae4-342e-4673-b80f-1f1d1f062c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d2b', 20, 23, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f030c0c', '67357ae4-342e-4673-b80f-1f1d1f061c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d3b', 20, 23, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f030c0c', '67357ae4-342e-4673-b80f-1f1d1f060c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d4b', 15, 18, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f020c0c', '67357ae4-342e-4673-b80f-1f1d1f050c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d5b', 15, 18, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f020c0c', '67357ae4-342e-4673-b80f-1f1d1f040c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d6b', 15, 20, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f010c0c', '67357ae4-342e-4673-b80f-1f1d1f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d7b', 15, 20, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f010c0c', '67357ae4-342e-4673-b80f-1f1d2f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d8b', 25, 33, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f000c0c', '67357ae4-342e-4673-b80f-1f1d3f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d9b', 25, 33, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f000c0c', '67357ae4-342e-4673-b80f-1f1d4f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d9d0b', 10, 12, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f070c0c', '67357ae4-342e-4673-b80f-1f1d5f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d8d0b', 10, 12, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f070c0c', '67357ae4-342e-4673-b80f-1f1d6f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d7d0b', 5, 8, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f080c0c', '67357ae4-342e-4673-b80f-1f1d7f000c0c'),
('f548c39d-d212-45c3-b191-a2a80f8d6d0b', 5, 8, 0, '09/10/2023', 0, '', '67357ae4-342e-4673-b80f-1f1d1f080c0c', '67357ae4-342e-4673-b80f-1f1d8f000c0c')
GO

--Nhập dữ liệu bảng Hình ảnh Sản phẩm (ProductImage)
INSERT INTO ProductImage VALUES
('c823ef0b-8047-4713-b76a-66340c095221', 'MATTE_LIPSTICK1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d1b'),
('c823ef0b-8047-4713-b76a-66340c095222', 'MATTE_LIPSTICK2.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d1b'),
('c823ef0b-8047-4713-b76a-66340c095223', 'MATTE_LIPSTICK3.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d1b'),
('c823ef0b-8047-4713-b76a-66340c095224', 'MATTE_LIPSTICK3.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d2b'),
('c823ef0b-8047-4713-b76a-66340c095225', 'MATTE_LIPSTICK4.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d2b'),
('c823ef0b-8047-4713-b76a-66340c095226', 'MATTE_LIPSTICK5.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d2b'),
('c823ef0b-8047-4713-b76a-66340c095227', 'MATTE_LIPSTICK3.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d3b'),
('c823ef0b-8047-4713-b76a-66340c095228', 'MATTE_LIPSTICK6.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d3b'),
('c823ef0b-8047-4713-b76a-66340c095229', 'MATTE_LIPSTICK7.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d3b'),
('c823ef0b-8047-4713-b76a-66340c095240', 'Vanilla_Tea.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d4b'),
('c823ef0b-8047-4713-b76a-66340c095250', 'Jasmine_Tea.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d5b'),
('c823ef0b-8047-4713-b76a-66340c095260', 'Crushed_Oil_Infused_Gloss.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d8b'),
('c823ef0b-8047-4713-b76a-66340c095270', 'Free_Spirit1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d8b'),
('c823ef0b-8047-4713-b76a-66340c095280', 'Free_Spirit2.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d8b'),
('c823ef0b-8047-4713-b76a-66340c095290', 'Crushed_Oil_Infused_Gloss.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d9b'),
('c823ef0b-8047-4713-b76a-66340c095100', 'a46.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d0b'),
('c823ef0b-8047-4713-b76a-66340c095200', 'a47.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d8d0b'),
('c823ef0b-8047-4713-b76a-66340c095300', 'maybelline_lipstick_color_sensational_made_for_all_ruby1.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d7d0b'),
('c823ef0b-8047-4713-b76a-66340c095400', 'maybelline_lipstick_color_sensational_made_for_all_ruby2.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d7d0b'),
('c823ef0b-8047-4713-b76a-66340c095500', 'Romand_Milk_Tea_Velvet_Tint_Vanilla_Tea.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d4b'),
('c823ef0b-8047-4713-b76a-66340c095600', 'Romand_Milk_Tea_Velvet_Tint_Vanilla_Tea1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d4b'),
('c823ef0b-8047-4713-b76a-66340c095700', 'Romand_Milk_Tea_Velvet_Tint_Jasmine_Tea.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d5b'),
('c823ef0b-8047-4713-b76a-66340c095800', 'Romand_Milk_Tea_Velvet_Tint_Jasmine_Tea1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d5b'),
('c823ef0b-8047-4713-b76a-66340c095900', '520_Feel_Good_satin_finish1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d6b'),
('c823ef0b-8047-4713-b76a-66340c091000', '520_Feel_Good_satin_finish2.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d6b'),
('c823ef0b-8047-4713-b76a-66340c092000', '520_Feel_Good_satin_finish3.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d6b'),
('c823ef0b-8047-4713-b76a-66340c093000', '080_Red_Smile_satin_finish1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d7b'),
('c823ef0b-8047-4713-b76a-66340c094000', '080_Red_Smile_satin_finish2.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d7b'),
('c823ef0b-8047-4713-b76a-66340c095000', '080_Red_Smile_satin_finish3.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d7b'),
('c823ef0b-8047-4713-b76a-66340c096000', 'Force_of_Nature1.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d9b'),
('c823ef0b-8047-4713-b76a-66340c097000', 'Force_of_Nature2.png', 0, 'f548c39d-d212-45c3-b191-a2a80f8d9d9b'),
('c823ef0b-8047-4713-b76a-66340c098000', 'maybelline_lipstick_color_sensational_made_for_all_ruby3.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d7d0b'),
('c823ef0b-8047-4713-b76a-66340c099000', 'maybelline_lipstick_color_sensational_made_for_all_ruby4.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d7d0b'),
('c823ef0b-8047-4713-b76a-66340c090000', 'maybelline_lipstick_color_sensational_made_for_all_ruby3.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d6d0b'),
('c823ef0b-8047-4713-b76a-66340c080000', 'maybelline_lipstick_color_sensational_made_for_all_ruby4.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d6d0b'),
('c823ef0b-8047-4713-b76a-66340c070000', 'maybelline_lipstick_color_sensational_made_for_all_red1.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d6d0b'),
('c823ef0b-8047-4713-b76a-66340c060000', 'maybelline_lipstick_color_sensational_made_for_all_red2.jpg', 0, 'f548c39d-d212-45c3-b191-a2a80f8d6d0b')
GO

--Nhập dữ liệu bảng Người dùng (Customer)
INSERT INTO Customer VALUES
('67357ae4-342e-4673-b80f-1f1d1f068c5c', 'Luc Minh Quan', 'quanlm', '123456', 0, '0987654323', 'quanlm@gmail.com', '01/01/2003', '09/10/2023', 'Hanoi', 0),
('67357ae4-342e-4673-b80f-1f1d1f068c6c', 'Luc Van Quan', 'quanlv', '123456', 0, '0987654324', 'quanlv@gmail.com', '01/01/2003', '09/10/2023', 'Hanoi', 0)
GO

--Nhập dữ liệu bảng Danh sách Yêu Thích (WishList)
INSERT INTO WishList VALUES
('6d95a8ae-1e83-4c7d-a813-a5a3640bc711', '67357ae4-342e-4673-b80f-1f1d1f030c0c', '67357ae4-342e-4673-b80f-1f1d1f068c5c'),
('6d95a8ae-1e83-4c7d-a813-a5a3640bc712', '67357ae4-342e-4673-b80f-1f1d1f070c0c', '67357ae4-342e-4673-b80f-1f1d1f068c5c'),
('6d95a8ae-1e83-4c7d-a813-a5a3640bc713', '67357ae4-342e-4673-b80f-1f1d1f020c0c', '67357ae4-342e-4673-b80f-1f1d1f068c6c'),
('6d95a8ae-1e83-4c7d-a813-a5a3640bc714', '67357ae4-342e-4673-b80f-1f1d1f010c0c', '67357ae4-342e-4673-b80f-1f1d1f068c6c'),
('6d95a8ae-1e83-4c7d-a813-a5a3640bc715', '67357ae4-342e-4673-b80f-1f1d1f000c0c', '67357ae4-342e-4673-b80f-1f1d1f068c6c')
GO

--Nhập dữ liệu bảng Giỏ hàng (Cart)
INSERT INTO Cart VALUES
('67357ae4-342e-4673-b80f-1f1d1f068c5c', 3, 71, 0, '67357ae4-342e-4673-b80f-1f1d1f068c5c'),
('67357ae4-342e-4673-b80f-1f1d1f068c6c', 2, 31, 0, '67357ae4-342e-4673-b80f-1f1d1f068c6c')
GO

--Nhập dữ liệu bảng Chi Tiết Giỏ hàng (CartDetail)
INSERT INTO CartDetail VALUES
('6109da61-a526-4776-a82c-3dec24717b1a', 1, 18, '67357ae4-342e-4673-b80f-1f1d1f068c5c', 'f548c39d-d212-45c3-b191-a2a80f8d9d4b'),
('6109da61-a526-4776-a82c-3dec24717b2a', 1, 20, '67357ae4-342e-4673-b80f-1f1d1f068c5c', 'f548c39d-d212-45c3-b191-a2a80f8d9d6b'),
('6109da61-a526-4776-a82c-3dec24717b3a', 1, 33, '67357ae4-342e-4673-b80f-1f1d1f068c5c', 'f548c39d-d212-45c3-b191-a2a80f8d9d9b'),
('6109da61-a526-4776-a82c-3dec24717b4a', 1, 23, '67357ae4-342e-4673-b80f-1f1d1f068c6c', 'f548c39d-d212-45c3-b191-a2a80f8d9d1b'),
('6109da61-a526-4776-a82c-3dec24717b5a', 1, 8, '67357ae4-342e-4673-b80f-1f1d1f068c6c', 'f548c39d-d212-45c3-b191-a2a80f8d7d0b')
GO

--Nhập dữ liệu bảng Chức vụ (Role)
INSERT INTO Role VALUES
('67357ae4-342e-4673-b80f-1f1d1f068c1c', 'Staff', 0),
('67357ae4-342e-4673-b80f-1f1d1f068c2c', 'Manage', 0)
GO

--Nhập dữ liệu bảng  (Employee)
INSERT INTO Employee VALUES
('9c7cf1ed-8f0a-44c3-8dc1-a652a37c0279', 'Hoang Thanh Tung', 'tunght', '123456', 0, '0987654321', 'tunght@gmail.com', 'avatar1.png', '01/01/2003', '09/10/2023', 'Hanoi', 0, '67357ae4-342e-4673-b80f-1f1d1f068c1c'),
('9c7cf1ed-8f0a-44c3-8dc1-a652a37c0278', 'Hoang Van Tung', 'tunghv', '123456', 0, '0987654322', 'tunghv@gmail.com', 'avatar2.png', '01/01/2003', '09/10/2023', 'Hanoi', 0, '67357ae4-342e-4673-b80f-1f1d1f068c2c')
GO

--Nhập dữ liệu bảng Trạng thái hóa đơn (BillStatus)
INSERT INTO BillStatus VALUES
('159b8bc3-5489-47c0-a115-b94a0cf6286f', 'Confirmed', 0),
('259b8bc3-5489-47c0-a115-b94a0cf6286f', 'Unconfirmed', 0)
GO

--Nhập dữ liệu bảng Phương thức thanh toán (Payment)
INSERT INTO Payment VALUES
('1f7fbcf3-3007-4180-a5fe-84d2bcdf171b', 'Bank transfer', 0),
('2f7fbcf3-3007-4180-a5fe-84d2bcdf171b', 'Ship (COD)', 0)
GO

--Nhập dữ liệu bảng Hóa đơn (Bill)
INSERT INTO Bill VALUES
('126195bb-2b4f-4a91-ab4f-0acf00306616', 'Luc Minh Quan', 28, '0987654323', 'Hanoi', '10/09/2023', '159b8bc3-5489-47c0-a115-b94a0cf6286f', '2f7fbcf3-3007-4180-a5fe-84d2bcdf171b', '9c7cf1ed-8f0a-44c3-8dc1-a652a37c0279', '67357ae4-342e-4673-b80f-1f1d1f068c5c'),
('226195bb-2b4f-4a91-ab4f-0acf00306616', 'Luc Van Quan', 28, '0987654323', 'Hanoi', '10/09/2023', '159b8bc3-5489-47c0-a115-b94a0cf6286f', '2f7fbcf3-3007-4180-a5fe-84d2bcdf171b', '9c7cf1ed-8f0a-44c3-8dc1-a652a37c0278', '67357ae4-342e-4673-b80f-1f1d1f068c6c')
GO

--Nhập dữ liệu bảng Chi tiết Hóa đơn (BillDetail)
INSERT INTO BillDetail VALUES
('ada72d63-1447-4d82-bb84-d6b0103c7238', 1, 20, '126195bb-2b4f-4a91-ab4f-0acf00306616', 'f548c39d-d212-45c3-b191-a2a80f8d9d6b'),
('ada72d63-1447-4d82-bb84-d6b0103c7239', 1, 8, '126195bb-2b4f-4a91-ab4f-0acf00306616', 'f548c39d-d212-45c3-b191-a2a80f8d6d0b'),
('ada72d63-1447-4d82-bb84-d6b0103c7237', 1, 20, '226195bb-2b4f-4a91-ab4f-0acf00306616', 'f548c39d-d212-45c3-b191-a2a80f8d9d7b'),
('ada72d63-1447-4d82-bb84-d6b0103c7236', 1, 8, '226195bb-2b4f-4a91-ab4f-0acf00306616', 'f548c39d-d212-45c3-b191-a2a80f8d7d0b')
GO
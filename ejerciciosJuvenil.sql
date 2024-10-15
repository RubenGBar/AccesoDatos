Use PracticaJuvenil

/*Ejercicio 1*/

	Create or alter Procedure librosPrestados as
	Begin

	Declare @nombreLibro as varchar(30), @generoLibro as varchar(10), @dniSocio as varchar(10), @fechaPrestamo as date, @numPrestamos as int, @refLibro as varchar(10)

	Declare cursorLibros Cursor For
	Select Top 4 l.Nombre, COUNT(p.RefLibro) as prestamos, l.RefLibro, l.Genero From libros as l
	Join prestamos as p on l.RefLibro = p.RefLibro
	Group by l.Nombre, l.RefLibro, l.Genero
	Order by COUNT(p.RefLibro) desc

	Open cursorLibros
	Fetch cursorLibros into @nombreLibro, @numPrestamos, @refLibro, @generoLibro

	while(@@FETCH_STATUS = 0)
	Begin
		
		Print Cast(@nombreLibro as varchar(100)) + ' - Prestamos: ' + Cast(@numPrestamos as varchar(100)) + ' - ' + Cast(@generoLibro as varchar(100))

		Declare cursorPrestamos Cursor For
		Select p.Dni, p.FechaPrestamo From prestamos as p
		Where p.RefLibro = @refLibro
		Order by p.RefLibro desc

		Open cursorPrestamos
		Fetch cursorPrestamos into @dniSocio, @fechaPrestamo

		while(@@FETCH_STATUS = 0)
		Begin
			
			Print @dniSocio + ' - ' + Cast(@fechaPrestamo as varchar(100))

			Fetch cursorPrestamos into @dniSocio, @fechaPrestamo

		End

		Close cursorPrestamos
		Deallocate cursorPrestamos

		Print '--------------------------------------------------------------'
		Fetch cursorLibros into @nombreLibro, @numPrestamos, @refLibro, @generoLibro

	End

	Close cursorLibros
	Deallocate cursorLibros

	End

	Execute librosPrestados

/*Ejercicio 2*/

Create Database Alumnos

Use ALumnos

IF OBJECT_ID('dbo.ALUMNOS', 'U') IS NOT NULL
    DROP TABLE dbo.ALUMNOS;

IF OBJECT_ID('dbo.ASIGNATURAS', 'U') IS NOT NULL
    DROP TABLE dbo.ASIGNATURAS;

IF OBJECT_ID('dbo.NOTAS', 'U') IS NOT NULL
    DROP TABLE dbo.NOTAS;

-- Crear tabla ALUMNOS
CREATE TABLE dbo.ALUMNOS
(
    DNI VARCHAR(10) NOT NULL PRIMARY KEY,
    APENOM VARCHAR(30),
    DIREC VARCHAR(30),
    POBLA VARCHAR(15),
    TELEF VARCHAR(10)
);

-- Crear tabla ASIGNATURAS
CREATE TABLE dbo.ASIGNATURAS
(
    COD INT NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(25)
);

-- Crear tabla NOTAS
CREATE TABLE dbo.NOTAS
(
    DNI VARCHAR(10) NOT NULL,
    COD INT NOT NULL,
    NOTA INT,
    FOREIGN KEY (DNI) REFERENCES dbo.ALUMNOS(DNI),
    FOREIGN KEY (COD) REFERENCES dbo.ASIGNATURAS(COD)
);

-- Insertar datos en ASIGNATURAS
INSERT INTO dbo.ASIGNATURAS (COD, NOMBRE) VALUES
(1, 'Prog. Leng. Estr.'),
(2, 'Sist. Informáticos'),
(3, 'Análisis'),
(4, 'FOL'),
(5, 'RET'),
(6, 'Entornos Gráficos'),
(7, 'Aplic. Entornos 4ªGen');

-- Insertar datos en ALUMNOS
INSERT INTO dbo.ALUMNOS (DNI, APENOM, DIREC, POBLA, TELEF) VALUES
('12344345', 'Alcalde García, Elena', 'C/Las Matas, 24', 'Madrid', '917766545'),
('4448242', 'Cerrato Vela, Luis', 'C/Mina 28 - 3A', 'Madrid', '916566545'),
('56882942', 'Díaz Fernández, María', 'C/Luis Vives 25', 'Móstoles', '915577545');

-- Insertar datos en NOTAS
INSERT INTO dbo.NOTAS (DNI, COD, NOTA) VALUES
('12344345', 1, 6),
('12344345', 2, 5),
('12344345', 3, 6),
('4448242', 4, 6),
('4448242', 5, 8),
('4448242', 6, 4),
('4448242', 7, 5),
('56882942', 5, 7),
('56882942', 6, 8),
('56882942', 7, 9);

	Use ALumnos

	Create or alter Procedure insti(@nombreModulo varchar(100)) as
	Begin

	DECLARE @apenom varchar(40),
    @nota smallint,
    @suspensos smallint,
    @aprobado smallint,
    @suspenso smallint,
    @notable smallint,
    @sobresaliente smallint,
    @minima smallint,
    @maxima smallint

    SET @suspensos = 0
    SET @aprobado = 0
    SET @suspenso = 0
    SET @notable = 0
    SET @sobresaliente = 0
    SET @minima = 10
    SET @maxima = 0

    DECLARE cAlumnos CURSOR FOR
    SELECT APENOM, NOTA FROM NOTAS AS N
    JOIN ASIGNATURAS AS AG ON N.COD = AG.COD
    JOIN ALUMNOS AS AL ON AL.DNI = N.DNI
    WHERE NOMBRE = @nombreModulo
    GROUP BY APENOM, NOTA
   
  OPEN cAlumnos
    FETCH cAlumnos INTO @apenom, @nota

    WHILE(@@FETCH_STATUS = 0)
    BEGIN
        
        IF (@nota >= 5)
        BEGIN
            SET @aprobado += 1
            IF(@nota >= 8)
            BEGIN
                SET @sobresaliente += 1
            END
            ELSE IF (@nota >=7)
            BEGIN
                SET @notable += 1
            END
        END
        ELSE 
        BEGIN
            SET @suspenso += 1
        END

        IF(@nota < @minima)
        BEGIN
            SET @minima = @nota
        END
        IF(@nota > @maxima)
        BEGIN
            SET @maxima = @nota
        END

        PRINT CONCAT (@apenom, ' - ', @nota)
        
        FETCH cAlumnos INTO @apenom, @nota
    END

        PRINT CONCAT ('Suspensos: ', @suspenso)
        PRINT CONCAT ('Aprobados: ', @aprobado)
        PRINT CONCAT ('Notables: ', @notable)
        PRINT CONCAT ('Sobresaliente: ', @sobresaliente)
        PRINT CONCAT ('Máxima: ', @maxima)
        PRINT CONCAT ('Mínima: ', @minima)

    CLOSE cAlumnos
    DEALLOCATE cAlumnos
	END

EXECUTE insti @nombreModulo = 'Entornos Gráficos'

Use ALumnos

/*Ejercicio 3*/

Create Database tienda

Use tienda

DROP TABLE productos;

CREATE TABLE productos
(
	CodProducto 	VARCHAR(10) CONSTRAINT p_cod_no_nulo NOT NULL,
	Nombre    	VARCHAR(20) CONSTRAINT p_nom_no_nulo NOT NULL,
	LineaProducto	VARCHAR(10),
	PrecioUnitario	int,
	Stock 		int,
	PRIMARY KEY (CodProducto)
);

DROP TABLE ventas;

CREATE TABLE ventas
(
	CodVenta  		VARCHAR(10) CONSTRAINT cod_no_nula NOT NULL,
	CodProducto 		VARCHAR(10) CONSTRAINT pro_no_nulo NOT NULL,
	FechaVenta 		DATE,
	UnidadesVendidas	int,
	PRIMARY KEY (CodVenta)
);

INSERT INTO productos VALUES ('1','Procesador P133', 'Proc',15000,20);
INSERT INTO productos VALUES ('2','Placa base VX',   'PB',  18000,15);
INSERT INTO productos VALUES ('3','Simm EDO 16Mb',   'Memo', 7000,30);
INSERT INTO productos VALUES ('4','Disco SCSI 4Gb',  'Disc',38000, 5);
INSERT INTO productos VALUES ('5','Procesador K6-2', 'Proc',18500,10);
INSERT INTO productos VALUES ('6','Disco IDE 2.5Gb', 'Disc',20000,25);
INSERT INTO productos VALUES ('7','Procesador MMX',  'Proc',15000, 5);
INSERT INTO productos VALUES ('8','Placa Base Atlas','PB',  12000, 3);
INSERT INTO productos VALUES ('9','DIMM SDRAM 32Mb', 'Memo',17000,12);
 
INSERT INTO ventas VALUES('V1', '2', '22/09/97',2);
INSERT INTO ventas VALUES('V2', '4', '22/09/97',1);
INSERT INTO ventas VALUES('V3', '6', '23/09/97',3);
INSERT INTO ventas VALUES('V4', '5', '26/09/97',5);
INSERT INTO ventas VALUES('V5', '9', '28/09/97',3);
INSERT INTO ventas VALUES('V6', '4', '28/09/97',1);
INSERT INTO ventas VALUES('V7', '6', '02/10/97',2);
INSERT INTO ventas VALUES('V8', '6', '02/10/97',1);
INSERT INTO ventas VALUES('V9', '2', '04/10/97',4);
INSERT INTO ventas VALUES('V10','9', '04/10/97',4);
INSERT INTO ventas VALUES('V11','6', '05/10/97',2);
INSERT INTO ventas VALUES('V12','7', '07/10/97',1);
INSERT INTO ventas VALUES('V13','4', '10/10/97',3);
INSERT INTO ventas VALUES('V14','4', '16/10/97',2);
INSERT INTO ventas VALUES('V15','3', '18/10/97',3);
INSERT INTO ventas VALUES('V16','4', '18/10/97',5);
INSERT INTO ventas VALUES('V17','6', '22/10/97',2);
INSERT INTO ventas VALUES('V18','6', '02/11/97',2);
INSERT INTO ventas VALUES('V19','2', '04/11/97',3);
INSERT INTO ventas VALUES('V20','9', '04/12/97',3);

Select * From productos
Select * From ventas

/*Apartado A1*/

Create or Alter Procedure actualizaStock As
Begin

Declare @codProducto as varchar(10) = 0

DECLARE cProductos CURSOR FOR
Select CodProducto From productos as p

Open cProductos
Fetch cProductos into @codProducto

	while(@@FETCH_STATUS = 0)
	Begin

		Update Productos
		Set Stock = Stock - (Select ISNULL(SUM(UnidadesVendidas), 0) From ventas Where @codProducto = CodProducto)
		Where @codProducto = CodProducto

		Fetch cProductos into @codProducto

	End


Close cProductos
Deallocate cProductos

End

Execute actualizaStock

Select * From productos
Select * From ventas

Begin Transaction 
RollBack

/*Segundo Intento*/

Create or Alter Procedure actualizaStock2 As
Begin

Declare @codProducto as varchar(10) = 0, @codVenta as varchar(10) = 0

DECLARE cVentas CURSOR FOR
Select CodProducto, CodVenta From ventas 

Open cVentas
Fetch cVentas into @codProducto, @codVenta

	while(@@FETCH_STATUS = 0)
	Begin

		if((Select Stock From productos where @codProducto = CodProducto) > (Select ISNULL(UnidadesVendidas, 0) From ventas where @codVenta = CodVenta))
		Begin
			Update Productos
			Set Stock = Stock - (Select ISNULL(UnidadesVendidas, 0) From ventas where @codVenta = CodVenta)
			Where @codProducto = CodProducto
		End

		Fetch cVentas into @codProducto, @codVenta

	End


Close cVentas
Deallocate cVentas

End

Execute actualizaStock2

Select * From productos
Select * From ventas

Begin Transaction 
RollBack

/*Apartado A2*/

Create Trigger aumentoUnidades
On Ventas
After Update
As
Begin

	if((Select stock From productos) > (Select (p.stock - i.UnidadesVendidas) From productos as p inner join inserted as i on p.CodProducto = i.CodProducto))
	Begin 

		Update productos 
		Set Stock = Stock - i.UnidadesVendidas From productos as p 
		Inner Join inserted as i on p.CodProducto = i.CodProducto
	
	End
	Else
	Begin

		Update productos 
		Set Stock = Stock + i.UnidadesVendidas From productos as p 
		Inner Join inserted as i on p.CodProducto = i.CodProducto

		 DELETE FROM Ventas
		WHERE CodVenta IN (
        SELECT I.CodVenta
        FROM Inserted AS I
        JOIN Deleted AS D ON I.CodVenta = D.CodVenta
        WHERE I.UnidadesVendidas = 0
		)

	End

End

/*Apartado B*/
Select * From productos
Select * From ventas

Create or Alter procedure lineaProductos as
Begin

Declare @lineaProducto as varchar(10), @codProducto as varchar(10), @unidadesTotales as int, @importeTotalProducto as int = 0, @importeTotalLinea as int = 0, @precio as int = 0, @totalVentas as int = 0

Declare cLineaProductos Cursor For
Select LineaProducto From productos group by LineaProducto

Open cLineaProductos
Fetch cLineaProductos into @lineaProducto

While(@@FETCH_STATUS = 0)
Begin
	
	set @importeTotalLinea = 0

	Print(Concat('Linea Producto: ', @lineaProducto))

	Declare cProductos Cursor For
	Select CodProducto From productos Where LineaProducto = @lineaProducto

	Open cProductos
	Fetch cProductos into @codProducto 

	While(@@FETCH_STATUS = 0)
	Begin
		
		Set @importeTotalProducto = 0

		Set @unidadesTotales = (
		Select ISNULL(sum(UnidadesVendidas), 0) From ventas Where CodProducto = @codProducto
		)

		Set @precio = (
		Select PrecioUnitario From productos Where CodProducto = @codProducto
		)

		Set @importeTotalProducto = (
		SUM(@unidadesTotales*@precio)
		)

		Print(Concat('	', @codProducto,'	',@unidadesTotales,'	',@importeTotalProducto))

		
		if(@importeTotalProducto > 0)
		Begin
			
			Set @importeTotalLinea = @importeTotalLinea+@importeTotalProducto

		End

		Fetch cProductos into @codProducto

	End
	
	Close cProductos
	Deallocate cProductos

	Print(Concat('Importe Total ', @lineaProducto,' : ',@importeTotalLinea))
	Print('-------------------------------------------------------------------')

	Fetch cLineaProductos into @lineaProducto

	Set @totalVentas = SUM(@totalVentas+@importeTotalLinea)

End

Close cLineaProductos
Deallocate cLineaProductos

Print(Concat('Total Ventas: ', @totalVentas))

End

Execute lineaProductos
Use SCOTT

/*Ejercicio 1
Haz una función llamada DevolverCodDept que reciba el nombre de un departamento y devuelva su código.
*/

	Create or Alter Function DevolverCodDept (@nombreDep varchar(50))
	Returns smallint
		Begin

		Declare @cod smallint

		Set @cod = (Select DEPTNO From DEPT Where DNAME = @nombreDep)

		Return @cod

		End

	Select dbo.DevolverCodDept ('RESEARCH') as 'Código Departamento'

/*Ejercicio 2
Realiza un procedimiento llamado HallarNumEmp que recibiendo un nombre de departamento, 
muestre en pantalla el número de empleados de dicho departamento. 
Puedes utilizar la función creada en el ejercicio 1.
Si el departamento no tiene empleados deberá mostrar un mensaje informando de ello. 
Si el departamento no existe se tratará la excepción correspondiente.*/

	Create or alter Procedure HallarNumEmp (@nombreDep varchar(50)) As
		Begin

		Select COUNT(*) as numeroEmpleados From EMP where DEPTNO = (Select dbo.DevolverCodDept (@nombreDep) as Código)

		End

	Execute HallarNumEmp 'Sales'

/*Ejercicio 3
Realiza una función llamada CalcularCosteSalarial que reciba un nombre de departamento 
y devuelva la suma de los salarios y comisiones de los empleados de dicho departamento. Trata las excepciones que consideres necesarias.*/

Select * From EMP

	Create or alter Function CalcularCosteSalarial (@nombreDep varchar(50))
	Returns int
		Begin
		
		Declare @resul int

		Set @resul = isnull((Select Sum(SAL + ISNULL(COMM, 0)) From EMP Where DEPTNO = (Select dbo.DevolverCodDept(@nombreDep) as Código)), 0)

		return @resul

		End

	Select dbo.CalcularCosteSalarial ('Operations') as CosteSalarial

/*Ejercicio 4 CR
Realiza un procedimiento MostrarCostesSalariales que muestre los nombres de todos los departamentos y 
el coste salarial de cada uno de ellos. Puedes usar la función del ejercicio 3.*/

Select * From emp

	Create or Alter Procedure MostrarCostesSalariales As
	Begin

	Select DNAME, dbo.CalcularCosteSalarial(DNAME) as CosteSalarial From DEPT
	
	End

	Execute MostrarCostesSalariales

	-- Con cursores

	CREATE OR ALTER PROCEDURE MostrarCostesSalariales2 AS
	BEGIN
	DECLARE @nDepto VARCHAR(15)
	DECLARE @salario DECIMAL(8,2)

	DECLARE costesSalariales CURSOR FOR
	SELECT d.DNAME, dbo.CalcularCosteSalarial(DNAME) as CosteSalarial FROM DEPT d

	OPEN costesSalariales
	FETCH costesSalariales into @nDepto, @salario

	WHILE(@@FETCH_STATUS = 0)
	BEGIN
	PRINT @nDepto + ': ' + CAST(@salario AS VARCHAR(10)) + '€'

	FETCH costesSalariales into @nDepto, @salario
	END

	CLOSE costesSalariales

	DEALLOCATE costesSalariales
	END

	EXEC dbo.MostrarCostesSalariales2;

/*Ejercicio 5
Realiza un procedimiento MostrarAbreviaturas que muestre las tres primeras letras del nombre de cada empleado.*/

	Create or Alter Procedure MostrarAbreviaturas As
	Begin

	Select SUBSTRING(ENAME, 1, 3) As Abreviatura From EMP

	End

	Execute MostrarAbreviaturas 

/*Ejercicio 6 CR 
Realiza un procedimiento MostrarMasAntiguos que muestre el nombre del empleado más antiguo de cada departamento 
junto con el nombre del departamento. Trata las excepciones que consideres necesarias.*/

	Select * From DEPT
	Select * From EMP

	Create or alter Procedure mostrarMasAntiguos as
	Begin

	Declare @numDep as int, @nomDept varchar(14), @texto varchar(100)

	Declare cursorMasAntiguos Cursor For
	Select d.DEPTNO, d.DNAME From DEPT As d
	
	Open cursorMasAntiguos
	Fetch cursorMasAntiguos into @numDep, @nomDept

	While(@@FETCH_STATUS = 0)
	Begin
		
		Set @texto = (Select top 1 e.ENAME From EMP as e Where e.DEPTNO = @numDep Order By e.HIREDATE desc)
		Print 'Departamento: ' + @nomDept + ', Empleado: ' + @texto

		Fetch cursorMasAntiguos into @numDep, @nomDept

	End

	Close cursorMasAntiguos
	Deallocate cursorMasAntiguos

	End

	Execute mostrarMasAntiguos

/*Ejercicio 7 CR 
Realiza un procedimiento MostrarJefes que reciba el nombre de un departamento y 
muestre los nombres de los empleados de ese departamento que son jefes de otros empleados.
Trata las excepciones que consideres necesarias.*/



/*Ejercicio 8
Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos 
vendedores con más comisiones. Trata las excepciones que consideres necesarias.*/

Select * From EMP Order by ISNULL(COMM, 0) desc

	Create or alter Procedure MostrarMejoresVendedores as
	Begin

	Select top 2 ENAME From EMP Order by ISNULL(COMM, 0) desc

	End

	Execute MostrarMejoresVendedores

/*Ejercicio 10
Realiza un procedimiento RecortarSueldos que recorte el sueldo un 20% a los empleados 
cuyo nombre empiece por la  letra que recibe como parámetro.Trata las excepciones que consideres necesarias
*/
Select * From EMP

	
	Create or Alter Procedure RecortarSueldos(@letra char(1)) As
	Begin

	Update EMP Set SAL =  (Sal*0.8)  Where ENAME like concat(@letra, '%')

	End

	Begin Transaction
	Execute RecortarSueldos @letra = 'S'
	Rollback

/*Ejercicio 11 CR
Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada departamento. 
Trata las excepciones que consideres necesarias.*/

Select * From Emp

	Create or alter Procedure BorrarBecarios as
	Begin

	Declare @numDep as int, @nomDept varchar(14), @num int

	Declare cursorMasNuevos Cursor For
	Select d.DEPTNO From DEPT As d
	
	Open cursorMasNuevos
	Fetch cursorMasNuevos into @numDep

	While(@@FETCH_STATUS = 0)
	Begin
		
		Delete From EMP
		Where EMPNO in (Select top 2 e.EMPNO From EMP as e Where e.DEPTNO = @numDep Order By e.HIREDATE asc)

		Fetch cursorMasNuevos into @numDep

	End

	Close cursorMasNuevos
	Deallocate cursorMasNuevos

	End

	Execute BorrarBecarios
	Begin Transaction
	RollBack
	Select * From EMP
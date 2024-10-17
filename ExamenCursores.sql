Create database BecasNombreApellidoAlumno

Use BecasNombreApellidoAlumno

Create Table AlumnoSolicitante(

dni varchar(9),
nombre varchar(50),
nota decimal,
cuantia money,

Constraint pkAlumnosSolicitantes Primary Key(dni),

)

insert into AlumnoSolicitante values ('11111111A', 'Ana Albaricoque', 9.8, 150)
insert into AlumnoSolicitante values ('22222222B', 'Beatriz Blanco', 9.5, 200)
insert into AlumnoSolicitante values ('33333333C', 'Cristina Cortina', 7.6, 100)
insert into AlumnoSolicitante values ('44444444D', 'Daniel Dado', 7.6, 100)
insert into AlumnoSolicitante values ('55555555E', 'Enriqueta Espera', 6.9, 150)
insert into AlumnoSolicitante values ('66666666F', 'Federico Frio', 6.8, 50)
insert into AlumnoSolicitante values ('77777777G', 'Guillermo Gil', 6.1, 100)

Create Table AlumnosConBeca(

dni varchar(9),
nombre varchar(50),
cuantia money

Constraint fkAlumnosConBeca Foreign Key (dni) References AlumnoSolicitante,

)

Create or ALter Procedure asignarBecaRubenGarcia(@beca as money) As
Begin

	Declare @dni as varchar(9), @nombre as Varchar(50), @nota as decimal, @cuantia as money

	Declare cAlumnos cursor For
	Select dni, nombre, nota, cuantia From AlumnoSolicitante
	Order By nota desc, nombre

	Open cAlumnos
	Fetch cAlumnos into @dni, @nombre, @nota, @cuantia

	While(@@FETCH_STATUS = 0)
	Begin

		if(@beca > @cuantia)
		Begin

			Insert into AlumnosConBeca values (@dni, @nombre, @cuantia)

			Print(Concat('El alumno ', @nombre, ' ha sido agraciado con la beca: ', @cuantia))
			Print('')

			Set @beca = @beca - @cuantia

		End
		Else
		Begin

			Print(Concat('Ohhh!!!, No tenemos dinero suficiente para asignar la beca al alumno ', @nombre, '. Ha solicitado ', @cuantia, ' y disponemos de ', @beca))
			Print('')

		End

		Fetch cAlumnos into @dni, @nombre, @nota, @cuantia

	End

	Close cAlumnos
	Deallocate cAlumnos

	Print(Concat('Han sobrado ', @beca, ' € de la beca'))
	Print('')

End

Execute asignarBecaRubenGarcia @beca = 520

Begin Transaction
RollBack

Select * From AlumnosConBeca Order By cuantia desc
Select * From AlumnoSolicitante Order by nota desc, nombre
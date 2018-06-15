package com.example.alam.proyectofinaldb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data_utilities.creaTablaUsuarios);
        db.execSQL(Data_utilities.creaTablaPeliculas);
        db.execSQL(Data_utilities.creaTablaSeries);
        db.execSQL(Data_utilities.creaTablaTemporadas);
        db.execSQL(Data_utilities.creaTablaCapitulos);
        db.execSQL(Data_utilities.creaTablaPeliculasUsuarios);
        db.execSQL(Data_utilities.creaTablaCapitulosUsuarios);
        db.execSQL(Data_utilities.creaTablaCriticas);
        db.execSQL(Data_utilities.creaTablaSubtitulos);

        //Llenando tabla Usuarios
        db.execSQL("insert into "+Data_utilities.LlU+" values('1','Alam','grost1995@gmail.com','1995-06-18','1014180713Aa','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('2','Adrian','adrian@gmail.com','1998-03-07','Adrian123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('3','Edith','edith@gmail.com','1969-12-10','Edith123','500')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('4','Alondra','alondra@gmail.com','1996-05-27','Alondra123','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('5','Oscar','oscar@gmail.com','1995-01-28','Oscar123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('6','Omar','omar@gmail.com','1994-11-01','Omar123','10')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('7','Prueba','aldp@admin.com','1994-11-01','Admin123','10')");

        //Llenando tabla Peliculas
        db.execSQL("insert into "+Data_utilities.LlP+" values('1','Avengers','Acción','Los vengadores se unsen por primera vez','Inglés','2012-05-04','10','R.drawable.avengers')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('2','Thor','Acción','Un dios se convierte en super heroe','Inglés','2011-05-06','10','R.drawable.thor')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('3','Los Goonies','Aventura','Un grupo de niños buscan un tesoro','Inglés','1985-05-04','10','R.drawable.goonies')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('4','Narnia','Aventura','Cuatro niños viajan en un ropero mágico','Inglés','2005-12-09','10','R.drawable.narnia')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('5','Up','Animación','Un niño y un viejo viajan en una casa voladora','Inglés','2009-05-24','10','R.drawable.up')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('6','Buscando a Nemo','Animación','Un pez busca a su pececito perdido','Inglés','2003-07-04','10','R.drawable.nemo')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('7','Hangover','Comedia','Un grupo de amigos son drogados en una despedida de soltero','Inglés','2009-05-14','10','R.drawable.hangover')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('8','Scary Movie','Comedia','Una pelicula con muchas parodias a peliculas de terror','Inglés','2000-08-04','10','R.drawable.scarymovie')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('9','Inside job','Documental','¿A quién le importan los documentales?','Inglés','2010-05-04','10','R.drawable.insidejob')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('10','Indie game','Documental','Bueno sólo este documental','Inglés','2012-05-18','10','R.drawable.indie')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('11','Forrest Gump','Drama','Un retrasado mental impone la cultura pop de Estados Unidos','Inglés','1994-05-23','10','R.drawable.forrest')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('12','El pianista','Drama','No disparen, no soy nazi','Inglés','2003-03-21','10','R.drawable.pianista')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('13','El exorcista','Horror','Un sacerdote pelea a muerte con una niña poseida','Inglés','1973-03-09','10','R.drawable.exorcista')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('14','El conjuro','Horror','Ya no me acuerdo, no da miedo','Inglés','2013-08-23','10','R.drawable.conjuro')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('15','Mary Poppins','Musical','Unos niños de Londres se divierten con una niñera maravillosa','Inglés','1965-09-16','10','R.drawable.mary')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('16','El mago de Oz','Musical','Un tornado lleva una chica de Kansas al mundo mágico de Oz','Inglés','1939-01-01','10','R.drawable.oz')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('17','Titanic','Romance','Una joven abandona a su arrogante pretendiente por un artista, todos mueren','Inglés','1998-01-01','10','R.drawable.titanic')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('18','Tres metros sobre el cielo','Romance','Un joven iracundose enamora de una niña rica.','Español','2012-01-20','10','R.drawable.tres')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('19','Alien','Ciencia ficción','Siete pasajeros o son ocho?','Inglés','1979-11-21','10','R.drawable.alien')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('20','Regreso al futuro','Ciencia ficción','Un joven se enoja si le dicen gallina, termina mal','Inglés','1985-07-03','10','R.drawable.volver')");

        //Llenando tabla Series
        db.execSQL("insert into "+Data_utilities.LlS+" values('1','Happy','Drama','Un Expolicia alcoholico se cree loco cuando un unicornio le ruega que salve a una niña','Inglés','2017-07-03','8.0','R.drawable.happy')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('2','El tirador','Acción','Un marine retirado regresa a la accion','Inglés','2018-03-05','8.8','R.drawable.tirador')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('3','Luck Cage','Acción','Ex convicto lucha por limpiar su nombre','Inglés','2016-08-23','9.0','R.drawable.luck')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('4','Marco Polo','Aventura','Aventuras del aventurero Marco Polo','Inglés','2017-09-05','8.2','R.drawable.marco')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('5','Punisher','Musical','Un exmarine pretende descargar su furia contra los criminales','Inglés','2017-02-13','8.6','R.drawable.punisher')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('6','Troya','Aventura','En busca de la mujer prometida por afrodita','Inglés','2018-01-15','8.4','R.drawable.troya')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('7','Rick y Morty','Musical','Las historias de un cientifico brillante y su descendiente mas tonto','Inglés','2015-05-03','9.5','R.drawable.rick')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('8','Hora de aventura','Animación','Las aventuras de un niño y su perro','Inglés','2014-08-12','8.9','R.drawable.hora')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('9','Un show mas','Animación','Las venturas de unos amigos en un parque','Inglés','2014-14-23','9.0','R.drawable.show')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('10','El principe del Rap','Comedia','Él es un sabelotodo de Filadelfia','Inglés','1995-03-05','8.8','R.drawable.principe')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('11','F.R.I.E.N.D.S','Comedia','Un grupo de amigos que viven en Manhattan','Inglés','2017-07-03','8.0','R.drawable.friends')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('12','Club de Cuervos','Documental','Hermanos y rivales por manejar un equipo de futbol','Español','2017-11-25','8.6','R.drawable.club')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('13','Orange is de new black','Documental','Mercy no merece su condena','Inglés','2017-07-03','9.0','R.drawable.orage')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('14','Better call Saul','Drama','La historia de un abogado llamado Jimmy','Inglés','2017-03-05','9.4','R.drawable.better')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('15','Weeds','Romance','Mujer cambia el luto por el canabbis','Inglés','2012-01-21','8.0','R.drawable.weeds')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('16','Stranger things','Romance','Algo esta pasando y nadia sabe que es','Inglés','2017-11-07','9.5','R.drawable.stranger')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('17','Black Mirror','Ciencia ficción','El futuro y la tecnologia estan mas cerca de lo que crees','Inglés','2017-07-03','9.0','R.drawable.blackM')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('18','The Rain','Ciencia ficción','La lluvia es mortal y los extraños tambien','Inglés','2018-03-25','8.7','R.drawable.rain')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('19','Residue','Horror','Imagenes paranormales grabadas comprueban que las imagenes no mienten','Inglés','2015-12-03','8.0','R.drawable.residue')");
        db.execSQL("insert into "+Data_utilities.LlS+" values('20','Black','Horror','Un hombre poseido por la muerte y una mujer capaz de preverlo','Inglés','2017-07-05','7.8','R.drawable.black')");

        //Llenando tabla temporadas
        db.execSQL("insert into "+Data_utilities.LlT+" values('1','Happy T1','2017-12-06','2017-05-15',null,'1')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('2','Happy T2','2017-12-06','2017-05-15',null,'1')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('3','El tirador T1','2018-03-25','2017-05-15',null,'2')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('4','El tirador T2','2017-12-06','2017-05-15',null,'2')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('5','Luck Cage T1','2017-12-06','2017-05-15',null,'3')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('6','Luck Cage T2','2017-12-06','2017-05-15',null,'3')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('7','Marco Polo T1','2017-12-06','2017-05-15',null,'4')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('8','Marco Polo T2','2017-12-06','2017-05-15',null,'4')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('9','Punisher T1','2017-12-06','2017-05-15',null,'5')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('10','Punisher T2','2017-12-06','2017-05-15',null,'5')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('11','Troya T1','2017-12-06','2017-05-15',null,'6')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('12','Troya T2','2017-12-06','2017-05-15',null,'6')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('13','Rick y Morty T1','2017-12-06','2017-05-15',null,'7')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('14','Rick y Morty T2','2017-12-06','2017-05-15',null,'7')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('15','Hora de aventura T1','2017-12-06','2017-05-15',null,'8')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('16','Hora de aventura T2','2017-12-06','2017-05-15',null,'8')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('17','Un show mas T1','2017-12-06','2017-05-15',null,'9')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('18','Un show mas T2','2017-12-06','2017-05-15',null,'9')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('19','El principe del rap T1','2017-12-06','2017-05-15',null,'10')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('20','El principe del rap T2','2018-03-25','2017-05-15',null,'10')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('21','F.R.I.E.N.D.S T1','2017-12-06','2017-05-15',null,'11')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('22','F.R.I.E.N.D.S T2','2017-12-06','2017-05-15',null,'11')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('23','Club de Cuervos T1','2018-03-25','2017-05-15',null,'12')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('24','Club de Cuervos T2','2017-12-06','2017-05-15',null,'12')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('25','Orange is de new black T1','2017-12-06','2017-05-15',null,'13')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('26','Orange is de new black T2','2017-12-06','2017-05-15',null,'13')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('27','Better call Saul T1','2017-12-06','2017-05-15',null,'14')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('28','Better call Saul T2','2017-12-06','2017-05-15',null,'14')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('29','Weeds T1','2017-12-06','2017-05-15',null,'15')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('30','Weeds T2','2017-12-06','2017-05-15',null,'15')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('31','Stranger things T1','2017-12-06','2017-05-15',null,'16')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('32','Stranger things T2','2017-12-06','2017-05-15',null,'16')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('33','Black Mirror T1','2017-12-06','2017-05-15',null,'17')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('34','Black Mirror T2','2017-12-06','2017-05-15',null,'17')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('35','The Rain T1','2017-12-06','2017-05-15',null,'18')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('36','The Rain T2','2017-12-06','2017-05-15',null,'18')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('37','Residue T1','2017-12-06','2017-05-15',null,'19')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('38','Residue T2','2017-12-06','2017-05-15',null,'19')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('39','Black T1','2017-12-06','2017-05-15',null,'20')");
        db.execSQL("insert into "+Data_utilities.LlT+" values('40','Black T2','2018-03-25','2017-05-15',null,'20')");

        //Llenando tabla capitulos
        db.execSQL("insert into "+Data_utilities.LlC+" values('1','Capitulo 1','30min','10','Pasan cosas en el capitulo','1',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('2','Capitulo 2','27min','10','Pasan cosas en el capitulo','1',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('3','Capitulo 3','30min','10','Pasan cosas en el capitulo','2',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('4','Capitulo 4','27min','10','Pasan cosas en el capitulo','2',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('5','Capitulo 1','30min','10','Pasan cosas en el capitulo','3',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('6','Capitulo 2','27min','10','Pasan cosas en el capitulo','3',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('7','Capitulo 3','30min','10','Pasan cosas en el capitulo','4',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('8','Capitulo 4','27min','10','Pasan cosas en el capitulo','4',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('9','Capitulo 1','30min','10','Pasan cosas en el capitulo','5',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('10','Capitulo 2','27min','10','Pasan cosas en el capitulo','5',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('11','Capitulo 3','30min','10','Pasan cosas en el capitulo','6',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('12','Capitulo 4','27min','10','Pasan cosas en el capitulo','6',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('13','Capitulo 1','30min','10','Pasan cosas en el capitulo','7',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('14','Capitulo 2','27min','10','Pasan cosas en el capitulo','7',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('15','Capitulo 3','30min','10','Pasan cosas en el capitulo','8',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('16','Capitulo 4','27min','10','Pasan cosas en el capitulo','8',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('17','Capitulo 1','30min','10','Pasan cosas en el capitulo','9',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('18','Capitulo 2','27min','10','Pasan cosas en el capitulo','9',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('19','Capitulo 3','30min','10','Pasan cosas en el capitulo','10',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('20','Capitulo 4','27min','10','Pasan cosas en el capitulo','10',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('21','Capitulo 1','30min','10','Pasan cosas en el capitulo','11',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('22','Capitulo 2','27min','10','Pasan cosas en el capitulo','11',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('23','Capitulo 3','30min','10','Pasan cosas en el capitulo','12',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('24','Capitulo 4','27min','10','Pasan cosas en el capitulo','12',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('25','Capitulo 1','30min','10','Pasan cosas en el capitulo','13',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('26','Capitulo 2','27min','10','Pasan cosas en el capitulo','13',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('27','Capitulo 3','30min','10','Pasan cosas en el capitulo','14',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('28','Capitulo 4','27min','10','Pasan cosas en el capitulo','14',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('29','Capitulo 1','30min','10','Pasan cosas en el capitulo','15',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('30','Capitulo 2','27min','10','Pasan cosas en el capitulo','15',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('31','Capitulo 3','30min','10','Pasan cosas en el capitulo','16',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('32','Capitulo 4','27min','10','Pasan cosas en el capitulo','16',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('33','Capitulo 1','30min','10','Pasan cosas en el capitulo','17',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('34','Capitulo 2','27min','10','Pasan cosas en el capitulo','17',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('35','Capitulo 3','30min','10','Pasan cosas en el capitulo','18',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('36','Capitulo 4','27min','10','Pasan cosas en el capitulo','18',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('37','Capitulo 1','30min','10','Pasan cosas en el capitulo','19',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('38','Capitulo 2','27min','10','Pasan cosas en el capitulo','19',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('39','Capitulo 3','30min','10','Pasan cosas en el capitulo','20',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('40','Capitulo 4','27min','10','Pasan cosas en el capitulo','20',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('41','Capitulo 1','30min','10','Pasan cosas en el capitulo','21',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('42','Capitulo 2','27min','10','Pasan cosas en el capitulo','21',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('43','Capitulo 3','30min','10','Pasan cosas en el capitulo','22',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('44','Capitulo 4','27min','10','Pasan cosas en el capitulo','22',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('45','Capitulo 1','30min','10','Pasan cosas en el capitulo','23',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('46','Capitulo 2','27min','10','Pasan cosas en el capitulo','23',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('47','Capitulo 3','30min','10','Pasan cosas en el capitulo','24',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('48','Capitulo 4','27min','10','Pasan cosas en el capitulo','24',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('49','Capitulo 1','30min','10','Pasan cosas en el capitulo','25',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('50','Capitulo 2','27min','10','Pasan cosas en el capitulo','25',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('51','Capitulo 3','30min','10','Pasan cosas en el capitulo','26',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('52','Capitulo 4','27min','10','Pasan cosas en el capitulo','26',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('53','Capitulo 1','30min','10','Pasan cosas en el capitulo','27',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('54','Capitulo 2','27min','10','Pasan cosas en el capitulo','27',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('55','Capitulo 3','30min','10','Pasan cosas en el capitulo','28',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('56','Capitulo 4','27min','10','Pasan cosas en el capitulo','28',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('57','Capitulo 1','30min','10','Pasan cosas en el capitulo','29',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('58','Capitulo 2','27min','10','Pasan cosas en el capitulo','29',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('59','Capitulo 3','30min','10','Pasan cosas en el capitulo','30',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('60','Capitulo 4','27min','10','Pasan cosas en el capitulo','30',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('61','Capitulo 1','30min','10','Pasan cosas en el capitulo','31',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('62','Capitulo 2','27min','10','Pasan cosas en el capitulo','31',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('63','Capitulo 3','30min','10','Pasan cosas en el capitulo','32',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('64','Capitulo 4','27min','10','Pasan cosas en el capitulo','32',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('65','Capitulo 1','30min','10','Pasan cosas en el capitulo','33',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('66','Capitulo 2','27min','10','Pasan cosas en el capitulo','33',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('67','Capitulo 3','30min','10','Pasan cosas en el capitulo','34',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('68','Capitulo 4','27min','10','Pasan cosas en el capitulo','34',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('69','Capitulo 1','30min','10','Pasan cosas en el capitulo','35',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('70','Capitulo 2','27min','10','Pasan cosas en el capitulo','35',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('71','Capitulo 3','30min','10','Pasan cosas en el capitulo','36',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('72','Capitulo 4','27min','10','Pasan cosas en el capitulo','36',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('73','Capitulo 1','30min','10','Pasan cosas en el capitulo','37',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('74','Capitulo 2','27min','10','Pasan cosas en el capitulo','37',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('75','Capitulo 3','30min','10','Pasan cosas en el capitulo','38',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('76','Capitulo 4','27min','10','Pasan cosas en el capitulo','38',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('77','Capitulo 1','30min','10','Pasan cosas en el capitulo','39',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('78','Capitulo 2','27min','10','Pasan cosas en el capitulo','39',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('79','Capitulo 3','30min','10','Pasan cosas en el capitulo','40',null)");
        db.execSQL("insert into "+Data_utilities.LlC+" values('80','Capitulo 4','27min','10','Pasan cosas en el capitulo','40',null)");

        //Llenando tabla Usuarios
        db.execSQL("insert into "+Data_utilities.LlSUB+" values('1','Español','Pedro','10',null,null)");
        db.execSQL("insert into "+Data_utilities.LlSUB+" values('2','Frances','Peter','10',null,null)");
        db.execSQL("insert into "+Data_utilities.LlSUB+" values('3','Portuges','Pedrinho','10',null,null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Data_utilities.tablaUsuarios);
        db.execSQL("drop table if exists " + Data_utilities.tablaPeliculas);
        db.execSQL("drop table if exists " + Data_utilities.tablaSeries);
        db.execSQL("drop table if exists " + Data_utilities.tablaTempoaradas);
        db.execSQL("drop table if exists " + Data_utilities.tablaCapitulos);
        db.execSQL("drop table if exists " + Data_utilities.tablaPeliculasUsuarios);
        db.execSQL("drop table if exists " + Data_utilities.tablaCapitulosUsuarios);
        db.execSQL("drop table if exists " + Data_utilities.tablaCriticas);
        db.execSQL("drop table if exists " + Data_utilities.tablaSubtitulos);
        onCreate(db);
    }
}

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

        db.execSQL("insert into "+Data_utilities.LlU+" values('1','Alam','grost1995@gmail.com','1995-06-18','1014180713Aa','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('2','Adrian','adrian@gmail.com','1998-03-07','Adrian123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('3','Edith','edith@gmail.com','1969-12-10','Edith123','500')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('4','Alondra','alondra@gmail.com','1996-05-27','Alondra123','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('5','Oscar','oscar@gmail.com','1995-01-28','Oscar123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('6','Omar','omar@gmail.com','1994-11-01','Omar123','10')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('7','Prueba','aldp@admin.com','1994-11-01','Admin123','10')");


        db.execSQL("insert into "+Data_utilities.LlP+" values('1','Avengers','Acción','Los vengadores se unsen por primera vez','Inglés','2012-05-04','10','R.drawable.avengers')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('2','Thor','Acción','Un dios se convierte en super heroe','Inglés','2011-05-06','10','R.drawable.thor')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('3','Los Goonies','Aventura','Un grupo de niños buscan un tesoro','Inglés','1985-05-04','10','R.drawable.goonies')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('4','Narnia','Aventura','Cuatro niños viajan en un ropero mágico','Inglés','2005-12-09','10','R.drawable.narnia')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('5','Up','Animación','Un niño y un viejo viajan en una casa voladora','Inglés','2009-05-24','10','R.drawable.up')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('6','Nemo','Animación','Un pez busca a su pececito perdido','Inglés','2003-07-04','10','R.drawable.nemo')");
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

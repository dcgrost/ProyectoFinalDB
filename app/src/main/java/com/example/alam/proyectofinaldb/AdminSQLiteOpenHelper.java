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

        db.execSQL("insert into "+Data_utilities.LlU+" values('500','Alam','grost1995@gmail.com','1995-06-18','1014180713Aa','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('501','Adrian','adrian@gmail.com','1998-03-07','Adrian123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('502','Edith','edith@gmail.com','1969-12-10','Edith123','500')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('503','Alondra','alondra@gmail.com','1996-05-27','Alondra123','1000')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('504','Oscar','oscar@gmail.com','1995-01-28','Oscar123','100')");
        db.execSQL("insert into "+Data_utilities.LlU+" values('505','Omar','omar@gmail.com','1994-11-01','Omar123','10')");


        db.execSQL("insert into "+Data_utilities.LlP+" values('500','Avengers','Acción','Los vengadores se unsen por primera vez','Inglés','2012-05-04','10','R.drawable.avengers')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('501','Thor','Acción','Un dios se convierte en super heroe','Inglés','2011-05-06','10','R.drawable.thor')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('502','Los Goonies','Aventura','Un grupo de niños buscan un tesoro','Inglés','1985-05-04','10','R.drawable.goonies')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('504','Narnia','Aventura','Cuatro niños viajan en un ropero mágico','Inglés','2005-12-09','10','R.drawable.narnia')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('503','Up','Animación','Un niño y un viejo viajan en una casa voladora','Inglés','2009-05-24','10','R.drawable.up')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('505','Nemo','Animación','Un pez busca a su pececito perdido','Inglés','2003-07-04','10','R.drawable.nemo')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('506','Hangover','Comedia','Un grupo de amigos son drogados en una despedida de soltero','Inglés','2009-05-14','10','R.drawable.hangover')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('507','Scary Movie','Comedia','Una pelicula con muchas parodias a peliculas de terror','Inglés','2000-08-04','10','R.drawable.scarymovie')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('508','Inside job','Documental','¿A quién le importan los documentales?','Inglés','2010-05-04','10','R.drawable.insidejob')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('509','Indie game','Documental','Bueno sólo este documental','Inglés','2012-05-18','10','R.drawable.indie')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('510','Forrest Gump','Drama','Un retrasado mental impone la cultura pop de Estados Unidos','Inglés','1994-05-23','10','R.drawable.forrest')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('511','El pianista','Drama','No disparen, no soy nazi','Inglés','2003-03-21','10','R.drawable.pianista')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('512','El exorcista','Horror','Un sacerdote pelea a muerte con una niña poseida','Inglés','1973-03-09','10','R.drawable.exorcista')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('513','El conjuro','Horror','Ya no me acuerdo, no da miedo','Inglés','2013-08-23','10','R.drawable.conjuro')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('514','Mary Poppins','Musical','Unos niños de Londres se divierten con una niñera maravillosa','Inglés','1965-09-16','10','R.drawable.mary')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('515','El mago de Oz','Musical','Un tornado lleva una chica de Kansas al mundo mágico de Oz','Inglés','1939-01-01','10','R.drawable.oz')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('516','Titanic','Romance','Una joven abandona a su arrogante pretendiente por un artista, todos mueren','Inglés','1998-01-01','10','R.drawable.titanic')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('517','Tres metros sobre el cielo','Romance','Un joven iracundose enamora de una niña rica.','Español','2012-01-20','10','R.drawable.tres')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('518','Alien','Ciencia ficción','Siete pasajeros o son ocho?','Inglés','1979-11-21','10','R.drawable.alien')");
        db.execSQL("insert into "+Data_utilities.LlP+" values('519','Regreso al futuro','Ciencia ficción','Un joven se enoja si le dicen gallina, termina mal','Inglés','1985-07-03','10','R.drawable.volver')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Data_utilities.tablaUsuarios);
        db.execSQL("drop table if exists " + Data_utilities.tablaPeliculas);
        db.execSQL("drop table if exists " + Data_utilities.tablaSeries);
        onCreate(db);
    }
}

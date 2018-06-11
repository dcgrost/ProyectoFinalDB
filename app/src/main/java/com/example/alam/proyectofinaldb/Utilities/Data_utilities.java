package com.example.alam.proyectofinaldb.Utilities;

public class Data_utilities {

    //Tabla Usuario
    public static final String tablaUsuarios = "Usuarios";
    public static final String UcampoId = "usuarios_id";
    public static final String UcampoNombre = "usuarios_nombre";
    public static final String UcampoCorreo = "usuarios_correo";
    public static final String UcampoFechaN = "usuarios_fechaN";
    public static final String UcampoContra = "usuarios_contraseña";
    public static final String UcampoSaldo = "usuarios_saldo";

    public static final String creaTablaUsuarios = "create table "+ tablaUsuarios +" ( "
            + UcampoId +" integer primary key autoincrement, "
            + UcampoNombre +" varchar(75) not null, "
            + UcampoCorreo +" varchar(30) not null, "
            + UcampoFechaN +" date not null, "
            + UcampoContra +" varchar(20) not null, "
            + UcampoSaldo +" real not null)";

    //Tabla Peliculas
    public static final String tablaPeliculas = "Peliculas";
    public static final String PcampoId = "peliculas_id";
    public static final String PcampoTitulo = "peliculas_titulo";
    public static final String PcampoGenero = "peliculas_genero";
    public static final String PcampoSinopsis = "peliculas_sinopsis";
    public static final String PcampoIdiomaOriginal = "peliculas_idiomaOriginal";
    public static final String PcampoFechaEstreno = "peliculas_fechaEstreno";
    public static final String PcampoPrecio = "peliculas_precio";
    public static final String PcampoImg= "peliculas_img";

    public static final String creaTablaPeliculas = "create table "+ tablaPeliculas +" ( "
            + PcampoId +" integer primary key autoincrement, "
            + PcampoTitulo +" varchar(50) not null, "
            + PcampoGenero +"  varchar(20) not null, "
            + PcampoSinopsis +" varchar(255) not null, "
            + PcampoIdiomaOriginal +" varchar(255) not null, "
            + PcampoFechaEstreno +" date not null, "
            + PcampoPrecio +" real not null, "
            + PcampoImg +" text not null)";

    //Tabla Series
    public static final String tablaSeries = "Series";
    public static final String ScampoId = "series_id";
    public static final String ScampoTitulo = "series_titulo";
    public static final String ScampoGenero = "series_genero";
    public static final String ScampoSinopsis = "series_sinopsis";
    public static final String ScampoIdiomaOriginal = "series_idiomaOriginal";
    public static final String ScampoFechaEstreno = "series_fechaEstreno";

    public static final String creaTablaSeries = "create table "+ tablaSeries +" ( "
            + ScampoId +" integer primary key autoincrement, "
            + ScampoTitulo +" varchar(50) not null, "
            + ScampoGenero +" varchar(20) not null, "
            + ScampoSinopsis +" varchar(255) not null, "
            + ScampoIdiomaOriginal +" varchar(255) not null, "
            + ScampoFechaEstreno +" date not null)";

    //Tabla Temporadas
    public static final String tablaTempoaradas = "Temporadas";
    public static final String TcampoId = "temporadas_id";
    public static final String TcampoTitulo = "temporadas_titulo";
    public static final String TcampoFechaEstreno = "temporadas_fechaEstreno";
    public static final String TcampoFechaProduccion = "temporadas_fechaProduccion";
    public static final String TcampoImagen = "temporadas_img";
    public static final String TcampoSeriesID= "temporadas_series_id";

    public static final String creaTablaTemporadas = "create table "
            + tablaTempoaradas +" ("
            + TcampoId +" integer primary key autoincrement, "
            + TcampoTitulo +" varchar(50) not null, "
            + TcampoFechaEstreno +" date not null, "
            + TcampoFechaProduccion +" date not null, "
            + TcampoImagen +" text not null, "
            + TcampoSeriesID +" integer, "
            + " FOREIGN KEY ("+TcampoSeriesID+") REFERENCES "+tablaSeries+"("+ ScampoId +"));";

    //Tabla Capitulos
    public static final String tablaCapitulos = "Capitulos";
    public static final String CcampoId = "capitulos_id";
    public static final String CcampoTitulo = "capitulos_titulo";
    public static final String CcampoDuracion = "capitulos_duracion";
    public static final String CcampoPrecio = "capitulos_precio";
    public static final String CcampoSinopsis = "capitulos_sinopsis";
    public static final String CcampoTemporadasID= "capitulos_temporadas_id";

    public static final String creaTablaCapitulos = "create table "
            + tablaCapitulos +" ("
            + CcampoId + " integer primary key autoincrement, "
            + CcampoTitulo +" varchar(50) not null, "
            + CcampoDuracion +" varchar(10) not null, "
            + CcampoPrecio +" real not null, "
            + CcampoSinopsis +" text not null, "
            + CcampoTemporadasID +" integer, " +
            " foreign key ('"+ CcampoTemporadasID +"') references '"+ tablaSeries +"'('"+ TcampoId +"'));";

    //Tabla PeliculasUsuarios
    public static final String tablaPeliculasUsuarios = "PeliculasUsuarios";
    public static final String PUcampoId = "peliculasUsuarios_id";
    public static final String PUcampoUsuariosID = "peliculasUsuarios_usuarios_id";
    public static final String PUcampoPeliculasID = "peliculasUsuarios_peliculas_id";

    public static final String creaTablaPeliculasUsuarios = "create table "
            + tablaPeliculasUsuarios +" ("
            + PUcampoId + " integer primary key autoincrement, "
            + PUcampoUsuariosID +" integer, "
            + PUcampoPeliculasID +" integer, " +
            " foreign key ('"+ PUcampoUsuariosID +"') references '"+ tablaUsuarios +"'('"+ UcampoId +"'), " +
            " foreign key ('"+ PUcampoPeliculasID +"') references '"+ tablaPeliculas +"'('"+ PcampoId +"'));";

    //Tabla CapitulosUsuarios
    public static final String tablaCapitulosUsuarios = "CapitulosUsuarios";
    public static final String CUcampoId = "seriesUsuarios_id";
    public static final String CUcampoUsuariosID = "seriesUsuarios_usuarios_id";
    public static final String CUcampoCapitulosID = "seriesUsuarios_series_id";

    public static final String creaTablaCapitulosUsuarios = "create table "
            + tablaCapitulosUsuarios +" ("
            + CUcampoId + " integer primary key autoincrement, "
            + CUcampoUsuariosID +" integer, "
            + CUcampoCapitulosID +" integer, " +
            " foreign key ('"+ CUcampoUsuariosID +"') references '"+ tablaUsuarios +"'('"+ UcampoId +"'), " +
            " foreign key ('"+ CUcampoCapitulosID +"') references '"+ tablaCapitulos +"'('"+ CcampoId +"'));";

    //Tabla Criticas
    public static final String tablaCriticas = "Criticas";
    public static final String CRcampoId = "criticas_id";
    public static final String CRcampoComentario = "criticas_comentario";
    public static final String CRcampoFecha = "criticas_fecha";
    public static final String CRcampoUsuariosID = "criticas_usuario_id";
    public static final String CRcampoPeliculasID = "criticas_peliculas_id";
    public static final String CRcampoCapitulosID = "criticas_capitulos_id";

    public static final String creaTablaCriticas = "create table "
            + tablaCriticas +" ("
            + CRcampoId + " integer primary key autoincrement, "
            + CRcampoComentario +" text not null, "
            + CRcampoFecha +" date not null, "
            + CRcampoUsuariosID +" integer not null, "
            + CRcampoPeliculasID +" integer , "
            + CRcampoCapitulosID +" integer , " +
            " foreign key ('"+ CRcampoUsuariosID +"') references '"+ tablaUsuarios +"'('"+ UcampoId +"'), " +
            " foreign key ('"+ CRcampoPeliculasID +"') references '"+ tablaPeliculas +"'('"+ PcampoId +"'), " +
            " foreign key ('"+ CRcampoCapitulosID +"') references '"+ tablaCapitulos +"'('"+ CcampoId +"'));";

    //Tabla Subtitulos
    public static final String tablaSubtitulos = "Subtitulos";
    public static final String SUBcampoId = "subtitulos_id";
    public static final String SUBcampoIdioma = "subtitulos_idioma";
    public static final String SUBcampoAutor = "subtitulos_autor";
    public static final String SUBcampoPrecio = "subtitulos_precio";
    public static final String SUBcampoPeliculasID = "subtitulos_peliculas_id";
    public static final String SUBcampoCapitulosID = "subtitulos_capitulos_id";

    public static final String creaTablaSubtitulos = "create table "+ tablaSubtitulos +" ( "
            + SUBcampoId + " integer primary key autoincrement, "
            + SUBcampoIdioma +" varchar(50) not null, "
            + SUBcampoAutor +" varchar(50) not null, "
            + SUBcampoPrecio +" real not null, "
            + SUBcampoPeliculasID +" integer, "
            + SUBcampoCapitulosID +" integer, " +
            " foreign key ('"+ SUBcampoPeliculasID +"') references '"+ tablaPeliculas +"'('"+ PcampoId +"'), " +
            " foreign key ('"+ SUBcampoCapitulosID +"') references '"+ tablaCapitulos +"'('"+ CcampoId +"'));";

    //Llenar tablaUsuarios
    public static final String LlU = ""+tablaUsuarios+"("+UcampoId+", "+UcampoNombre+", "+UcampoCorreo+", "+UcampoFechaN+", "+UcampoContra+", "+UcampoSaldo+")";
    //Llenar tablaPeliculas
    public static final String LlP = ""+tablaPeliculas+"("+PcampoId+", "+PcampoTitulo+", "+PcampoGenero+", "+PcampoSinopsis+", "+PcampoIdiomaOriginal+", "+PcampoFechaEstreno+", "+PcampoPrecio+","+PcampoImg+")";
}
package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by unkwon on 19/03/18.
 */

public class Connection  extends SQLiteOpenHelper {

    private static final String database = "database.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;
    SQLiteDatabase bd;

    public Connection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Connection(Context context) {
        super(context, database, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table administradores(documento INTEGER PRIMARY KEY, nombre text, apellido text, " +
                " nombreFinca text)");

        db.execSQL("create table trabajadores(documento INTEGER PRIMARY KEY, nombre text, apellido text, " +
                " edad text, idAdministrador INTEGER, " +
                "FOREIGN KEY (idAdministrador) REFERENCES administradores (documento) ON DELETE CASCADE)");

        db.execSQL("create table hectareas(idHectarea INTEGER PRIMARY KEY AUTOINCREMENT, idFoto INTEGER, idAdministrador INTEGER," +
                " FOREIGN KEY (idAdministrador) REFERENCES administradores (documento) ON DELETE CASCADE)");

        db.execSQL("create table materiales(idMaterial INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, cantidad text, " +
                " marca text, descripcion text, idAdministrador INTEGER," +
                " FOREIGN KEY (idAdministrador) REFERENCES administradores (documento) ON DELETE CASCADE)");


/*


        db.execSQL("create table cliente(documento INTEGER PRIMARY KEY, nombre text, apellido text, " +
                " fechanacimiento text,genero text, direccion text, telefono text)");

        db.execSQL("create table vendedor(documento INTEGER PRIMARY KEY, nombre text, apellido text," +
                " usuario text, password text, iva INTEGER)");

        db.execSQL("create table venta(id INTEGER PRIMARY KEY AUTOINCREMENT, fechaventa text," +
                " nombre text, cliente_id ,FOREIGN KEY (cliente_id) REFERENCES cliente (documento) ON DELETE CASCADE)");

        db.execSQL("create table producto(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, valor INTEGER, " +
                " total INTEGER,marca text, descripcion text, telefono text)");

        db.execSQL("insert into vendedor (documento,nombre,apellido,usuario,password,iva) values(1,'Juan David','Garzon','user','1234',20)");

*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists administradores");
        db.execSQL("drop table if exists trabajadores");
        db.execSQL("drop table if exists hectareas");
        db.execSQL("drop table if exists materiales");

        onCreate(db);
    }

    public void cerrarConexion() {
        bd.close();
    }

    public boolean ejecutarInsert(String tabla, ContentValues registro) {
        try {
            //Objeto para lectura y escritura en la base de datos
            bd = this.getWritableDatabase();
            //Se hace un insert indicando la tabla y mandando los datos,
            //el null es los campos que no se van a registrar
            int res = (int) bd.insert(tabla, null, registro);
            cerrarConexion();
            if (res != -1)
                return true;
            else
                return false;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean ejecutarUpdate(String tabla, String condicion, ContentValues registro) {
        try {
            bd = this.getWritableDatabase();
            int cant = bd.update(tabla, registro, condicion, null);
            if (cant == 1)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Cursor ejecutarSearch(String consulta) {
        try {
            //Objeto para lectura y escritura en la base de datos
            bd = this.getWritableDatabase();

            //Definimos un objeto de tipo cursor que almacena la nfo de la base de datos,
            //además ejecutamos una consulta sql
            //en el null se especifican los parámetros
            Cursor fila = bd.rawQuery(consulta, null);
            return fila;
        } catch (Exception e) {
            cerrarConexion();
            return null;
        }
    }

    public boolean ejecutarDelete(String tabla, String condicion){
        bd = this.getWritableDatabase();

        int cant = bd.delete(tabla, condicion, null);
        cerrarConexion();
        if (cant >= 1)
            return true;
        else
            return false;
    }

}

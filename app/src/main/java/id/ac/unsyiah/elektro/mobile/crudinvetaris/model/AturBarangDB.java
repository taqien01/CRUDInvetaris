package id.ac.unsyiah.elektro.mobile.crudinvetaris.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by taqien01 on 5/26/2016.
 */
public class AturBarangDB extends SQLiteOpenHelper {

    public static final int VERSI_DB = 1;
    public static final String NAMA_DB = "MobileJTE";

    public static final String TABEL_BARANG = "BARANG";

    public static final String ID_BARANG = "_id";
    public static final String KODE_SKU = "kode";
    public static final String NAMA_BARANG = "nama_db";
    public static final String JUMLAH = "jumlah";
    public static final String HARGA = "harga";
    public static final String GAMBAR = "gambar";

    public AturBarangDB(Context context){
        super(context, NAMA_DB, null, VERSI_DB);
    }

    public void onCreate(SQLiteDatabase db){
        final String buatDB = "CREATE TABLE IF NOT EXISTS " + TABEL_BARANG + " ( "
                + ID_BARANG + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KODE_SKU +" TEXT, "
                + NAMA_BARANG +" TEXT, "
                + JUMLAH +" TEXT, "
                + HARGA +" TEXT, "
                + GAMBAR + " TEXT "
                + ");";
        db.execSQL(buatDB);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){

    }
}

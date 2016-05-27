package id.ac.unsyiah.elektro.mobile.crudinvetaris;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.ac.unsyiah.elektro.mobile.crudinvetaris.model.AturBarangDB;
import id.ac.unsyiah.elektro.mobile.crudinvetaris.model.BarangCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listBarang = (ListView) findViewById(R.id.listBarang);

        SQLiteOpenHelper aturBarangDB = new AturBarangDB(this);
        db = aturBarangDB.getReadableDatabase();

        cursor = db.query(AturBarangDB.TABEL_BARANG,
                new String[]{AturBarangDB.ID_BARANG,
                             AturBarangDB.KODE_SKU,
                             AturBarangDB.NAMA_BARANG,
                             AturBarangDB.GAMBAR},
                null,
                null,
                null,
                null,
                AturBarangDB.NAMA_BARANG);

        BarangCursorAdapter barangCursorAdapter = new BarangCursorAdapter(this, cursor);

        listBarang.setAdapter(barangCursorAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View view,
                                            int nomorBerapa,
                                            long id) {

                        clickItemListBarang(listView, view, nomorBerapa, id);
                    }
                };
        listBarang.setOnItemClickListener(itemClickListener);

    }

    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

    public void clickItemListBarang(AdapterView<?> listView,
                                    View v,
                                    int position,
                                    long id){
        String kode = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.KODE_SKU));
        String nama = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.NAMA_BARANG));
        String gambar = cursor.getString(cursor.getColumnIndexOrThrow(AturBarangDB.GAMBAR));

        Intent pesan = new Intent(getApplicationContext(), DetailActivity.class);
        pesan.putExtra("id",id);
        startActivity(pesan);
    }

    public void clickTambah(View view){
        Intent pesan = new Intent(getApplicationContext(), TambahActivity.class);
        startActivity(pesan);
    }

    private SQLiteDatabase db;
    private Cursor cursor;
}

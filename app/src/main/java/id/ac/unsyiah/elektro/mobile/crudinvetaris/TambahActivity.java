package id.ac.unsyiah.elektro.mobile.crudinvetaris;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import id.ac.unsyiah.elektro.mobile.crudinvetaris.model.AturBarangDB;

/**
 * Created by taqien01 on 5/26/2016.
 */
public class TambahActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_tambah);
    }

    public void onClickTambah(View view){

        TextView txtNama = (TextView) findViewById(R.id.txtNama);
        String nama = txtNama.getText().toString();
        TextView txtKode = (TextView) findViewById(R.id.txtKode);
        String kode = txtKode.getText().toString();
        TextView txtJumlah = (TextView) findViewById(R.id.txtJumlah);
        String jumlah = txtJumlah.getText().toString();
        TextView txtHarga = (TextView) findViewById(R.id.txtHarga);
        String harga = txtHarga.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        //final int gambarInt = 0;
        int gambarInt = spinner.getSelectedItemPosition();
        String gambar = String.valueOf(gambarInt);

        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }else{
                    gambarInt = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
        //int gambarInt = spinner.getSelectedItemPosition();
        //String gambar = String.valueOf(gambarInt);


        SQLiteOpenHelper aturBarangDB = new AturBarangDB(this);
        SQLiteDatabase db = aturBarangDB.getWritableDatabase();

        ContentValues barangBaru = new ContentValues();
        barangBaru.put(AturBarangDB.KODE_SKU, kode);
        barangBaru.put(AturBarangDB.NAMA_BARANG, nama);
        barangBaru.put(AturBarangDB.JUMLAH, jumlah);
        barangBaru.put(AturBarangDB.HARGA, harga);
        barangBaru.put(AturBarangDB.GAMBAR, gambar);

        db.insert(AturBarangDB.TABEL_BARANG, null, barangBaru);
        db.close();

        Intent pesan = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(pesan);
        finish();


    }

}

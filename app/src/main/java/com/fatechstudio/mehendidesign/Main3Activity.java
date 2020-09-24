package com.fatechstudio.mehendidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    int message;
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
         message = intent.getIntExtra("Message",R.drawable.back1);

        photoView = findViewById(R.id.photoo);
        photoView.setImageResource(message);

    }
    public void flip(View V)
    {
        if(photoView.getScaleX() == 1 )
        {
            photoView.setScaleX(-1);
        }
        else
        {
            photoView.setScaleX(1);
        }

    }
    public void download(View V)
    {
        Resources resources = getResources();
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeResource(resources, message);
        saveImage2(bitmap);
        Toast.makeText(this,"Image Saved",Toast.LENGTH_LONG).show();

    }
    public void share(View V)
    {
        Resources resources = getResources();
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeResource(resources, message);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.jpg"));
        startActivity(Intent.createChooser(share, "Share Image"));

    }
    private  void saveImage2(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File myDir = new File(root + "/Mehendi Designs");
        Log.i("Directory", "==" + myDir);
        myDir.mkdirs();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fname = "Mehendi_"+ timeStamp +".jpg";

        File file = new File(myDir, fname);
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send() {
        try {
            File myFile = new File("/storage/emulated/0/saved_images/Image-test.jpg");
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            String ext = myFile.getName().substring(myFile.getName().lastIndexOf(".") + 1);
            String type = mime.getMimeTypeFromExtension(ext);
            Intent sharingIntent = new Intent("android.intent.action.SEND");
            sharingIntent.setType(type);
            sharingIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(myFile));
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        } catch (Exception e) {
            Toast.makeText(this,"Sorry This Feature is not Avaliable on your Phone",Toast.LENGTH_SHORT).show();
        }
    }

}

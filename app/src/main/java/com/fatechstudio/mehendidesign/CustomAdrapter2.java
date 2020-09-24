package com.fatechstudio.mehendidesign;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomAdrapter2 extends RecyclerView.Adapter<CustomAdrapter2.ViewHolder>  {
    int[] data;
    Context con;


    public CustomAdrapter2(Context context, int[] data)
    {
        this.data = data;
        this.con = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customlayout2,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.setIsRecyclable(true);
        try{
           holder.IImg.setImageResource(data[position]);
       }catch (Exception e)
       {
           holder.IImg.setImageResource(data[0]);
       }
        holder.zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con, Main3Activity.class);
                intent.putExtra("Message",data[position]);
                con.startActivity(intent);
            }
        });
        holder.flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.IImg.getScaleX() == 1 )
                {
                    holder.IImg.setScaleX(-1);
                }
                else
                {
                    holder.IImg.setScaleX(1);
                }

            }
        });
        holder.Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Resources resources = con.getResources();
                Bitmap bitmap;
                bitmap = BitmapFactory.decodeResource(resources, data[position]);
                saveImage2(bitmap);
                Toast.makeText(con,"Image Saved",Toast.LENGTH_LONG).show();
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resources resources = con.getResources();
                Bitmap bitmap;
                bitmap = BitmapFactory.decodeResource(resources, data[position]);
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
                con.startActivity(Intent.createChooser(share, "Share Image"));
            }
        });
       }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView Download;
        ImageView IImg;
        ImageView share;
        ImageView zoom;
        ImageView flip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            IImg = itemView.findViewById(R.id.quots);
            Download = itemView.findViewById(R.id.downloadd);
            share = itemView.findViewById(R.id.sharee);
            zoom = itemView.findViewById(R.id.Zoom);
            flip = itemView.findViewById(R.id.flip);
        }
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
            con.startActivity(Intent.createChooser(sharingIntent, "Share using"));
        } catch (Exception e) {
            Toast.makeText(con,"Sorry This Feature is not Avaliable on your Phone",Toast.LENGTH_SHORT).show();
        }
    }



}
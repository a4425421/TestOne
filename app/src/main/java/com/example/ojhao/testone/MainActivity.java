package com.example.ojhao.testone;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.main_button);
        final ImageView iv_main = (ImageView) findViewById(R.id.iv_main);

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
                final String URL = "http://14.156.68.253:8080/jsonProject/servlet/Login";
                final String URL2 = "http://14.156.68.253:8080/library/image/1.jpg";



                /*
                *

                1. 创建一个RequestQueue对象。

                2. 创建一个ImageLoader对象。

                3. 获取一个ImageListener对象。

                4. 调用ImageLoader的get()方法加载网络上的图片。
                 */
                ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
                    @Override
                    public Bitmap getBitmap(String url) {
                        return null;
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {

                    }
                });

                ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(iv_main,R.mipmap.ic_launcher,R.drawable.abc_textfield_search_material);

                imageLoader.get(URL2,imageListener,200,150);










//                /*第一个参数就是图片的URL地址，
//                第二个参数是图片请求成功的回调，这里我们把返回的Bitmap参数设置到ImageView中。
//                第三第四个参数分别用于指定允许图片最大的宽度和高度，如果指定的网络图片的宽度或高度大于这里的最大值，
//                    则会对图片进行压缩，指定成0的话就表示不管图片有多大，都不会进行压缩。
//                第五个参数用于指定图片的颜色属性，Bitmap.Config下的几个常量都可以在这里使用，
//                    其中ARGB_8888可以展示最好的颜色属性，每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大小。
//                第六个参数是图片请求失败的回调，这里我们当请求失败时在ImageView中显示一张默认图片。
//
//                 */
//
//                ImageRequest ImageRequest = new ImageRequest(URL2,new Response.Listener<Bitmap>() {
//                    @Override
//                    public void onResponse(Bitmap response) {
//                        iv_main.setImageBitmap(response);
//                        Log.i("start","ok");
//                    }
//                },200,150, Bitmap.Config.RGB_565,new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        iv_main.setImageResource(R.mipmap.ic_launcher);
//                        Log.i("start","false");
//                    }
//                });
//                mQueue.add(ImageRequest);


//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(URL, null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                Log.d("TAG", response.toString());
//                                Toast.makeText(MainActivity.this,"R:"+response.toString(),Toast.LENGTH_LONG);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                        Toast.makeText(MainActivity.this,"E:"+error.toString(),Toast.LENGTH_LONG);
//                    }
//                });
//                mQueue.add(jsonObjectRequest);


//                StringRequest stringRequest = new StringRequest(Request.Method.POST,URL,
//                        new Response.Listener<String>() {
//
//
//                            @Override
//                            public void onResponse(String response) {
//                                Log.d("TAG", response);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                    }
//                }){
//                    //重写StringRequest的getParams，添加Post参数
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("username", "h");
//                        map.put("password", "h");
//                        return map;
//                    }
//                };
//
//                mQueue.add(stringRequest);


            }
        });


    }






    /*
    图片压缩范例
     */

//    iv_main.setImageBitmap(
//    decodeSampledBitmapFromResource(getResources(), R.id.myimage, 100, 100));
//
//
//    //计算压缩比例 inSampleSize
//    public  static  int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
//        //源图片的宽高
//        final int height = options.outHeight;
//        final int width = options.outWidth;
//        int inSampleSize  =1 ;
//        if(height> reqHeight || width>reqWidth){
//            // 计算出实际宽高和目标宽高的比率
//            final int heightRatio = Math.round((float) height / (float) reqHeight);
//            final int widthRatio = Math.round((float) width / (float) reqWidth);
//            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
//            // 一定都会大于等于目标的宽和高。
//            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
//        }
//        return inSampleSize;
//    }
//
//
//
//    //设置好options后进行压缩
//    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
//                                                         int reqWidth, int reqHeight) {
//        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, resId, options);
//        // 调用上面定义的方法计算inSampleSize值
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//        // 使用获取到的inSampleSize值再次解析图片
//        options.inJustDecodeBounds = false;
//        return BitmapFactory.decodeResource(res, resId, options);
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


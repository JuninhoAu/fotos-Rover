package com.juni.roverphotos

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class PhotosFragment : Fragment() {


    private lateinit var imageView: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    //    val rootView= FragmentPhotosBinding.inflate(inflater)
        val  viewRoot= inflater.inflate(R.layout.fragment_photos, container, false)


        //  imageView=rootView.imgRover
        imageView=viewRoot.findViewById(R.id.imgv_rover)


        imageView.setImageURI(Uri.parse("https://lh3.googleusercontent.com/pw/ACtC-3f0oCTWqcLqOb47XI0cxmjWDfjbiLke0maPSPdC4jY_4PKdJIBAyQXV__sYUDbrfRctynBCdAN5selEMQPwOnI_kyioqhpGaqTBTTJP6FFPFF37coJUzb0MP5aSZIhjiXxVLRznFIVw_DbsyJNe1jLS=w1250-h938-no"))

        return viewRoot
    }

    fun setPhotos(photos: Photos){

       // Log.d("Hola",photos.img_src)

       // Toast.makeText(activity,photos.img_src, Toast.LENGTH_SHORT).show()
        Glide.with(this).load(photos.img_src).listener(object : RequestListener<Drawable> {

            override fun onLoadFailed(e: GlideException?,
                                      model: Any?,
                                      target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {



                showMsg("carga fallida"+e)
                Log.d("Hola","error:  "+e)



                return false
            }

            override fun onResourceReady(resource: Drawable?,
                                         model: Any?,
                                         target: Target<Drawable>?,
                                         dataSource: DataSource?,
                                         isFirstResource: Boolean): Boolean {



                return false
            }


        })//.error(R.drawable.ic_launcher_background)
        .into(imageView)

    }

    private fun showMsg(mensaje:String){

        Toast.makeText(activity,mensaje,Toast.LENGTH_SHORT).show()

    }


}
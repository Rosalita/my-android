package com.example.rosie.rosieapp
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.picture_page.*
import java.io.File


/**
 * Created by rosie on 15/02/2018.
 */
class PictureActivity : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture_page)
        pictureImageView.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.pictureImageView -> takePictureWithCamera()
            else -> println("No case satisfied")
        }
    }

    private fun takePictureWithCamera() {

        val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val imagePath = File(filesDir, "images")
        val newFile = File(imagePath, "default_image.jpg")
        if (newFile.exists()) {
            newFile.delete()
        } else {
            newFile.parentFile.mkdirs()
        }

        captureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        startActivityForResult(captureIntent, TAKE_PHOTO_REQUEST_CODE)
    }
}
const private val TAKE_PHOTO_REQUEST_CODE = 1
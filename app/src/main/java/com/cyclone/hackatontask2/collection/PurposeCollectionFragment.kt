package com.cyclone.hackatontask2.collection

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cyclone.hackatontask2.R
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.choose_type_collection_fragment.backButton
import kotlinx.android.synthetic.main.purpose_collection_fragment.*
import kotlinx.android.synthetic.main.purpose_collection_fragment.inputCollectionName
import kotlinx.android.synthetic.main.purpose_collection_fragment.inputDescription
import kotlinx.android.synthetic.main.purpose_collection_fragment.inputPurpose
import kotlinx.android.synthetic.main.purpose_collection_fragment.inputSum
import kotlinx.android.synthetic.main.purpose_collection_fragment.load_cover
import kotlinx.android.synthetic.main.regular_collection_fragment.*
import rx.Observable
import java.io.FileNotFoundException


class PurposeCollectionFragment : Fragment(R.layout.purpose_collection_fragment) {

    companion object {
        private const val PICK_PHOTO = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        nextButton.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("purpose_collection")
                .replace(R.id.collection_fragment, PurposeCollectionAdditionFragment()).commit()
        }

        load_cover.setOnClickListener {
            val openGallery = Intent().setType("image/*").setAction(Intent.ACTION_PICK)
            startActivityForResult(
                Intent.createChooser(openGallery, "Выберите фото"),
                PICK_PHOTO
            )
        }

        Observable.combineLatest(
            RxTextView.textChanges(inputSum),
            RxTextView.textChanges(inputPurpose),
            RxTextView.textChanges(inputCollectionName),
            RxTextView.textChanges(inputDescription)
        ) { t1, t2, t3, t4 ->
            nextButton.isEnabled =
                t1.isNotEmpty() && t2.isNotEmpty() && t3.isNotEmpty() && t4.isNotEmpty()
        }.subscribe()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICK_PHOTO -> {
                if (resultCode == RESULT_OK && data != null) {
                    try {
                        val path = data.data!!
                        Glide.with(context!!).load(path).apply(
                            RequestOptions().transform(CenterCrop(), RoundedCorners(10))
                        ).into(load_cover)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}
package com.cyclone.hackatontask2.purpose_regular.purpose

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.MainActivity
import com.cyclone.hackatontask2.purpose_regular.PurposeRegularPresenter
import com.cyclone.hackatontask2.purpose_regular.PurposeRegularView
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.choose_type_collection_fragment.backButton
import kotlinx.android.synthetic.main.purpose_collection_fragment.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import rx.Observable
import java.io.FileNotFoundException

class PurposeCollectionFragment : MvpAppCompatFragment(R.layout.purpose_collection_fragment),
    PurposeRegularView {

    companion object {
        private const val PICK_PHOTO = 1
    }

    @InjectPresenter
    lateinit var purposePresenter: PurposeRegularPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButton.setOnClickListener { (activity as MainActivity).presenter.toBackFragment() }

        nextButton.setOnClickListener { (activity as MainActivity).presenter.toPurposeAddFragment() }

        load_cover.setOnClickListener { openGallery() }

        Observable.combineLatest(
            RxTextView.textChanges(inputSum),
            RxTextView.textChanges(inputPurpose),
            RxTextView.textChanges(inputCollectionName),
            RxTextView.textChanges(inputDescription)
        ) { t1, t2, t3, t4 ->
            purposePresenter.switchButton(t1.isNotEmpty() && t2.isNotEmpty() && t3.isNotEmpty() && t4.isNotEmpty())
        }.subscribe()
    }

    private fun openGallery() {
        val openGallery = Intent().setType("image/*").setAction(Intent.ACTION_PICK)
        startActivityForResult(
            Intent.createChooser(openGallery, "Выберите фото"),
            PICK_PHOTO
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICK_PHOTO -> {
                if (resultCode == RESULT_OK && data != null) {
                    purposePresenter.loadCover(data.data)
                }
            }
        }
    }

    override fun loadCover(path: Uri?) {
        try {
            Glide.with(context!!).load(path).apply(
                RequestOptions().transform(CenterCrop(), RoundedCorners(10))
            ).into(load_cover)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    override fun isEnable(enable: Boolean) {
        nextButton.isEnabled = enable
    }
}
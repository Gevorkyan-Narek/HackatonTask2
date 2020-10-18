package com.cyclone.hackatontask2.purpose_regular.regular

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.BaseFragment
import com.cyclone.hackatontask2.purpose_regular.PurposeRegularPresenter
import com.cyclone.hackatontask2.purpose_regular.PurposeRegularView
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.choose_type_collection_fragment.backButton
import kotlinx.android.synthetic.main.regular_collection_fragment.*
import moxy.presenter.InjectPresenter
import rx.Observable

class RegularCollectionFragment : BaseFragment(R.layout.regular_collection_fragment),
    PurposeRegularView {

    companion object {
        private const val PICK_PHOTO = 1
    }

    @InjectPresenter
    lateinit var regularPresenter: PurposeRegularPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButton.setOnClickListener {
            navigateTo.backFragment()
        }

        createCollection.setOnClickListener {
            navigateTo.toMain()
        }

        load_cover.setOnClickListener {
            val openGallery = Intent().setType("image/*").setAction(Intent.ACTION_PICK)
            startActivityForResult(
                Intent.createChooser(openGallery, "Выберите фото"),
                PICK_PHOTO
            )
        }

        Observable.combineLatest(
            RxTextView.textChanges(inputAuthor),
            RxTextView.textChanges(inputSum),
            RxTextView.textChanges(inputPurpose),
            RxTextView.textChanges(inputCollectionName),
            RxTextView.textChanges(inputDescription)
        ) { t1, t2, t3, t4, t5 ->
            regularPresenter.switchButton(t1.isNotEmpty() && t2.isNotEmpty() && t3.isNotEmpty() && t4.isNotEmpty() && t5.isNotEmpty())
        }.subscribe()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICK_PHOTO -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    regularPresenter.loadCover(data.data)
                }
            }
        }
    }

    override fun loadCover(path: Uri?) {
        Glide.with(context!!).load(path).apply(
            RequestOptions().transform(CenterCrop(), RoundedCorners(10))
        ).into(load_cover)
    }

    override fun isEnable(enable: Boolean) {
        createCollection.isEnabled = enable
    }
}
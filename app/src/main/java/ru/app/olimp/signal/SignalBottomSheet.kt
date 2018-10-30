package ru.app.olimp.signal

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_bottom_signal.*
import ru.app.olimp.R

class SignalBottomSheet: BottomSheetDialogFragment() {

    companion object {

        const val TITLE = "key_title"
        const val DESCRIPTION = "key_description"
        const val IMAGE = "key_image"

        fun getInstance(model: SignalModel): SignalBottomSheet =
                SignalBottomSheet().apply {
                    arguments = Bundle().apply {
                        putString(TITLE, model.title)
                        putString(DESCRIPTION, model.description)
                        putInt(IMAGE, model.imageRes)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_signal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = arguments?.getInt(IMAGE) ?: R.drawable.sea
        Glide.with(requireContext()).load(imageView).into(image)
//        image.setImageResource(imageView)
        title.text = arguments?.getString(TITLE)
        description.text = arguments?.getString(DESCRIPTION)
    }
}

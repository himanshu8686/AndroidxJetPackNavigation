package com.androidxjetpacknavigation

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver){

    private lateinit var receiverName : String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       receiverName = et_receiver_name.text.toString()

        btn_next.setOnClickListener {
             this.receiverName = et_receiver_name.text.toString()

            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCashFragment(receiverName=receiverName,amount = 400)

            findNavController().navigate(action)

        }
    }
}
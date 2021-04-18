package com.androidxjetpacknavigation

import android.app.PendingIntent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {

    private lateinit var receiverName: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        receiverName = et_receiver_name.text.toString()

        btn_next.setOnClickListener {
            this.receiverName = et_receiver_name.text.toString()


            /*** use findNavController or NavDeepLinkBuilder ****/


//            val pendingIntentByNav = findNavController()
//                .createDeepLink()
//                .setGraph(R.navigation.main_nav_graph)
//                .createPendingIntent()

            val pendingIntent = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.main_nav_graph)
                .setDestination(R.id.sendCashFragment)
                .setArguments(SendCashFragmentArgs(receiverName).toBundle())
                .createPendingIntent()

            showNotification(pendingIntent,receiverName)

            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCashFragment(receiverName = receiverName)

            findNavController().navigate(action)

        }

        btn_cancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showNotification(pendingIntent: PendingIntent, receiverName: String) {
            val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Complete Transaction!!")
                .setContentText("Send money to $receiverName")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

        NotificationManagerCompat.from(requireContext()).notify(1002,notification)
    }
}
package com.example.fragmentexample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentNews : Fragment(R.layout.fragment_list_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsId = arrayOf(
            R.id.item_1_tv,
            R.id.item_2_tv,
            R.id.item_3_tv,
            R.id.item_4_tv,
            R.id.item_5_tv,
            R.id.item_6_tv
        )

        itemsId.forEachIndexed { index, id ->
            val itemTV = view.findViewById<TextView>(id)
            val news: News = Data.newsArrays[index]
            itemTV.text = news.header

            itemTV.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container_view, FragmentDetail.newInstance(news))
                    addToBackStack(null)
                    commit()
                }
            }
        }

    }

}
package com.example.fragmentexample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val DETAIL_NEWS_KEY = "key 1"

class FragmentDetail : Fragment(R.layout.fragment_detail_news) {

    companion object {
        fun newInstance(data: News) = FragmentDetail().apply {
            arguments = Bundle().apply {
                putSerializable(DETAIL_NEWS_KEY, data)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news: News = arguments?.getSerializable(DETAIL_NEWS_KEY) as News

        view.findViewById<TextView>(R.id.header_detail_tv).text = news.header
        view.findViewById<TextView>(R.id.author_detail_tv).text =
            getString(R.string.news_author, news.author)
        view.findViewById<TextView>(R.id.news_detail_tv).text = news.news
        view.findViewById<ImageView>(R.id.arrow_back_iv).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }

}
package com.rahmatprastyo.githubusers

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.rahmatprastyo.githubusers.adapter.MainAdapter
import com.rahmatprastyo.githubusers.model.MainResponse
import com.rahmatprastyo.githubusers.model.Result
import com.rahmatprastyo.githubusers.presenter.MainPresenter
import com.rahmatprastyo.githubusers.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter =  MainPresenter(this)

        //check data
        progress.visibility = View.VISIBLE
        if (TextUtils.isEmpty(etKeyword.text)) {
            progress.visibility = View.GONE
            Toast.makeText(this, "No data is being searched", Toast.LENGTH_LONG).show()
        } else {
            progress.visibility = View.VISIBLE
        }

        btnSearch.setOnClickListener {
            progress.visibility = View.VISIBLE
            if (TextUtils.isEmpty(etKeyword.text)) {
                progress.visibility = View.GONE
                etKeyword.error = "Field not empty!!"
            } else {
                progress.visibility = View.GONE
                val keyword = etKeyword.text.toString()
                presenter.discoverUsers(keyword)
            }
        }

    }

    override fun onShowLoading() {
        progress.visibility = View.GONE
    }

    override fun onHideLoading() {
        progress.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    override fun onResponse(results: List<Result>) {
        recycler.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        recycler.adapter = MainAdapter(results)
    }

    override fun onFailure(error: Throwable) {
        Toast.makeText(this@MainActivity, "" + error.message, Toast.LENGTH_LONG).show()
    }

    //toast jika request gagal karena lebih daru 10 kali
    override fun showToast(response: Response<MainResponse>) {
        if (response.isSuccessful) {
            onResponse(response.body()?.items ?: emptyList())
        } else{
            recycler.visibility = View.GONE
            Toast.makeText(this,"please wait 60 seconds more", Toast.LENGTH_LONG).show()
        }
    }
}

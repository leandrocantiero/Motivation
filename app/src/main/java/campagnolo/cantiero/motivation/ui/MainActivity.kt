package campagnolo.cantiero.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import campagnolo.cantiero.motivation.R
import campagnolo.cantiero.motivation.infra.Motivation
import campagnolo.cantiero.motivation.infra.Preferences
import campagnolo.cantiero.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSharedPreferences: Preferences
    private var mFraseFilter: Int = Motivation.fraseFilter.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSharedPreferences = Preferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        btnAddFrase.setOnClickListener(this)

        name.text = "Olá ${mSharedPreferences.getString(Motivation.key.PERSON_NAME)}"

        addFrase()
    }

    override fun onClick(view: View) {
        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageSun)

        if (view.id == R.id.btnAddFrase) {
            addFrase()
        } else if (view.id in listFilter) {
            handleFilter(view.id)
        }
    }

    private fun handleFilter(id: Int) {
        imageAll.setColorFilter(resources.getColor(R.color.white))
        imageHappy.setColorFilter(resources.getColor(R.color.white))
        imageSun.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.imageAll -> {
                mFraseFilter = Motivation.fraseFilter.ALL
                imageAll.setColorFilter(resources.getColor(R.color.colorAccent))
            }

            R.id.imageHappy -> {
                mFraseFilter = Motivation.fraseFilter.HAPPY
                imageHappy.setColorFilter(resources.getColor(R.color.colorAccent))
            }

            R.id.imageSun -> {
                mFraseFilter = Motivation.fraseFilter.SUN
                imageSun.setColorFilter(resources.getColor(R.color.colorAccent))
            }
        }
    }

    private fun addFrase() {
        textFrase.text = Mock().getPhrase(mFraseFilter)
    }
}